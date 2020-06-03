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
1.用户类|User.java |，其他用户调用User实现多个用户,即可。
2.发送信息类|  Send.java|开多线程发送信息
3.接受信息类|  Receive.java|开多线程接受信息.

### 三、实现步骤
1.服务器开启，开始接受信息，接受到就创建新线程并判断：首次信息的就将，姓名，ip,端口，并分配id并储存。（**这里使用一个HashMap集合储存所有用户id值和信息，**）
2.然后向所有的用户广播，新用户上线。
3.用户向服务器发送信息和指定对方的id，
4.然后服务器拆除id,判断是否（0）群发或者（id）私聊
5.如果是（-1）就在HashMap中删除对应的 id,