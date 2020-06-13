#### 第六周学习笔记
#### 08月20日
#### 如果此页面有格式不兼容的问题[点击跳转到CSDN博客](https://blog.csdn.net/jarvan5/article/details/106680008)
### 一：HTML基础知识
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML基础知识</title>
</head>
<body>
    <h1>一号标题</h1>
    <h2>二号标题</h2>
    <h3>三号标题</h3>
    <h4>....</h4>
    <p>段落前后会换行相当于2个br标签</p>
    <br>
    <a href="https://github.com/dengjiawen8955/NMID">a标签是一个连接,在里面用连接href=“你的网站”</a>
    <img src="https://avatars3.githubuserc
    ontent.com/u/60028085?s=400&u=ea114d1889d432b0e32fc8d6b17c9f7202dd6808&v=4">
    <span>img标签是一个单身狗</span>
</body>
</html>
```
### 二：HTML超链接有哪些
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML超链接有哪些</title>
</head>
<body>
    <h3>1.超链接可以跳转到网页</h3>
    <a href="https://github.com/dengjiawen8955">跳转到我的GItHub</a>
    <h3>2.跳转到下载页面</h3>
    <a href="XXX.mp3">跳转到我的GItHub</a>
    <h3>3.超链接可以发送电子邮件</h3>
    <a href="jarvanDeng@163.com">使用默认的邮箱发送邮件</a>
    <h3>4.返回顶部链接到 # </h3>
    <a href="#">返回顶部（一般用于相对位置浮动的标签）</a>
    <h3>5.链接到对应的JavaScript代码执行特殊的功能（这个我还没用过，改天试试）</h3>
    <a href="javascript:....">JavaScript代码执行特殊的功能</a>
</body>
</html>
```
### 三：HTML创建表格
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML创建表格</title>
</head>
<body>
    <h3>一个简单的HTML表格</h3>
    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
        </tr>
        <tr>
            <td>1</td>
            <td>张三</td>
            <td>13</td>
        </tr>
        <tr>
            <td>2</td>
            <td>李四</td>
            <td>14</td>
        </tr>
        <tr>
            <td>3</td>
            <td>王五</td>
            <td>15</td>
        </tr>
    </table>
</body>
</html>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611100428406.png)
### 四：HTML中From表单
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML中From表单</title>
    <style>
        fieldset
        {
            width: 400px;
        }
    </style>
</head>
<body>
    <h3>表单就是用来用户输入信息的工具</h3>
    <h3>简单的表单的简介</h3>
    <h3>input 表单是单身狗</h3>
    <form action="post">
        <fieldset>
            <legend>1.文本域表单（Text Field）用来输入用户和密码</legend>
            <span>
                username: <input type="text" name="username">
            </span>
            <br>
            <span>
                password: <input type="password" name="password">
            </span>
        </fieldset>
    </form>
    <form action="post">
        <fieldset>
            <legend>2.单选按钮（Radio Buttons）</legend>
            <span>
                <input type="radio" name="sex" value="男">
            </span>
            <br>
            <span>
                <input type="radio" name="sex" value="女">
            </span>
        </fieldset>
    </form>
    <form action="post">
        <fieldset>
            <legend>3.复选框（Checkboxes）</legend>
            <span>
                <input type="checkbox" name="like_things" value="apple" >
            </span>
            <span>
                <input type="checkbox" name="like_things" value="banana">
            </span>
        </fieldset>
    </form>
    <form action="post">
        <fieldset>
            <legend>4.提交按钮summit</legend>
            <span>
                username: <input type="text" name="username">
            </span>
            <br>
            <span>
                password: <input type="password" name="password">
            </span>
            <span>
                <input type="submit" name="submit">
            </span>
        </fieldset>
    </form>
    <form action="post">
        <fieldset>5.预选下拉列表</fieldset>
        <select name="cars" id="">
            <option value="小车"></option>
            <option value="汽车"></option>
            <option value="公交车"></option>
        </select>
    </form>
    <form action="post">
        <fieldset>6.文本框</fieldset>
        <textarea name="diary" id="" cols="30" rows="10" style="width: 400px;" >
            hello HTML
        </textarea>
    </form>
</body>

