package service;

import entity.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * create() method invokes when order is initially created for a customer with no items added.
     * Then the {@link entity.OrderStatus} will be PLANNED.
     */
	@Test
	public void test_order_status_when_order_create_method_invokes() {

		Customer customer = getTestCustomer();
		Order order = orderService.create(customer);

		assertEquals(OrderStatus.PLANNED, order.getOrderStatus());
	}

    private Customer getTestCustomer() {
        
        Customer customer = new Customer();
        customer.setLastName("Last");
        customer.setFirstName("First");
        customer.setEmail("ravinda@gmail.com");
        customer.setPhone("2131111111");
        
        return customer;
    }

    /**
	 * When product is added to the order a item will be created with the product
	 * and the quantity of the product.<br>
	 * Therefore {@link ItemService}.createItem() will be called inside the
	 * addToOrder()
	 */
    @Test
    public void test_item_service_get_called_when_add_to_order_invokes() {

        Order order = new Order();
        Product product = new Product();

        orderService.addToOrder(order,product, 5);

        verify(itemService, times(1)).createItem(any(Product.class), anyInt());
    }

    @Test
    public void test_shopping_cart_service_get_called_when_add_to_card_invokes() {

        Order order = getTestOrder();
        orderService.addToCart(order);

        verify(shoppingCartService, times(1)).create(any());
    }

    private Order getTestOrder() {
        Order order = new Order();
        
        order.setCustomer(new Customer());
        order.setItems(new ArrayList<>());
        
        return order;
    }
}