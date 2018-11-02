/* 题目描述

查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

输入描述:
无

输出描述:

emp_no    growth

10011       0

省略       省略

10010      54496

10004      34003 */


SELECT em.emp_no, (sa_current.salary - sa_hired.salary) AS growth
FROM
((employees AS em
INNER JOIN salaries AS sa_current
ON em.emp_no = sa_current.emp_no AND sa_current.to_date = '9999-01-01')
INNER JOIN salaries AS sa_hired
ON em.emp_no = sa_hired.emp_no AND sa_hired.from_date = em.hire_date)
ORDER BY growth;

