package com.thungashoe.store.controller;

import com.thungashoe.store.domain.Article;
import com.thungashoe.store.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
		
	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping("/")
	public String index(Model model) {		
		List<Article> articles = articleService.findFirstArticles();
		model.addAttribute("articles", articles);
		return "index";
	}

	
}
