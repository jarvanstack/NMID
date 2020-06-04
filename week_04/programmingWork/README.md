
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

### 三、效果展示
#### 1.启动服务器
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604173419663.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 2.启动User01，张三
1.User01
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604195743758.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.服务器
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604173511201.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 3.启动User02
1.User02：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604200004150.png)
2.User01
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060420003323.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)

#### 4.启动User03
1.User03
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060417365074.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.User02
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604173713834.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
3.User01
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604173729999.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)


#### 5.来自张三User01的群发：
1.User01
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604201016915.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.User02
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604173931750.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
3.User03
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604173948325.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 6.来自李四User02的私聊
1.User02
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604200354711.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.User01张三
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604174227915.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
3.User03
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604174304551.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 7.王二麻子User03一怒之下退出群聊
1.User03
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604201057298.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.User02
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060420143618.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
3.User01
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060420145424.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
### 四、问题：
#### 1. 服务端发送端口阻塞问题，因为多线程同时访问了端口，
>解决：强制使用多个端口，解决，求更好的方法

#### 2.客户端首次登入有时无法收到服务器的提示上线信息？HashMap是添加成功的，原因未知.
>难道是UDP的丢包导致？下次用TCP试试

