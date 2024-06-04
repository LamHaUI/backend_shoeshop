package com.thungashoe.store.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.thungashoe.store.domain.Article;
import com.thungashoe.store.domain.ArticleBuilder;
import com.thungashoe.store.domain.Brand;
import com.thungashoe.store.domain.Category;
import com.thungashoe.store.domain.Size;
import com.thungashoe.store.service.ArticleService;
import com.thungashoe.store.util.FileUploadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/add")
	public String addArticle(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		model.addAttribute("allSizes", articleService.getAllSizes());
		model.addAttribute("allBrands", articleService.getAllBrands());
		model.addAttribute("allCategories", articleService.getAllCategories());
		return "addArticle";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addArticlePost(@ModelAttribute("article") Article article, HttpServletRequest request, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException  {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Article newArticle = new ArticleBuilder()
				.withTitle(article.getTitle())
				.stockAvailable(article.getStock())
				.withPrice(article.getPrice())
				.imageLink(fileName)
				.sizesAvailable(Arrays.asList(request.getParameter("size").split("\\s*,\\s*")))
				.ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))
				.ofBrand(Arrays.asList(request.getParameter("brand").split("\\s*,\\s*")))
				.isDeleted(Boolean.FALSE)
				.build();		
		Article savedUser = articleService.saveArticle(newArticle);	
		String uploadDir = "uploads/" + savedUser.getId();
		 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
		return "redirect:article-list";
	}
	
	@RequestMapping("/article-list")
	public String articleList(Model model) {
		List<Article> articles = articleService.findAllArticles();
		model.addAttribute("articles", articles);
		return "articleList";
	}
	
	@RequestMapping("/edit")
	public String editArticle(@RequestParam("id") Long id, Model model) {
		Article article = articleService.findArticleById(id);
		String preselectedSizes = "";
		for (Size size : article.getSizes()) {
			preselectedSizes += (size.getValue() + ",");
		}
		String preselectedBrands = "";
		for (Brand brand : article.getBrands()) {
			preselectedBrands += (brand.getName() + ",");
		}
		String preselectedCategories = "";
		for (Category category : article.getCategories()) {
			preselectedCategories += (category.getName() + ",");
		}		
		model.addAttribute("article", article);
		model.addAttribute("preselectedSizes", preselectedSizes);
		model.addAttribute("preselectedBrands", preselectedBrands);
		model.addAttribute("preselectedCategories", preselectedCategories);
		model.addAttribute("allSizes", articleService.getAllSizes());
		model.addAttribute("allBrands", articleService.getAllBrands());
		model.addAttribute("allCategories", articleService.getAllCategories());
		return "editArticle";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editArticlePost(@ModelAttribute("article") Article article, HttpServletRequest request, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Article newArticle = new ArticleBuilder()
				.withTitle(article.getTitle())
				.stockAvailable(article.getStock())
				.withPrice(article.getPrice())
				.imageLink(fileName)
				.sizesAvailable(Arrays.asList(request.getParameter("size").split("\\s*,\\s*")))
				.ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))
				.ofBrand(Arrays.asList(request.getParameter("brand").split("\\s*,\\s*")))
				.build();
		newArticle.setId(article.getId());
		Article savedUser = articleService.saveArticle(newArticle);	
		String uploadDir = "uploads/" + savedUser.getId();
		 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return "redirect:article-list";
	}
	
	@RequestMapping("/delete")
	public String deleteArticle(@RequestParam("id") Long id) {
		Article article = articleService.findArticleById(id);
		if(Objects.equals(article.getDeleted(), Boolean.FALSE)){
			article.setDeleted(Boolean.TRUE);
		}
		else if(Objects.equals(article.getDeleted(), Boolean.TRUE)){
			article.setDeleted(Boolean.FALSE);
		}else {
			article.setDeleted(Boolean.TRUE);
		}
		articleService.saveArticle(article);
		return "redirect:article-list";
	}
	
}
