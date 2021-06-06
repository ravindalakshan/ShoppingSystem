package service;

import java.util.Random;
import java.util.regex.Pattern;

import entity.Customer;

public class CustomerService {

	private static final String EMAIL_REGEX = "^(.+)@(.+)$";
	private static final String PHONE_REGEX = "^\\d{10}$";

	/**
     * Creates a customer from below parameters
	 * 
	 * @param email
	 *            email address
	 * @param firstName
	 *            first name
	 * @param lastName
	 *            last name
	 * @param phone
	 *            phone nu,ber
	 * @return {@link Customer}
	 */
	public Customer createCustomer(String email, String firstName, String lastName, String phone) {

		validate(email, phone);

		Customer customer = new Customer();
		customer.setCustomerId(new Random().nextInt());
		customer.setEmail(email);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPhone(phone);

		return customer;
	}

	private void validate(String email, String phone) {

		if(!Pattern.compile(EMAIL_REGEX).matcher(email).matches()){
			throw new IllegalArgumentException("Email is not in correct format");
		} else if (!Pattern.compile(PHONE_REGEX).matcher(phone).matches()){
			throw new IllegalArgumentException("Phone number should have 10 digits");
		}
	}
}
