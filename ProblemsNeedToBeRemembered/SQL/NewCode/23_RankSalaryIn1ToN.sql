/* 题目描述
对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列

CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

输入描述:
无

输出描述:

emp_no   salary   rank

10005     94692     1

10009     94409     2

10010     94409     2

10001     88958     3

10007     88070     4

10004     74057     5

10002     72527     6

10003     43311     7

10006     43311     7

10011     25828     8 */

SELECT s1.emp_no, s1.salary, COUNT(DISTINCT s2.salary) AS rank
FROM salaries AS s1
INNER JOIN salaries AS s2
ON s1.salary <= s2.salary
AND s1.to_date = '9999-01-01' 
AND s2.to_date = '9999-01-01'
GROUP BY s1.emp_no
ORDER BY s1.salary DESC;