</html>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611100453813.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
### 五：CSS（层叠样式）
1. 内联样式
2. 页面内样式
3. @inport样式
4. link链接样式

 冲突时 -- 1>2>3>4
### 六：CSS复合选择器
https://www.w3school.com.cn/cssref/css_selectors.asp
**==选择器是CSS的重点，难点==**
#### 1. 普通选择器
选择器|例子|例子描述
--|--|--
**element元素选择器**| p{color: red;}|全局p标签变为红色
**id选择器** |#name {}|全局选择 id="name"的标签
**class选择器**|.name{}|全局选择 class="name"的标签，**优先级：id>class > 元素**
**element1，element2**|h2,h3{}|全局选择h2和h3标签
**element 1 element2** |div p{}|选择全部div块里面的p段落标签
#### 2. 伪类选择器
选择器|例子|例子描述
--|--|--
:link|h3:link{color: red;}|h3标题在网页打开后的默认颜色是红色
:hover|h3:hover{}|h3标题在鼠标滑过的时候是红色
:active|h3:active{}|h3在点击的时候是红色
:visited|h3:visited{}|h3在参观后（点击后）是红色

还有很多选择器，参考博客


### 七：CSS文字效果

效果|例子|描述
|--|--|--|
字体颜色color|color  : red|字体颜色为红色
对齐方式text-align:left|text-align:left|对齐方式为左对齐
文本修饰text-decoration|text-decoration : underline|下划线修饰（还有overline上划线,line-through 中间滑过删除线）
text-transform文字转换|text-transform : uppercase|转换为大写字母（还有 lowercase 小写字母，capitalize首字母大写。
text-indent文本缩进|text-indent:50px |文本缩进 50 px
letter-spaceing字符间距|letter-spacing：30|字符字符之间的间距为 30 px
line-height行高|line-height：50px|每行间距 （行高）50 px
word-spacing单词之间的空白|word-spacing：30px|单词之间的空白为 30px（区别于字符之间的空白letter-spacing ）
write-space写空间|write-space：nowrap|禁止环绕
**text-shadow添加阴影**|text-shadow：2px 2px #FF0000 |添加长宽为 2px 的红色阴影


### 八：用CSS设置图像效果
        1、设置图片边框 
        border属性
        2、设置图片大小及缩放
         width 和 height
        3、图文混排
         float
        4、设置图片与文字的对齐方式 
        vertical-		align：middle
        
### 九：用CSS设置背景颜色和背景图像
background-color : red 
background-image: url()

### 十：盒模型
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613110906209.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
### 十一：用CSS设置样式
1. 内联样式
2. 页面内样式
3. @inport样式
4. link链接样式
 冲突时 -- 1>2>3>4
 样式设计实例：
 
### 十二：JavaScript简介
JavaScript是动态语言，现在所有的HTML 页面都用JavaScript让页面动起来（比如说按钮点击的效果）

JavaScript（通常缩写为JS）是一种高级的、**解释型的编程语言**。JavaScript是一门**基于原型、函数先行的语言**[9]，是一门**多范式的语言**，它支持**面向对象编程，命令式编程，以及函数式编程**。它提供语法来操控文本、数组、日期以及正则表达式等，不支持I/O，比如网络、存储和图形等，但这些都可以由它的宿主环境提供支持。

### 十三：基本语法
#### 1. 使用方法
1.直接写入到HTML里面
例如
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>直接写入到HTML里面</title>
</head>
<body>
    <script>
        document.write("<h3>这是一个从由js写入的h3标题");
        document.write("<p>这是一个从由js写入的p段落");
    </script>
