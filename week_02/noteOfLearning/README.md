>第二周学习笔记
 07月23日
 
### 一：简述类与对象的关系
```
类是对象的实体，
对象是类的实现
在数据初始化的时候 
1. 类.java 文件  编译为 .class 文件
然后在有 classLoader 加载到 方法区
2. 而 对象是在程序执行的时候 通过 new 操作 ，实例化类 到 堆区

```
### 二：封装的概念
```
封装就是对数据的封装，
通常表现为 private 私有的 成员变量 和 使用公有的方法。
```
### 三：对构造函数的理解
```
1.构造函数，就是 类的实例化 (new Object) 的时候执行的函数，实例化的new 的操作，其实就是对应构造函数执行的过程，
2.构造函数时候如果有父类，会优先构造父类
```
### 四：JAVA能不能多继承，若不能，怎么处理这种问题
```
不能多继承，
只能单继承，
但是接口可以多实现implements 
尽量使用接口而非继承
```
### 五：单例设计模式的理解
**`单例模式值创建一个实例，节约内存资源`**
[6种单例模式](https://blog.csdn.net/jarvan5/article/details/106201139)
### 六：解释下这句代码什么意思
public static void main(String[] args) 
//为什么形参要写成那
>用来传递参数，里面可以打印
>
如何传递参数
https://blog.csdn.net/jarvan5/article/details/105456420
### 	七：UML类图
UML 类图简单入门使用教程（基本组成，关系，代码实例，案例分析）
https://blog.csdn.net/jarvan5/article/details/106068791
startUML UML类图基本使用教程.；六种UML线的含义和区别；UML类图变为Java/c/c++代码，startUML的注释
https://blog.csdn.net/jarvan5/article/details/105973096
### 八：语法知识：
#### 1、定义 int[] x,y[]; 判断下面赋值操作是否正确。（毕4-14）
   a. x[0] = y; 
   b. y[0] = x; 
   c. y[0][0] = x; 
   d. x[0][0] = y; 
   e. y[0][0] = x[0]; 
   f. x = y; 

 解决要点：
 1.
    ``//int [] x,y[] ;   //等价于  int [] x ;   int [] [] y;``
 2.·`直接赋值二维数组的一个横行row 需要一个 一维数组`

```java
        x[0] = y; //error
        y[0] = x; //ok
        y[0][0] = x; //error 
        x[0][0] = y;//error
        y[0][0] = x[0]; //ok
        x = y; //error
 ```
#### 2、类和对象的关系？（毕5-3）
实体的类比如 (Person.java) 被编译为 Person.class 文件 后 被 classLoader 转化为01 到内存的 方法区域， 对象是类的实例，在程序运行时  通过 new 操作 实例化类 然后 实例化的对象数据 （比如 Person {name = "张三”}）储存到堆区，在栈区储存 堆区对象实例的地址，person 的值如果不重写 toString （）方法就是 堆区对象实例数据的地址。

#### 3、局部变量和对象成员变量的区别。（毕5-4）
局部变量，生命周期（能有效的区域）过了就会被垃圾回收机制慢慢回收掉，就无法使用了，假如是局部变量对应的 对象的就是UML中的依赖关系。成员变量又叫做全局变量类中儿可以全局访问，**`没有static的全局变量不能static方法main中使用`**，假如是全局变量对应的 对象，对应UML类图中的 **[6种关联](https://blog.csdn.net/jarvan5/article/details/106068791)**关系，

#### 4、什么是封装？（毕5-6）
private 的成员变量和实现细节 ，仅仅public必要的接口。

#### 5、构造函数合一般函数的区别？（毕5-7）
构造函数 和类名同名且无返回类型，在new 时候自动执行，
#### 6、构造代码块和构造函数的区别？（毕5-9）
>构造代码块：在类的加载的时候的 3最后一步的初始化的时候 会运行 构造代码块 static{} 和 static 修饰的类变量 ，的初始化，
>构造函数：在运行时候，new  化操作 实例化类的时候 的，储存到堆区的内容，可以多次执行，实例化几次就可以执行几次，而**构造代码块是类加载时候储存到方法区的内容，类的加载只有一次，构造代码块也只有一个（`所以构造代码块先执行，并且只执行一次.`）.**
#### 7、一般函数怎么调用构造函数？（毕5-12）
```
 * 1.this() 可以调用类的构造函数，用于构造函数的相互调用
 * 2.调用1参构造效果等价于this.name = name;
 * 3. 一般函数不能使用this（）调用构造函数
 * 4. this语句只能放到构造函数的第一行，不然编译不通过，
 * 5. 不推荐使用this反复调用防止出现死循环
 * （特别是在低参数比如0参 Person(){}中调用高参数比如1this(name)参时候）
 * 
```

#### 8、实例变量和类变量的区别？（毕6-1）
（1）类变量就是static修饰的全局成员变量，实例变量就是没static修饰 的全局成员变量，
（2）static修饰的类变量在类的加载的时候通过 类加载过程中的2.2 准备阶段 就实现了 static 类变量的默认的初始化 (static int age = 0;)  3.0 阶段  的初始化中 和 静态代码块一起 初始化，获得自定义的的值（static int
age = 18）并且数据储存在 `方法区`
（3）实例变量在 运行时候 实例化类的时候 初始化，`数据储存在堆区而且每实例化一个对象就可以拥有新的对应的实例变量不像 static 只有一个.`
#### 9、为什么main主函数要用static修饰。（毕6-2）
（1）main作为程序的入口需要运行，
（2）如果不用static就需要先通过main的类的实例来调用类的方法，如何获得main所在类的实例呢？就又需要程序运行，如何运行程序呢？需要使用main作为入口...(反复套娃，程序就不用运行了)
（3）static修饰的方法在 类加载期时候的 3阶段初始化 就会 自动初始化，当初始化 static  main （）的时候也就进入 运行期了
类的加载过程参考我的博客
https://blog.csdn.net/jarvan5/article/details/106141558
#### 10、什么时候使用static。（毕6-3）
一般我们使用static有2个原因
（1）该变量会被反复创建销毁，为了节约内存资源干脆static1次解决
（2）static 在类加载期 初始化一次，通过 static  可以比面 多线程安全的问题，[可参考单例模式](https://blog.csdn.net/jarvan5/article/details/106201139)
#### 11、给出下列程序的输出结果顺序？（毕6-6）
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200519163056129.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
 Run：
 bb
 ee
 ff
 dd
 aa
```java
/**
 * Main类的static代码块：-------- 1.
 * StaticDemo_02的static代码块: -------- 2.
 * StaticDemo_02普通代码块：-------- 3.
 * StaticDemo_02构造函数 -------- 4.
 * <p>
 * 总结：
 * 1.先运行 Main的静态代码快，再运行 其他类的静态代码块，
 * 2.普通代码块（可初始化所有字段)优先构造函数的执行
 * 3.static 静态 在类加载时候执行，只执行一次，且
 * 优先于运行期 的 new Person（） 执行的非静态 普通代码块和构造函数
 */
public class Main {
    public static void main(String[] args) {
        new StaticDemo_02();
    }

    static {
        System.out.println("Main类的static代码块：-------- 1. ");
    }

    {
        System.out.println("Main类的普通代码块：--------5 Main由于没有构造普通不运行. ");
    }
}

class StaticDemo_02 {
    public StaticDemo_02() {
        System.out.println("StaticDemo_02构造函数 -------- 4.");
    }

    static {
        System.out.println("StaticDemo_02的static代码块: -------- 2.");
    }

    {
        System.out.println("StaticDemo_02普通代码块：-------- 3. ");
    }

}
```

#### 12、为什么java不支持多继承？（毕7-2）
>因为多继承会带来安全隐患：**多个父类定义了多个相同的功能的同时，子类不确定会使用哪一个.**
>如果一个小狗类（LittleDog）继承了2个类（LittleDog extend Dog ,Cat）
>LittleDog执行 vloice() 方法 的时候 不确定 使用 Dog 的 voice（） 还是 Cat的voice（）方法.
>
#### 13、请问下列语句是否可以正常编译执行？如果不能为什么？请问最简单的修改是怎么样的？（毕7-6）
public class ExtendsTest2{
	public static void main(String[] args){
		Zi z = new Zi();
	}
}
class Fu {
	Fu(int x){
		System.out.println("父类构造函数x = "+x);
	}
	
}
class Zi extends Fu{
	Zi(){
		this(3);	
	}
	Zi(int x){ 
		System.out.println("子类构造函数 "+x);
	}
	
}
**答：**
不能，**`运行子类继承父类的时候 会先 隐式地先执行执行父类的构造函数 super()`**
但是上面的代码没有父类的无参构造函数，无法继承，
所以给父类加上一个有无参构造即可

**给每一个实体类都添加无参构造是一个编码习惯.**


#### 14、抽象类和一般类的区别？（毕7-9）
```
 * 1.抽象类其实就是一种约束.用于框架的搭建，减少开发代码量.
 * 2.抽象abstract 修饰的类可以写抽象方法和非抽象方法
 * 3.抽象类不能new ，只能被子类继承然后 new subclass子类.
 * 4.抽象类可以有 construction 构造方法
 * 现在一般少使用抽象类，因为一个类的单继承多实现，建议使用接口..
```
#### 15、抽象类和接口的区别？（毕7-12，毕7-13）
https://blog.csdn.net/jarvan5/article/details/106219038
#### 16、内部类为什么直接可以访问外部类的成员（毕9-1）

**因为内部类有外部类的引用.（格式：A.this)**

https://blog.csdn.net/jarvan5/article/details/106219819
#### 17、局部内部类和成员内部类有什么区别？（毕9-1,9-2）
1. 局部内部类**方法内部**生命周期
2. 局部内部类不能使用 权限修饰符号修饰，就像局部变量一样.
3. 局部内部类不能定义static静态承成员
4.  局部内部类可直接访问外部类的成员变量，即使是私有的
#### 18、匿名内部类的优缺点？（毕9-4）
优点：简洁,其状态不会被外界干扰(多线程)
缺点：只能用一次

举个例子：多线程：
```java
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("1.Thread1: "+i);
                }
            }
        }.start();
```
		
或者：
```java
new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("3.合并后："+i);
                }
            }
        }).start();	
```