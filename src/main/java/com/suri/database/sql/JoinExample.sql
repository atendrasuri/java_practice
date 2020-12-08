  SELECT column list, function(), function(), ...
            FROM table1

                INNER JOIN table2

                ...

                ON table1.col1 = table2.col2

                ...

            WHERE criteria for row selection

            [AND criteria for row selection]
            [OR criteria for row selection]


  GROUP BY column list
            HAVING criteria for function results


            ORDER BY column list


 ======================================
CREATE TABLE dscchina.customers (
    Id int NOT NULL PRIMARY KEY,
    name varchar,
   age int,
   address varchar,
   salary int
);
CREATE TABLE dscchina.orders (
    orderId int NOT NULL PRIMARY KEY,
    amount int,
    customerId int REFERENCES dscchina.customers(Id)


);


insert into dscchina.customers values (1, 'Ramesh', 32, 'Ahmedabad',2000.00);
insert into dscchina.customers values (2, 'Khilan', 25, 'Delhi',1500.00);
insert into dscchina.customers values (3, 'kaushik', 23, 'Kota',6500.00);
insert into dscchina.customers values (4, 'Chaitali', 25, 'Mumbai',8500.00);
insert into dscchina.customers values (5, 'Hardik', 27, 'Bhopal',2000.00);
insert into dscchina.customers values (6, 'Komal', 22, 'MP',4500.00);
insert into dscchina.customers values (7, 'Muffy', 24, 'Indore',10000.00);


insert into dscchina.orders values (102, 3000,3);
insert into dscchina.orders values (100, 1500,3);
insert into dscchina.orders values (101, 1560,2);
insert into dscchina.orders values (103, 2060,4);


select * from dscchina.customers;
select * from dscchina.orders;

-- Inner join / simple join

SELECT c.ID, c.NAME, c.AGE,o.AMOUNT
   FROM dscchina.CUSTOMERS c, dscchina.ORDERS o
   WHERE  c.ID = o.customerId;

-- Left join
SELECT ID, NAME, AGE, AMOUNT
   FROM dscchina.CUSTOMERS left join dscchina.ORDERS on
    dscchina.CUSTOMERS.ID = dscchina.ORDERS.customerId;

-- right join
SELECT ID, NAME, AGE, AMOUNT
   FROM dscchina.CUSTOMERS right join dscchina.ORDERS on
    dscchina.CUSTOMERS.ID = dscchina.ORDERS.customerId;

-- full join
SELECT ID, NAME, AGE, AMOUNT
   FROM dscchina.CUSTOMERS full join dscchina.ORDERS on
    dscchina.CUSTOMERS.ID = dscchina.ORDERS.customerId;

-- group By

select customerid,sum(amount) as s from dscchina.orders group by customerid having sum(amount)>2000 order by sum(amount);