</body>
</html>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613111831570.png)
2。对事件的反应alter（）
```html
    <button type="button" onclick="alert('hello world')">点击弹出alter提示</button>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613112138569.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
3.自定义函数然后onclick调用  **改变内容**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>自定义函数然后调用</title>
</head>
<body>
    <h3 id="change">按下按钮被改变的标题</h3>
    <button type="button" onclick="change()">单击按钮改变标题</button>
    <script>
        function change()
        {
            var x = document.getElementById("change");
            x.innerHTML = "已经改变";
        }
    </script>
</body>
</html>
```
4.改变图片_点击灯泡改变灯打开或者关闭
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>改变图片_点击灯泡改变灯打开或者关闭</title>
</head>
<body>
    <h3>点击灯泡改变灯打开或者关闭</h3>
    <img src="https://www.runoob.com/images/pic_bulboff.gif" id="lamp" onclick="changeLamp()">
    <script>
        function changeLamp(){
            var lamp = document.getElementById("lamp");
            if(lamp.src.match("off"))
            {
                lamp.src = "https://www.runoob.com/images/pic_bulbon.gif";
            }
            else
            {
                lamp.src = "https://www.runoob.com/images/pic_bulboff.gif";
            }
        }
    </script>
</body>
</html>
```
5.改变CSS样式
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>改变CSS样式</title>
</head>
<body>
    <h3 id="changeColor" onclick="changeColor()">点击改变颜色</h3>
    <script>
        function changeColor()
        {
            var x = document.getElementById("changeColor");
            x.style = "color: red;"
        }
    </script>
</body>
</html>
```
### 十四：JavaScript数组
JavaScript数组和java的数组不一样的是他是弱语言类型的数组，不用标注具体的数据类型.
#### 1.创建方法
1.创建然后赋值
```html
var peroson=new Array();
person[0] = "张三";
person[1] = "李四";
perosn[2] = "王二麻子";
```
2.创建时候赋值
```html
var peroson=new Array("张三","李四","王二麻子");
```
3.字面,直接数组，而不是对象.
```html
var person = ["张三","李四","王二麻子"]
```

### 十五：JavaScript对象
JavaScript万物皆对象
对象可以包含多个值
例如
对象的定义
```
var zhangsan={
name : "张三",
age： 13
sex ："男",
};

```
* 这里面只有对象的属性 通过 zhangsan.name 来访问他的name属性和java一致，里面还可以定义方法，定义方式和访问方式和java一致。
* 对象也可以先声明在定义。例如
```html
var zhangsan  = new Object();
zhangsan.name = "张三";
zhangsan.age = 13;
```
* 也可以使用对象构造器定义类似构造函数
```html
function person(name,age)
{
	this.name = name;
	this.age = age;
}
var zhangsan = new person("zhangsan",13);
```
### 十六：JavaScript对象函数
就是在对象里添加函数，和java类似
例如

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JavaScript对象函数</title>
</head>
<body>
    <script>
    function person(name ,age ){
        this.name = "张三";
        this.age = 13;
        this.changeName = changeName;
        function changeName(newName)
        {
            this.name = newName;
        }
    }
    dog = new person("dog",13);
    dog.changeName("狗子");
    document.write(dog.name);
    
    </script>
</body>
</html>
```
### 十七：JavaScript中DOM(document)节点
#### 1. 步骤
具体步骤看2点的注释.
#### 2. appendChild（）添加到末尾
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>appendChild（）添加到末尾</title>
</head>
<body>
    <h2>JavaScript中DOM(document)节点</h2>
    <h2> 2. appendChild（）添加到末尾</h2>
    <div id="demo01">
        <p>自然段落1</p>
        <p>自然段落2</p>
    </div>
    <script>
        var para = document.createElement("p");//1.新建一个p标签
        var node = document.createTextNode("新建段落3");//2新建一个node
        para.appendChild(node);//3.将新建的节点添加到 元素里
        //4.将组合好的元素添加到父框架里。
        var parentElement = document.getElementById("demo01");
        parentElement.appendChild(para);

    </script>
</body>
</html>
```
#### 3. insertBefore()插入到最前面
#### 4. removeChild（）移除一个元素
#### 5. replaceChild（）替换一个元素

### 十八：HTML CSS JavaScript三者的联系
#### 1. 
[一个有趣的网站形象介绍了HTML，CSS，JavaScript的联系](https://html-css-js.com/)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613142955626.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
#### 2.
* 1. HTML像组成你身体的手和各个部分，手，脚，头...（破碎的肢体）
* 2. CSS将他们按合适的拼接，美化，然后上合适的衣服。（完整的人体模特）
* 3.JavaScript为人体模特赋予**动**的能力，赋予了灵魂。
HTML + CSS + JavaScript 就能构成完整的**静态页面**。

