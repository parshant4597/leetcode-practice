# Write your MySQL query statement below
with newtable as (
    select dense_rank() over(partition by departmentId  order by salary desc ) as rn ,salary , departmentId as id
    from Employee 
) , table1 as (
select   d.name as Department  , e.name as Employee , e.salary as Salary 
from Department d 
left join 
Employee e 
on e.departmentId = d.id
where (e.salary, d.id) in (
    select salary , id from newtable  
    where rn <= 3
))
 
 select * from table1