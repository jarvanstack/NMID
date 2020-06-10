### 第五周学习笔记
### 08月13日
### [GitHub格式问题可跳转到CSDN](https://blog.csdn.net/jarvan5/article/details/106635400)
### 一：SQL基本语句
增删改查
具体看我的博客
https://blog.csdn.net/jarvan5/article/details/106155205

### 二：数据库五大范式范式

具体看我的博客
https://blog.csdn.net/jarvan5/article/details/106582777

### 三：JDBC的执行步骤
1.驱动
2.Connection
3.Statement
4.ResultSet（只有查询需要）
5.release
具体查看我的博客
https://blog.csdn.net/jarvan5/article/details/106587295
### 四：什么是事务
同时成功或者失败的一组SQL
具体查看我的博客
https://blog.csdn.net/jarvan5/article/details/106380889
### 五：事务的四个特性
1.原子性（同时成功或者失败）
2.**隔离性**，（会导致脏读，幻读，和不可重复读取)
3.一致性（数据前后一致，参考银行转账）
4.持久性（submit（）后就持久了）

具体查看我的博客
https://blog.csdn.net/jarvan5/article/details/106380889
### 六：事务的隔离级别
设置级别|脏读|不可重复读|幻读|
--|--|--|--|
可读未提交（read-uncommitted）|会|会|会|
只读提交（read-committed）||会|会
可重复读（repeatable-read）|||会|
可序列化（serializable）|

具体查看我的博客
https://blog.csdn.net/jarvan5/article/details/106380889
### 七：索引的类别和每种索引的创建方式、
索引的分类
索引|介绍
--|--|
1.主键索引（primary key）|一般表的id使用，一表一个
2.唯一索引（unique key）|索引的值不能重复，比如微信号
3.默认索引（key）|没有任何限制，可空可重复，不知道有啥用
4.全文索引（fulltext）|没和match against 操作而不是where，先放数据在设置全文索引速度快些
5.组合索引|多个字段上创建的索引，查询只有差第一个字段（**最左**）才有效

具体查看我的博客
https://blog.csdn.net/jarvan5/article/details/106385445

### 八：聚簇索引和非聚簇索引的区别
innodb的主键就是聚簇索引，
myISAM 主键还是二级索引都是非聚簇索引。
#### 1.非聚簇索引：
表和所有是分2部分储存的，通过索引的查找找需要的表的数据的地址
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200609163030931.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 2. 聚簇索引：
主键的叶子下包含了数据，其他索引指向主键：


![在这里插入图片描述](https://img-blog.csdnimg.cn/20200609203856304.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
* **==所以InnoDB所有表一定要有主键==，如果你自己没有显式定义主键，MySQL会自动选择一个可以唯一标识的数据作为主键，如果没有unique的列，那mysql会自动创建一个隐式主键**
* 还有一件事就是关于添加一个自增主键在磁盘上会，自动开辟新的连续的页，极大的方便的查询，速度增加，可维护性高，插入更快，而且有效减少储存碎片。

 具体分析参考我的博客
 https://blog.csdn.net/jarvan5/article/details/106644032

### 九：B树和B+树的区别
B树的存在就是为的减少磁盘IO的影响（磁盘IO费时间的原因查看我的博客）
B + 树（B+ Tree）是 B-Tree的升级版，性能更好：

具体查看我的博客
https://blog.csdn.net/jarvan5/article/details/106644032

### 十、一个好的数据库结构
这份图是早期的MySQL手册的示例图，用来参考它的结构。（==现在不建议使用外键，外键的效果用程序实现，==）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200610200805475.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
