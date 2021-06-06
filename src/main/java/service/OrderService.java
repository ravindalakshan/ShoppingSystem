package service;

import java.util.Date;

import entity.*;

public class OrderService {

    private ShoppingCartService shoppingCartService = new ShoppingCartService();

    private ItemService itemService = new ItemService();

    /**
     * Creates an order for customer
     * @param customer customer
     * @return {@link Order}
     */
	public Order create(Customer customer) {

		Order order = new Order();
		order.setCustomer(customer);
		order.setOrderStatus(OrderStatus.PLANNED);

		return order;
	}

	/**
	 * Add {@link Product} with a given quantity to an {@link Order}. <br>
	 * First, calls to the {@link ItemService} to create an item from the given
	 * product and the quantity. <br>
	 * Then, add the created {@link Item} to the {@link Order}
	 * 
	 * @param order
	 *            order
	 * @param product
	 *            product
	 * @param quantity
	 *            quantity of the product
	 */
	public void addToOrder(Order order, Product product, int quantity) {

        Item item = itemService.createItem(product, quantity);
		order.getItems().add(item);
	}

	/**
	 * Add order items to the cart, when all the {@link Product}s are added as
	 * {@link Item}s to the {@link Order}. <br>
	 * {@link Order} created date will be set and the {@link OrderStatus} will be
	 * marked as CREATED.
	 * 
	 * @param order
	 *            order
	 * @return {@link ShoppingCart}
	 */
    public ShoppingCart addToCart(Order order){

        order.setCreatedDate(new Date());
        order.setOrderStatus(OrderStatus.CREATED);
        
        return shoppingCartService.create(order);
    }
}
