### 第七周学习笔记
### 06月29日

### 一、Maven项目
1.下载maven包，解压
2.配置maven环境即可
### 二、Tomcat安装
1.下载Tomcat包，解压
2.配置Tomcat环境即可
### 三、Servlet
#### 1. Servlet继承树
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200703150058890.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 2. Servlet常见使用方法
1. 继承extends HttpServlet 这个类，然后重写doGet(),doPost()方法即可（2个方法可以互相调用）


>然后 Tomcat服务器会自动接收浏览器端的http请求，通过映射访问的地址，执行对应的的Servlet


### 四、Servlet生命周期
#### 1. init（）启动，调用一次
1. 初始化的时候调用一次，**后续的用户访问将不再调用**
2. 如何初始化？ 
用户第一次访问Servlet的映射的时候，就初始化，后面的用户访问同一个Servlet映射将不再初始化
>你也可以指定在服务器加载的时候顺便加载。
3. 后面的用户访问如何访问数据？
用户抵用一个Servlet实例的时候就会产生一个Servlet实例，每个用户的请求都会产生一个新的线程，然后判断get or post 给对应的方法处理请求。
4. init（）创建时候还会加载一些配置信息 方法如下
```java
public void init() throws ServletException {
//初始化代码
}
```
#### 2 . service（）方法 ，每次调用
收到浏览器的http请求后，就会产生一个新线程调用service方法**确定http的请求类型（get(),post()?)然后交给get()或者post方法处理。**
#### 3.  doGet(), doPost() 每次调用
和service一致，这个2个最常见的处理请求的方法。
#### 4. destroy() 方法。
和init（）方法一致，这个方法在Servlet生命周期类只调用一次。
* 执行的类似于 关闭相关数据库的连接，停止后台进程，把Cookie列表或者点击的计数器写入到磁盘，并执行其他类似的清理活动。
#### 5. 架构图
* web 服务器 （Tomcat）监听到用户的请求，就看看检查，访问的资源，如果是Servlet，就给Servlet容器处理
* 第一次处理就会执Servlet类，就会执行init（）方法，以后就不必要的
* 每一个请求都会创建一个创建一个新线程，创建一个Servlet的实例对象，（堆区）然后执行对象的service（）方法判断请求的方式（get or post)
* 执行对应的get post 方法，然后返回数据给 Servlet容器，Servlet容器返回数据给 web server（Tomcat），
* Tomcat 响应用户内容，请求--响应结束。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200703154306659.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)


### 五、Request和Response
获取用户的请求的输入 使用 request

返回用户的问题找response

具体参考博客
https://blog.csdn.net/jarvan5/article/details/107108185

### 六、Cookie和Session

Cookie 是储存到客户端的数据，Session是储存到服务端的，
* Cookie的详解
https://blog.csdn.net/jarvan5/article/details/106785919

* Session详解
https://blog.csdn.net/jarvan5/article/details/106788305

### 七、Filter和Listener
Filter是过滤器，Listener是监听器
Filter可以用来实现过滤 字符乱码的问题，和无Session强制访问的拦截。

Listener 可以在线人数的监听。
* Filter详解 https://blog.csdn.net/jarvan5/article/details/106850785

https://blog.csdn.net/jarvan5/article/details/106839219

* Listener 详解
https://blog.csdn.net/jarvan5/article/details/106841464
### 八、HTTP协议
HTTP协议，就是浏览器发送数据的基本协议，
使用**应用层HTTP协议把数据传输到 传输层**，
* 报文

http协议详解

https://blog.csdn.net/jarvan5/article/details/106697296

### 九、**POSTMAN的使用**


### 十、JSON