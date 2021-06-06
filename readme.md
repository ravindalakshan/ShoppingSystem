GapStarters Shopping System

This is a simple overview implementation of a shopping system where customer can add products, add products to the cart as items etc.

**Entity Description**

(1). [Address](entity/Address.java)
Entity that holds customer address.

(2). [Customer](entity/Customer.java) Entity that represent a Customer. 

(3). [Product](entity/Product.java) This Entity represent the Prodcuct that a customer can buy. A new product can be created using the [ProductService](service/ProductService.java)

(4). [Item](item) Entity that represent when an product is added to an Order/Cart with a specific quantity. 

(5). [Order](entity/Order.java) Entity that represents an Order which a customer can place. The service of this entity is [OrderService](service/OrderService.java) and this provides facility to create order for a customer, add products to an order and add to card option also. 

(6). [OrderStatus](entity/OrderStatus.java) This is actually an Enum which is introduce to track the order status.  Ex:- When order is initially created for a customer it is in PLANNED status. When items are added it goes to CREATED state.etc.

(7). [ShoppingCart](entity/ShoppingCart.java) This represent the Shopping cart which holds items and calcutes the prices for them. 

(8). [Payment](entity/Payment.java) This entity is not used in the context. Payment Entity can be used as a further enhancement to this small shopping system implementation.

