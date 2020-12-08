create table suri.customer(
id  integer primary key,
customer_name varchar NULL,
phone_number varchar NULL

)


create table suri.order(
id integer primary key,
customer_id integer,
constraint fk_customer_id foreign key(customer_id) references suri.customer(id)

)

CREATE  TABLE IF NOT EXISTS suri.product (
  ID  integer NOT NULL ,
  name varchar NOT NULL ,
  description varchar NULL ,
  PRIMARY KEY (ID) )


  CREATE  TABLE IF NOT EXISTS suri.order_product (
  ID integer NOT NULL ,
  Order_ID integer NOT NULL ,
  Product_ID integer NOT NULL ,
  Quantity integer NOT NULL ,
  PRIMARY KEY (ID) ,
  constraint fk_order_id foreign key(Order_ID) references suri.order(id),
  constraint fk_product_id foreign key(Product_ID) references suri.product(id)
  )




Customers
Contains a list of customers. One row per Customer. Would contain all the customers information - their contact details, etc...

Orders
Contains a list of orders. One row per order. Each order is placed by a customer and has a Customer_ID - which can be used to link back to the customer record. Might also store the delivery address, if different from the customers address from their record - or store addresses in separate tables.

OrderItems
Contains a list of order items. One row for each item on an order - so each Order can generate multiple rows in this table. Each item ordered is a product from your inventory, so each row has a product_id, which links to the products table.

Products
Contains a list of products. One row per product. Similar to the customers table, but for products - contains all the product details.