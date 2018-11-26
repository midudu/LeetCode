/* Suppose that a website contains two tables, the Customers table and the Orders table. 

Write a SQL query to find all customers who never order anything.

Create table If Not Exists Customers (
    Id int, 
    Name varchar(255));

Create table If Not Exists Orders (
    Id int, 
    CustomerId int);


Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+ */

/* Method 1*/
SELECT Customers.Name AS Customers FROM Customers
LEFT JOIN Orders ON Customers.Id = Orders.CustomerId
WHERE Orders.Id IS NULL;

/* Method 2*/
SELECT c.Name AS Customers FROM Customers c
WHERE c.Id NOT IN(
SELECT DISTINCT(CustomerId) FROM Orders);