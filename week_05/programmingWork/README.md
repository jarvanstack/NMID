### 数据
1.建表
```sql
-- 1.员工表
CREATE TABLE if not exists  `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工工号主键id自增',
  `emp_name` varchar(10) DEFAULT '员工名称' COMMENT '员工名称',
  `emp_job` varchar(10) DEFAULT '工作岗位' COMMENT '工作岗位',
  `emp_manager` varchar(10) DEFAULT '员工上司' COMMENT '员工上司',
  `emp_salary` int(5) DEFAULT NULL COMMENT '员工工资',
  `dept_no` int(11) DEFAULT NULL COMMENT '员工的部门编号',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8
-- 1.部门表
CREATE TABLE if not exists `department` (
  `dept_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门号id主键',
  `dept_name` varchar(10) DEFAULT '部门名称' COMMENT '部门名称',
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

```
2.数据
```sql
INSERT INTO department VALUES (1,'事业部'); 
INSERT INTO department VALUES (2,'销售部'); 
INSERT INTO department VALUES (3,'技术部'); 

INSERT INTO employee VALUES (1,'jacky','clerk','tom',2000,1);
INSERT INTO employee VALUES (2,'tom','clerk','',2500,1);
INSERT INTO employee VALUES (7,'biddy','clerk', 'tom',2000,1);
INSERT INTO employee VALUES (3,'jenny','sales','pretty',600,2);
INSERT INTO employee VALUES (4,'pretty','sales','',800,2);
INSERT INTO employee VALUES (5,'buddy','jishu','canndy',1000,3);
INSERT INTO employee VALUES (6,'canndy','jishu','',1500,3);
```
3.效果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200610213721766.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200610213742871.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
### 一、列出各部门的最高工资，最低工资
```sql
-- 1.每个部门的最高工资和最低工资
-- (1)采用过滤分组查询
select
       max(emp_salary) as 部门中的最高工资,
       min(emp_salary) as 部门中的最低工资,
       dept_name as 部门名称
from employee inner join department
on employee.dept_no = department.dept_no
group by dept_name;
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200610212842933.png)
### 二、按照各个部门的平均工资由高到低对，列出
**部门名 ，平均工资**
```
select
        avg(emp_salary) as 平均工资,
       dept_name as 部门名称
from employee inner join department
on employee.dept_no = department.dept_no
group by dept_name
order by 平均工资 DESC ;
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200610212914942.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
### 三、根据工资由低而高列出
**（1）每个员工的姓名，（2）部门名，（3）工资**
```sql
select emp_name as 每个员工的姓名,
       dept_name as 部门名,
       emp_salary as 工资
from employee
inner join department
on employee.dept_no = department.dept_no;
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200610212937116.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)


# 四、对于工资高于 本部门平均水平的员工，
 **列出(1)部门号，(2)姓名，(3)工资，按部门号排序**
```sql
select e.dept_no as 部门号,
       emp_name as 姓名,
       emp_salary as 工资
from employee e
inner join department d on e.dept_no = d.dept_no
having (e.emp_salary > (select avg(e2.emp_salary)  -- 本部门平均水平的员工，
    from employee as e2
    where e.dept_no = e2.dept_no
    group by e2.dept_no
    ));

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200610213001954.png)
### 五、创建表emp时，最后一行foreign key(deptno) references dept(deptno) 代表什么意思？

外键employee 表的员工部门编号关联到 department部门表的部门编号
 -- (现在不建议使用了,应该在代码上实现外键，SQL表用外键会导致很多问题。)
