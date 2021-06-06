package service;

import entity.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerServiceTest {

    CustomerService customerService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService();
    }

	@Test
	public void test_create_customer_when_email_is_not_in_correct_format() {
		String email = "ravinda.l#gmail.com"; // incorrect email format

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Email is not in correct format");

        customerService.createCustomer(email, "First", "lastName", "0212311199");
    }

    @Test
    public void test_create_customer_when_phone_is_not_in_correct_format() {
        
		String email = "ravinda.l@gmail.com";
		String phone = "01111212121212121212"; // incorrect phone number
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Phone number should have 10 digits");

        customerService.createCustomer(email, "First", "lastName", phone);
    }

    @Test
    public void test_create_customer_when_both_phone_and_email_are_correct() {

        String email = "ravinda.l@gmail.com";
        String phone = "0111416212";

        Customer createdCustomer = customerService.createCustomer(email, "First", "lastName", phone);

        Assert.assertEquals("ravinda.l@gmail.com",createdCustomer.getEmail());
        Assert.assertEquals("0111416212",createdCustomer.getPhone());
        Assert.assertEquals("First",createdCustomer.getFirstName());
        Assert.assertEquals("lastName",createdCustomer.getLastName());
    }
}