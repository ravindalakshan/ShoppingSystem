package entity;

/**
 * When a product is added to a cart with a quantity , then it will be
 * considered as a {@link Item} <br>
 * Shopping cart is consists with one/or multiple {@link Item}s
 * 
 */
public class Item {

    private Product product;
    private int quantity;
    private double totalPrice;
    private double totalTax;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }
}
