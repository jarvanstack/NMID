***\*第一周学习笔记\****

07月16日

### 一、环境变量意义

博客笔记

https://blog.csdn.net/jarvan5/article/details/106077828



### 二、java命令行基本操作指令
博客笔记
***https://blog.csdn.net/jarvan5/article/details/106081217***

### 三、JDK JRE JVM的区别和联系

https://blog.csdn.net/jarvan5/article/details/106082472

### 四、java程序编写的基本流程和原理



1. coder(程序员) 写出 .(点)java 文件

2. 编译工具编译为.(点) class 文件

3. JVM 配合 内裤(类库) 运行 .class 文件

 

### 五、class文件时用来做什么的

https://blog.csdn.net/jarvan5/article/details/106082830

### 六、git是什么

分布式文件管理系统

### 七、git常见操作命令

https://blog.csdn.net/jarvan5/article/details/105934599

### 八、对分支的理解

理解，举个例子，我用master主分支来迭代我的软件版本，测试版本使用分支 development 分支来开发，保证development稳定后在合并到master上面。

Git 不同于传统的文件管理，每个人都拥有全部的文件，

https://blog.csdn.net/jarvan5/article/details/106083982

### 九、语法知识

1、Java语言基础组成? （毕向东2-1）

```
\1. 关键字 

\2. 标识符

\3. 注释

\4. 常量和变量

\5. 运算符

\6. 语句

\7. 函数

\8. 数组
```

2、关键字和标识符的区别?

```
关键字是系统程序自带的，标识符是程序员自定义的。
```

 

3、java的基本数据类型：（毕2-7）

```
String不是基本数据类型
```



4、定义long类型的30，单精度的4.13，变量名为a，（毕2-7） 

```
long a = 30;

a = 30;

Float a ;

a = (float)4.13;
```



5、定义数值4，字符4，字符串4

```
Int a5 = 4;

Char b5 = 4;

String c5 = “4”;
```

 

6、写出下面代码的运算结果：（毕2-9）

````
   (1)a = 2 % 5; a1 = 2 % -5; a2 = -2 % 5; a3 = -2 % -5;

 a = 2

 a1 = -2

 a2 = -2

a3 = 2

 
````



   (2)

```java 
System.out.println(“5+5=”+5+5);

// 5+5=55

```



7、定义 short s = 5; 下面两句代码的区别。（毕2-11）

​    (1) s = s + 3;

​    (2) s += 3;

https://blog.csdn.net/jarvan5/article/details/106086158

 

8、“&&”与“&”的区别？（毕2-12）

>&& 左边遇到false 就停止运算右边，效率较高
>
>&则需要计算2边

9、“>>”和“>>>”的区别？（毕2-13）  



https://blog.csdn.net/jarvan5/article/details/106086509



10 交换两个变量的值。两种方式。（毕2-15）



https://blog.csdn.net/jarvan5/article/details/106088395



11、for和while的区别（毕3-4）

>
>
>1.for while 可以进行互换，但是的局部变量机制更节省资源

 

12、for和while最简单的无限表达形式。（毕3-5）

 ```java
while(true){
}
for(int i = 0 ;i<1;){
  
}
 ```



13、函数中形参和实参的区别。（毕3-12）  



>形参声明或者定义函数时使用的
>
>实参就是我们平时使用的参数



14、优化下面的代码

```java
for(int x = 0; x < arr.length; x++){
	System.out.println(arr[x]); 
	}
```

回答：

 ```Java
package NMID.week01;

/**
 * 为什么感觉差不多？
 * 优化前1亿次用时：6496毫秒
 * 优化后1亿次用时：6209毫秒
 * 算上程序跑起来的时间其实差不多
 * 而且.length 似乎是和数组一起储存的基本属性，没有调用任何类功能
 */
public class for基础循环速度优化 {
    public static void main(String[] args) {
        String[] String = new String[1_0000_0000];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < String.length; i++) {
            int x = 0;
            System.out.print("");
        }
        System.out.println("优化前1亿次用时：" + (System.currentTimeMillis() - startTime) + "毫秒");
        int len = String.length;
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            int x = 0;
            System.out.print("");
        }
        System.out.println("优化后1亿次用时：" + (System.currentTimeMillis() - startTime2) + "毫秒");
    }
}

 ```

