/* 题目描述

查找employees表所有emp_no为奇数，且last_name不为Mary的员工信息，并按照hire_date逆序排列

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

输入描述:
无

输出描述:

emp_no    birth_date    first_name    last_name    gender   hire_date

10011     1953-11-07      Mary        Sluis         F      1990-01-22

10005     1955-01-21     Kyoichi     Maliniak       M      1989-09-12

10007     1957-05-23     Tzvetan     Zielinski      F      1989-02-10

10003     1959-12-03     Parto        Bamford       M      1986-08-28

10001     1953-09-02     Georgi       Facello       M      1986-06-26

10009     1952-04-19     Sumant        Peac         F      1985-02-18 */


SELECT * FROM employees
WHERE last_name <> 'Mary'
AND (emp_no & 1) = 1
ORDER BY hire_date DESC;