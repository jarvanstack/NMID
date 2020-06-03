### 第四周学习笔记
### 07月23日
### 一：集合的理解
集合就像是可变长度的数组，[具体看我的博客：](https://blog.csdn.net/jarvan5/article/details/105765865)

### 二：Hashtable
HashTable|区别|
--|--|
优点|**线程同步安全**
数据结构|哈希表
允许null?|**不能为空**
多线程同步？|支持线程同步，
缺点|**无法多线程，十分慢**
### 三：TreeMap
TreeMap|区别|
--|--|
优点|**可以排序**
数据结构|红黑树
储值方式|键值升序？
允许null?|**不能为空**
多线程同步？|不能同步，需要加锁。
缺点|**比HashMap效率低**
### 四：HashMap
HashMap|区别|
--|--|
优点|访问速度极快
常用|**最常用的Map**
数据结构|数组+链表（红黑树）
储值方式|使用hashcode储值（可以直接获取它的值，**访问速度极快**）
允许null?|**最多只允许一个值为null**
多线程同步？|不支持，会导致数据不一致。**需要加锁才行**（synchronizedMap？）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200602104522685.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
具体看我的博客

[Java集合 HashMap解析（源码分析）](https://blog.csdn.net/jarvan5/article/details/106460938)

### 五：三者的异同
集合|优点|允许null？|线程安全？|
--|--|--|--|
HashMap|速度极快，最常用|允许一个值为null，|不安全需要加锁
treeMap|可以排序|不能为空|不安全需要加锁
HashTable|线程安全（但是无法多线程十分慢）|不能为空|安全

### 六：IO基本操作 ，可以找下IO文件操作的模板代码
我的IO博客
1.
[Java IO教程 OutputStream InputStream 读写字节流](https://blog.csdn.net/jarvan5/article/details/105981694)
2.更多IO在我的博客搜索 【IO】

### 七：网络编程中TCP和UDP协议开发的基本流程，网上也有很多Demo代码
1.TCP 
 * 1.客户端Socket 连接 服务端
 * 2.客户端使用本地流，读取文件，使用网络流上传文件
 * 3. 服务端while(true)执行，并accept()到一个Socket连接，新建一个线程，
 * 4.服务端新建线程里,完成创建文件夹，文件的命名，网络流读取，本地流写入，并返回上传成功的提示
 * 5.客户端接受上传成功的提示.
 * 二、注意规范，
 * 1. 流先开后关，
 * 2. 变量的声明和定义分离. ServerSocket serverSocket = null;
 * 3.finally 用于关闭流，进行判断 if ( io != null) io.close()
[Java 网络编程 模拟TCP通信的代码实现 ;  4 个项目的练习题 ; 解决read()阻塞问题。](https://blog.csdn.net/jarvan5/article/details/106020509)
2.UDP
具体参考我的博客
[Java 网络编程 UDP协议 聊天小项目的实现教程和代码](https://blog.csdn.net/jarvan5/article/details/106041125)


### 八、语法知识：
#### 1、集合中add方法的参数为什么是Object？（14-2）
集合可以装所有数据类型
Object类是所有类的超类，
所以在实例化之前，所有集合都是是Object泛型。

#### 2、set和list的区别？（毕14-4）
1.set
```java
/**
 * 一、继承 Collection：拥有 6 个常用 方法，
 * 二、特用：
 *      1.不允许重复：  元素，
 *      2.没有索引：   类似 Collection ，不能用普通for遍历
 *      3.元素限制： 一些实现禁止空元素，有些实现对类型要使用<E>泛型支持
 *      4.无序
 *
 */
public class Set集合共性 {
    public static void main(String[] args) {
        Set <String> set = new HashSet();
        set.add("元素 1");
        for (int i = 0; i < 5; i++) {
            set.add("元素 "+i);
        }
        System.out.println(set);
        System.out.println("1.无序，2.不允许重复");
    }
}
```
2.list
```java
/**
 *一、extends Collection接口 共性方法
 *      1.add()      -- boolean
 *      2.remove(E e)  -- 返回被删除的元素 e
 *      3.size()
 *      4.toArray() 转化为数组
 *      5.isEmpty() 判断是否为空
 *      6.contains(E e) 判断是否包含
 *
 *二、特点：
 *      1.有序，就像队列一样，隧道，先进先出。
 *      2.有索引，包含一些带索引的方法
 *      3.允许重复的元素。
 * 三、特有的方法
 *      1.add(int index,E e) ,指定位置添加
 *      2.set(int index ,E e),指定位置修改，返回被修改的元素。
 */
public class List类 {
    public static void main(String[] args) {

    }
}
```
**总结：**
集合|允许重复？|索引有序？|null？
--|--|--|--
set|
list|Yes|Yes|Yes

#### 3、ArrayList和LinkedList，Vector的区别？（毕14-6）
ArrayLIst是数据结构是数组 数组查找块
LinkedList数据结构是链表 链表增删块
具体查看我的博客
[Java 集合 LinkdedList 教程 LikedList的特性、LinkedList常用方法、LinkedList 和 ArrayList的区别](https://blog.csdn.net/jarvan5/article/details/105799327)


[Java 集合 ArrayList类使用教程，ArrayList常用方法，使用泛型广泛代替传入ArrayList参数，ArrayList 的几个练习题教程，ArrayList和LinkdeList区别](https://blog.csdn.net/jarvan5/article/details/105755413)

#### 4、ArrayList，HashSet,TreeSet他们判断元素是否相同或者数保证元素唯一性的依据（或者说底层会调用什么方法）是什么？（毕14-14，15-3）
**1.**
```java
/**
 * #### 4、ArrayList，HashSet,TreeSet他们判断元素是否相同或者数保证元素唯一性的依据
 * （或者说底层会调用什么方法）是什么？（毕14-14，15-3）
 */
public class Demo {
    public static void main(String[] args) {
        HashSet<String> sets = new HashSet<>();
        String s = new String("1");
        System.out.println(sets.add(s));
        System.out.println(sets.add(s));
        System.out.println(sets);
    }
}
```
Run:
true
false
[1]

**2.**我们查看add()源码
（1）add()
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200602175248315.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200602175448542.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
（2）put()
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200602175639666.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
set的底层是map，给了个虚拟的value 值 PARENT ，键就是 set
然后通过 HashMap 的 putVal（）添值的方法添加值，所以底层是**通过hash值的比较**保证元素唯一性的依据，

具体看我的关于HashMap的博客

[Java集合 HashMap解析（源码分析）](https://blog.csdn.net/jarvan5/article/details/106460938)
#### 5、如何避免迭代器需要进行强制类型转换？（15-7）
创建集合之前就是用泛型
#### 6、<? extends E>和<? super E> 的区别？（毕15-13）
博客
[Java 泛型 泛型规范 extends 和 super 的区别？](https://blog.csdn.net/jarvan5/article/details/106504254)

#### 7、Map集合和Collection集合的区别？（毕16-1）
Map 是键值对
Collection 只有值

#### 8、keySet();和entrySet();的区别？（毕16-4,16-5）
keySet()是key值的set集合
entrySet()是键值对集合
#### 9、Collection和Collections的区别？（毕17-10）
我的博客
https://blog.csdn.net/jarvan5/article/details/106504524

#### 10、下面语句的输出结果？（毕17-12）
```java
  List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("kjaljd");
		list.add("alsd");
		list.add("akjka");
		int x = Collections.binarySearch(list,"alsd");
		System.out.println("x = "  + x);
```

不确定，二分法查找需要排序
-2
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200602213352192.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 11、Collections中reverse和reverseOrder的区别？（17-14）
1.看文档
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603110343406.png)
2.
* 1.Collections.reverse(list)将list反顺序，然后答应数组
* 2. Collections.reverseOrder(new ComparaTor) 是在建立treeSet 对象的时候使用。
3.代码实例.
```java
public class Demo {
    public static void main(String[] args) {
        /**
         * 1.reverse
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ccc");
        arrayList.add("dddd");
        arrayList.add("a");
        arrayList.add("bb");
        //System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println("正常排序后"+arrayList);
        Collections.reverse(arrayList);
        System.out.println("reverse()逆向排序后: "+arrayList);
        /**
         * 2.reverseOrder
         */
        System.out.println("------------");
        TreeSet<String> treeSet = new TreeSet<>(Collections.reverseOrder());
        treeSet.add("ccc");
        treeSet.add("dddd");
        treeSet.add("a");
        treeSet.add("bb");
        System.out.println("在构造TreeSet（）里添加反转后的比较器的效果.");
        System.out.println(treeSet);
    }
}
```
```
Run：
正常排序后[a, bb, ccc, dddd]
reverse()逆向排序后: [dddd, ccc, bb, a]
------------
在构造TreeSet（）里添加反转后的比较器的效果.
[dddd, ccc, bb, a]
```

#### 12、Arrays中asList方法将数组变成list集合后，为什么不能进行增删操作。（17-16）
源码分析：
1.asLIst()
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603113501140.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.ArrayList<>(a)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603113754478.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
把数组赋值给了一个常量，常量和数组长度都是是不可变的，不能增删


#### 13、传统for循环与增强for循环的区别？（毕17-18）
1.高级for循环是借助迭代法器的，
2.高级for是简洁的
3.**高级for不能获取下标和增删改操作**，
4.遍历输出集合可以使用高级for
5.遍历数组建议使用**普通for循环**

#### 14、写出下面代码的输出结果？（毕17-18）
```java
List<String> list = new ArrayList<>();
list.iterator();
list.add("java01");
list.add("java02");
list.add("java03");
for(String s : list){
	s = "kk";
}
System.out.println(list);
```
输出来的 java01,java02,java03

3.高级**for不能获取下标和增删改操作**，


#### 15、写出下面代码的输出结果（毕17-19）
```java
   show("a","b","c");
   public static void show(String ss,String... s){
		    for(int x =0;x < s.length;x++){
			   System.out.println(s[x]);
        }
		}
```

b c 
1. a传入的参数在 ss 这里，不是不定参数 s
2. b c 传递的参数才算不定参数。



#### 16、写出下面代码的输出结果（毕18-05）
```java
  System.out.println(Math.ceil(-17.20));
```
-17.0
Math 类的方法。
ceil 本意天花板，正向无穷大取整，进一法取整。
double Math.ceil(double number) 返回比传入参数大最小整数.

#### 17、下面两句代码的不同？（毕18-19）
  （1）FileWriter fw = new FileWriter(“demo.txt”);
  （2）FileWriter fw = new FileWriter(“demo.txt”，true);
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603143652311.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
  默认append为false
  
#### 18、下面代码的输出结果不考虑异常声明（毕18-11）
```java
FileReader fr = new FileReader("demo.txt");
			char[] arr = new char[2];
			fr.read(arr);
			System.out.print(new String(arr));
			fr.read(arr);
			System.out.print(new String(arr));
			fr.read(arr);
			System.out.print(new String(arr));
   “demo.txt”中内容
   ```
   每一次阅读2个字节的内容，（**指针移动**）然后将字节转化为字符串String，然后输出。
   编码|中文字符|英文字符
   --|--|--|
   UTF-8|24位，**3字节**|8位，**1字节**|
   GBK|16位，**2字节**，|8位，**1字节**

windows中国默认gbk编码，

#### 19、fileWriter.close(); 和 fileOutputStream.close();的区别是什么？（毕19-11）
关闭写入字节和字符
fileWriter是写入字符，不用担心编码问题，但是只能写入字符（不能写入图片小电影啥的）
fileOutputStream是写入的字节，万物皆字节，所以可以写入任何东西。
#### 20、下面代码的运行结果是什么？不考虑异常声明（毕19-11）
```java
FileInputStream fis = new FileInputStream("demo.txt");
System.out.println("len = " + fis.available());
fis.close();

 ```
       
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603145200986.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
  演示文件：
  所以会输出剩余的**字节数（区分字符）**；
  


#### 21、OutStreamWriter谁是谁通向谁的桥梁？OutputStreamWriter属于字节流体系还是字符流体系？（毕19-17）
这个就是指定编码的输入流，

字符流体系，**指定编码，解决乱码问题。**
还可以转换编码文件。

#### 22、File对象创建文件，和读取流对象创建文件有什么不同？（毕20-02）
File是操作的文件夹和文件，

IO流是输入输出，

IO流也可以的创建文件，和File创建文件的异同是什么呢？

对象|能否创建文件夹|能否创建文件|操作文件夹和文件|读写数据|
--|--|--|--|--
File|Yes|Yes|Yes|
IO ||Yes||Yes



#### 23、下面语句的输出结果，不考虑异常（毕20-3）

 File file = new File("aaa\\bbb"); // 该文件所在目录如下图
	System.out.println("mkdir结果" + file.mkdirs());

false


#### 24、ObjectOutputStream中write和writeInt。当传入的参数都是a(int类型)时，他们的区别？（毕21-01）
看源码：
1.write（）写入一个字节 1*8  8位。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603160911391.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.writeInt（）写入的是一个int数字。4字节 4*8  32位
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060316110173.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

#### 25、在对象流中，static修饰的基本数据，为什么不能写入文件中（毕21-1）  
static 在方法区

#### 26、TCP和UDP的区别？
TCP 3次握手 不会丢包，比如下载文件。
UDP 直接传数据，可能回丢包 ，比如在线直播，

具体查看我的博客
[Java 网络编程的三要素（协议 IP 端口号）,TCP 和 UDP 协议的区别，解析详解](https://blog.csdn.net/jarvan5/article/details/106015914)
#### 27、正则表达式的优缺点？（毕25-3）
缺点
1.可读性差
2.匹配复杂的数字和HTML很麻烦，
3.贪婪模式可能回引起性能问题，注意使用
优点：
1.对于合适的字符串来说，正则表达式十分强大。（比如邮箱，手机号等）

#### 28、正则匹配，组中“\n”和“$n”的区别？（毕25-4）
\n 匹配换行符号
$n 以 n 结尾
正则表达式手册：要用就查询
https://tool.oschina.net/uploads/apidocs/jquery/regexp.html


#### 29、Matcher对象中find和matches方法有什么区别？（毕25-6）

find就是找到，局部匹配和全部匹配都行
matches只能全局匹配器。