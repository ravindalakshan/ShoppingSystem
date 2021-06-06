package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the {@link Item}s added and the {@link Payment} attached under a
 * {@link Customer}.
 */
public class ShoppingCart {

    private Customer customer;

    /**
     * List of {@link Item}s added to ShoppingCart
     */
    private List<Item> items;

    /**
     * sum of total price of {@link Item}s
     */
    private double subTotal;

    /**
     * sum of total tax of {@link Item}s
     */
    private double taxTotal;

    /**
     * cost applied for shipping
     */
    private double shipmentCost;

    /**
     * total = subTotal + taxTotal
     */
    private double total;
    
    /**
     * Payment attached to the Shopping cart
     */
    private Payment payment;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addCartItems(Item items) {
        this.items.add(items);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(double shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public void calculate() {

		if (!items.isEmpty()) {
			items.forEach(cartItem -> {
				subTotal += cartItem.getTotalPrice();
				taxTotal += cartItem.getTotalTax();
			});
		}

		total = subTotal + taxTotal + shipmentCost;
	}
}
