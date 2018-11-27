/* The Employee table holds all employees. 
Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+

The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+

Write a SQL query to find employees who have the highest salary in each of the departments. 

For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+ 

Create table If Not Exists Employee (
    Id int, 
    Name varchar(255), 
    Salary int, 
    DepartmentId int)

Create table If Not Exists Department (
    Id int, 
    Name varchar(255))
*/


/* The result of the sub-query can be regarded as a table */
SELECT d.name AS Department, e.name AS Employee, e.Salary AS Salary 
FROM Employee AS e
INNER JOIN (
    SELECT MAX(ee.Salary) AS maxsalary, ee.DepartmentId AS DepartmentId
    FROM Employee AS ee GROUP BY DepartmentId
) AS a
ON e.DepartmentId = a.DepartmentId
INNER JOIN Department AS d
ON d.id = e.departmentid
WHERE e.Salary = a.maxsalary;
