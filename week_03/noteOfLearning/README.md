### 第三周学习笔记
### 07月23日
### 一：线程 进程区别

举个例子，QQ程序是一个进程，如果你在QQ上一边视频通话（线程1）一边发消息（线程2） 就是2个线程。

### 二：实现线程几种方式

1. 继承Thread：new myThread().star() 重写run方法.

2. 实现Runnable接口：new Thread(new myRunnable()),run() 重写run()方法.

3. 匿名内部类.原理和 1 2 一致。

4. **建议使用Runnable接口，避免单继承(的局限性，new Runnable() 和 new Thread() 分离，高内聚低耦合，弹性大.**

### 三：Thread 类中的start() run()方法的区别

1.run() 是Thread中的普通方法，**不会新建线程**

2.star（）**会新建线程并自动执行run（）中的内容.**

### 四：什么是线程安全？Vector是一个线程安全类吗？

#### 1.首先了解多线程的原理.


多线程的star（）或者run（） 调用会 新建一个栈空间并自动执行run（）中的内容。如图：



#### 2. 线程安全产生的原因.
1.比如下面的代码

```java

int x = 1;
if (x>=0){
	x--;
}
```
如果使用多线性，线程1区出x的值，判断为true，在 自己的线程进行计算，此时公区的 x 还是 1 因为 线程 1 计算还没有结束，没有返回值回来，这时候线程2 看到 x >= 0 又拿走去计算，明明只用计算一次的却计算了多次，出现了线程安全问题

2.张三复制了李四的银行卡，李四去取钱输入 1000 ，在1000-1000 的计算还没结束，张三凭借迅雷不及掩耳之势，马上取钱 1000，由于李四取钱正在取钱，公共变量的钱1000还没有扣除，银行又把1000 给 了张三，于是线程安全的问题就产生了。


**其实就是公有变量池中的变量的值被取出来，还没有计算完成还回去又被其他的线程拿去用了。**

### 五：如何在两个线程间共享数据？什么是生产消费者模型？

#### 1.如何在两个线程间共享数据？

一般使用数据池，数据池里面的数据给所有线程共有，实现线程通信


#### 2.什么是生产消费者模型？

（1）图书馆里面只能存放3本书，还书者（生产者）增加书本，借书者（消费者）减少书本，

（2）如果图书馆里面没有书，就需要等待还书者来还书，如果有书就能借书

（3）还书者如果图书馆的书不到3本，还有空位，就能还书，如果图书馆里面的书3本了就因为书太多，需要等待借书者借书，借完书再还书。


### 六：什么是线程池？ 为什么要使用它？

线程池能储存多个线程，实现了线程的复用，避免的反复创建线程销毁线程消耗大量的资源.

**线程池是课重复使用的线程集合，因为使用完成后会自动归还线程**

### 七：多线程中调用wait() 和 sleep()方法有什么不同？

wait() 是等待的阻塞，需要其他线程唤醒，

sleep() 是睡眠，自动唤醒



>4种运行状态.
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521120432163.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
>
### 八：synchronized 和 ReentrantLock 有什么不同？


Lock接口（代表类是ReentrantLock可复用锁）是通过代码来实现，要保证锁一定被释放**必须将unLock() 放到finally{}中**

2.在资源竞不是很激烈的情况下synchronized的性能优于 ReentrantLock（）

在资源竞争激烈的情况下 ReentrantLock的性能要好几十倍

3.**使用优先级：`ReentrantLock` ----> 同步代码块 ----->同步方法**

### 九：语法知识：

#### 1、throws和throw的区别？（毕9-10）

throw 是主动抛出异常

throws 是出现异常后自动把异常抛向上级.

具体查看我的博客

[try catch throw throws 的区别 ](https://blog.csdn.net/jarvan5/article/details/105563339)
#### 2、什么情况下不能再函数上抛出（声明）异常（毕10-3）

**（1）异常必须要处理**，因为throws 只是向上抛出，感觉就像甩锅，你甩锅给你上级，你上级甩锅给你上级的上级，最后到了最顶级CEO（JVM），JVM看到直接把项目停了（关闭虚拟机）大家都凉凉。

**（2）什么情况下异常必须处理呢？**：

`子类在覆盖父类的方法的时候只抛出父类异常的子类或者子集（父类有多个异常)`

1. 如果父类的方法没有抛出异常，那么子类方法所有异常只能try chatch

2. 如果子类方法产生的异常，父类方法没有抛出，子类只能try catch

3. 如果想自己处理异常只能trycatch

4. 想使用finally释放资源只能try catch





#### 3、线程和进程的区别?（毕11-1）

举个例子，QQ程序是一个进程，如果你在QQ上一边视频通话（线程1）一边发消息（线程2） 就是2个线程。

终端可以多个进程，（QQ 和 微信）

一个进程可以有多个线程


#### 4、创建线程（继承Thread）后调用t.start();和t.run();的区别？（毕11-3）

1.run() 是Thread中的普通方法，**不会新建线程**


2.star（）**会新建线程并自动执行run（）中的内容.**
画个图解释下

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521144614840.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

#### 5、继承和实现两种方式实现线程的区别？（毕11-8）

1. 继承Thread：new myThread().star() 重写run方法.

2. 实现Runnable接口：new Thread(new myRunnable()),run() 重写run()方法.

3. 匿名内部类.原理和 1 2 一致。

4. **建议使用Runnable接口，避免单继承(的局限性，new Runnable() 和 new Thread() 分离，高内聚低耦合，弹性大.**


#### 6、synchronized和lock这两中方式的区别？（毕12-6）

1.synchronized是在JVM层面的实现，出现了异常JVM会自动释放锁定

Lock接口（代表类是ReentrantLock可复用锁）是通过代码来实现，要保证锁一定被释放**必须将unLock() 放到finally{}中**

2.在资源竞不是很激烈的情况下synchronized的性能优于 ReentrantLock（）

在资源竞争激烈的情况下 ReentrantLock的性能要好几十倍

3.**使用优先级：`ReentrantLock` ----> 同步代码块 ----->同步方法**


#### 7、stop方法和interrupt方法的区别？（毕12-7）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521120432163.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

先看我之前画的4种状态的图：

1. 新建状态

2. 运行状态

3. 阻塞状态

4. 结束状态


**`Thread类的方法.`**
stop () 是吧，运行或者阻塞状态转为 停止的结束状态

interrupt() 会吧阻塞状态解除为运行状态并抛出异常.

`注意stop() 已经弃用`

#### 8、下面两句代码的区别？（毕12-1）

```   
   String str1 = “abc”;
   String str2 = new String(“abc”);
   
   //str1 的地址指向方法区的常量区
   //str2 的地址指向堆区.
   //str1 == str2 //false
```
   
#### 9、写出下面语句的运行结果？
```java 
   System.out.println(“abdlghl”.lastIndexOf(“dlgh”));
   //2
```

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521160238960.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
   
#### 10、数组中的获取长度和字符串中获取长度的方法有什么区别？（12-2）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521160639538.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

1.数组的长度就是数组的字段属性，而且还是static修饰的，

2.我们字符串长度的放回是一个方法我们看看

(1)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521161015695.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

(2)再看看表达式返回的什么鬼

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521161440527.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521161551422.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
(3）再看看coder（）什么鬼。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521162041254.png)
字节长度 除以 每一个字符的字节数 就是 字符数量.

#### 11、写出下面语句的输出结果？
```
   System.out.println(“abcdefgh”.substring(2,6));
  // cdef
```
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521171701603.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
   
#### 12、StringBuffer和String数组都是容器，那他们的区别是？（毕13-10）

StringBuffer 容器可自动增加,

String[] 固定的

2.StingBuffer可操作多个数据类型

3.StringBuffer是用toString方法打印

#### 13、StringBuilder和StringBuffer的区别（毕13-12）
性质| String类 |StringBuilder类|StringBuffer 类|
|--|--|--|--|
|  快速|  |Yes |
|长度可边||Yes|Yes|
|多线程安全|Yes||Yes|




更多查看我的博客
[Java 常用类StringBuilder类使用教程，String类，StringBuilder类，StringBuffer 类的区别](https://blog.csdn.net/jarvan5/article/details/105745368)

线程安全我们应该用锁来保证，而不是StringBuffer牺牲性能

#### `请使用StringBuilder`

#### 14、写出下面语句的输出结果？(毕13-13)

```
     int x =  Integer.parseInt("3c",16);
		int xx = x + 15;
		System.out.println(xx);
```
```
75
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521174029129.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521174310689.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

#### 15、写出下面语句的输出结果？(毕13-14)

```
        Integer x1 = 127;
		Integer x2 = 127;
		Integer x3 = 128;
		Integer x4 = new Integer(127);
		System.out.println(x1==x2);  //
		System.out.println(x1==x3);  
		System.out.println(x1==x4);  
		System.out.println(x1.equals(x4)); 
		
```
```
        Integer x1 = 127;
        Integer x2 = 127;
        Integer x3 = 128;
        Integer x4 = new Integer(127);
        System.out.println(x1==x2);  //true 都是一个值.方法中的基本数据类型都在栈中
        System.out.println(x1==x3);//false都是栈中但是数据不一致
        System.out.println(x1==x4);//false x4的地址指向堆区
        System.out.println(x1.equals(x4));//true 因为 equals 是取值运算.
  ```



1.equals() 是取值运算
2. 
  ```
  ==  //是地址的比较
  ```


  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521175231540.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)