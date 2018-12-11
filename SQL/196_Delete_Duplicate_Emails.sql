/* Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
Note:

Your output is the whole Person table after executing your sql. Use delete statement. */

/* Method 1 */
DELETE P1 FROM Person AS P1
INNER JOIN Person AS P2
ON P1.Email = P2.Email
WHERE P1.Id > P2.Id;


/* Method 2 */
DELETE FROM Person
WHERE Id NOT IN 
(SELECT Id FROM 
(SELECT MIN(Id) AS Id FROM Person GROUP BY Email) AS TEMP);