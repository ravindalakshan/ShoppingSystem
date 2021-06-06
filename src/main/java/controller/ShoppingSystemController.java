package controller;

import entity.Customer;
import entity.Order;
import entity.Product;
import entity.ShoppingCart;
import service.CustomerService;
import service.OrderService;
import service.ProductService;

public class ShoppingSystemController {
    
	private static CustomerService customerService = new CustomerService();
	private static ProductService productService = new ProductService();
	private static OrderService orderService = new OrderService();

	public static void main(String[] args) {

		// create two customers
		Customer firstCustomer = customerService.createCustomer("first.customer@email.com", "first", "last", "0704418962");
		Customer secondCustomer = customerService.createCustomer("second.customer@email.com", "second", "customer", "0718962121");

		//create product
		Product productOne = productService.createProduct("Milk Powder",250.0,2.50,"Unilever");
		
		// create an order for first customer and add product to it.
		Order firstCustomerOrder = orderService.create(firstCustomer);
		orderService.addToOrder(firstCustomerOrder, productOne, 1);
		orderService.addToCart(firstCustomerOrder);

		// create a shoppingCart for first customer and calculate the prices.
		ShoppingCart firstCustomerShoppingCart = orderService.addToCart(firstCustomerOrder);
		firstCustomerShoppingCart.calculate();

		System.out.println(".. First Customer Shopping Cart ...");
		System.out.println("Sub total : "+ firstCustomerShoppingCart.getSubTotal());
		System.out.println("Tax total : "+ firstCustomerShoppingCart.getTaxTotal());
		System.out.println("Total     : "+ firstCustomerShoppingCart.getTotal());

		// create two products
		Product productTwo = productService.createProduct("Pencil case",120.0,3.40,"Atlas");
		Product productThree = productService.createProduct("Water Bottle", 50.0, 12.30, "Atlas");

		// creates order and add products to it.
		Order secondCustomerOrder = orderService.create(secondCustomer);
		orderService.addToOrder(secondCustomerOrder, productTwo, 2);
		orderService.addToOrder(secondCustomerOrder, productThree, 3);

		// create a shopping cart for second customer and calculates the prices
		ShoppingCart secondCustomerShoppingCart = orderService.addToCart(secondCustomerOrder);;
		secondCustomerShoppingCart.calculate();

		System.out.println("\n.. Second Customer Shopping Cart ...");
		System.out.println("Sub total : "+ secondCustomerShoppingCart.getSubTotal());
		System.out.println("Tax total : "+ secondCustomerShoppingCart.getTaxTotal());
		System.out.println("Total     : "+ secondCustomerShoppingCart.getTotal());

	}
}
