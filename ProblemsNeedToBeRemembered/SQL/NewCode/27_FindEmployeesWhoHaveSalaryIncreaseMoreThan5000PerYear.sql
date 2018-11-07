/* 题目描述

给出每个员工每年薪水涨幅超过5000的员工编号emp_no、薪水变更开始日期from_date以及薪水涨幅值salary_growth，
并按照salary_growth逆序排列。

提示：在sqlite中获取datetime时间对应的年份函数为 strftime('%Y', to_date)

CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

输入描述:
无

输出描述:

emp_no   from_date   salary_growth

10003   1995-12-03      24178

10008   1998-03-11      20843

10008   2000-03-10      5997 */

SELECT s2.emp_no, s2.from_date, (s2.salary - s1.salary) AS salary_growth
FROM salaries AS s1
INNER JOIN salaries AS s2 ON
s1.emp_no = s2.emp_no
WHERE salary_growth > 5000
AND (strftime("%Y",s2.to_date) - strftime("%Y",s1.to_date) = 1 
     OR strftime("%Y",s2.from_date) - strftime("%Y",s1.from_date) = 1 )
ORDER BY salary_growth DESC;
