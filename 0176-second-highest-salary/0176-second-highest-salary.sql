-- # Write your MySQL query statement below
--  with table1 as (select dense_rank() over(order by salary desc) as rnk , salary   from Employee)

--  select max(salary) as SecondHighestSalary    from table1 where rnk = 2 ;
-- method 1 
-- with table1 as (
--     select * , dense_rank() over(order by salary desc) as rnk from Employee 
-- )
-- select case when count(salary) >= 1 then salary
-- else  null end as SecondHighestSalary   from table1 where rnk = 2 limit 1 ;  
select max(m.salary) as SecondHighestSalary 
from Employee m 
where m.salary < (
    select max(e.salary) from Employee e 
)