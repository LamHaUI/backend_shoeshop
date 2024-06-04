package com.thungashoe.store.service;

import com.thungashoe.store.domain.Article;
import com.thungashoe.store.domain.CartItem;
import com.thungashoe.store.domain.ShoppingCart;
import com.thungashoe.store.domain.User;


public interface ShoppingCartService {

	ShoppingCart getShoppingCart(User user);
	
	int getItemsNumber(User user);
	
	CartItem findCartItemById(Long cartItemId);
	
	CartItem addArticleToShoppingCart(Article article, User user, int qty, String size);
		
	void clearShoppingCart(User user);
	
	void updateCartItem(CartItem cartItem, Integer qty);

	void removeCartItem(CartItem cartItem);
	
}
