package service;

import entity.Item;
import entity.Product;

public class ItemService {

	/**
	 * Creates an {@link Item} from {@link Product}
	 * 
	 * @param product
	 *            product
	 * @param quantity
	 *            quantity of product
	 * @return {@link Item}
	 */
    public Item createItem(Product product, int quantity){

        Item item = new Item();

        item.setProduct(product);
        item.setQuantity(quantity);
        item.setTotalPrice(product.getPrice()*quantity);
        item.setTotalTax(product.getTax()*quantity);

        return item;
    }
}
