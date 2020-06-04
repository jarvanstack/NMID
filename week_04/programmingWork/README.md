
### 一、需求分析

1．当用户上线时，服务器分配ID，同时向其他在线用户广播“xx用户以上线”。

2．列出用户ID，可以列出所有在线用户的ID。

3．能够实现私聊，对指定id的用户发送消息。

4．能够实现群发，向所有人群发消息。 （必须实现）

5．当用户下线时，广播“xx用户已经下线”。
### 二、设计
### 1.交互模型.
1.私聊模型
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603212500595.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.群发模型
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603212513627.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 2. 用例图
1.用户用例
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603200350341.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.服务器用例（感觉细节实现有点难搞）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200603211643401.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 3.类

类|名|介绍|
--|--|--|
1.用户类|User.java |，其他User的父类，调用,Send类，Recieve类，实现用户功能
2.具体用户类|User01.java,User02.java,User03.java|new User()类，实现User的具体方法.
3.具体服务器类|Server.java|调用JudgeAndSendMessage实现服务器的功能
4.多线程工具类JudgeAndSendMessage|JudgeAndSendMessage.java|判断信息，选择返回的信息和用户.调用ServerSend实现发送功能.
5.多线程工具类ServerSend|ServerSend.java |实现服务器的发送功能
6.多线程工具类Send|Send.java|用户的发送功能|
7.多线程工具类Recieve|Recieve.java|实现用户的发送功能|

### 三、问题：
#### 1. 服务端发送端口阻塞问题，因为多线程同时访问了端口，
>解决：强制使用多个端口，解决，求更好的方法

#### 2.客户端首次登入无法收到服务器的提示上线信息？HashMap是添加成功的，原因未知.


