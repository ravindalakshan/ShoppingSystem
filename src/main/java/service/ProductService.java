package service;

import java.util.Random;

import entity.Product;

public class ProductService {

    /**
     * Creates a {@link Product} by given parameters.
	 * 
	 * @param productName
	 *            Product Name
	 * @param price
	 *            price
	 * @param tax
	 *            tax
	 * @param manufacturer
	 *            Manufacturer
	 * @return {@link Product}
	 */
    public Product createProduct(String productName, double price, double tax, String manufacturer){

        Product product = new Product();

        product.setProductId(new Random().nextInt());
		product.setProductName(productName);
		product.setPrice(price);
		product.setTax(tax);
		product.setManufacturer(manufacturer);

		return product;
    }
}
