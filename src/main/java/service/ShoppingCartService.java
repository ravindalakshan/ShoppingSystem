package service;

import entity.Order;
import entity.ShoppingCart;

public class ShoppingCartService {

	/**
	 * Creates a new shoppingCart For Customer
	 * 
	 * @return {@link ShoppingCartService}
	 */
	public ShoppingCart create(Order order) {

		ShoppingCart cart = new ShoppingCart();
		cart.setCustomer(order.getCustomer());
		cart.setItems(order.getItems());

		return cart;
	}

}
