
### 一、实现步骤
#### 1.汽车类实体层 
Vehicle类.
```
 * #### 1.
 * 储存 以下字段
 * 构造
 * 1. 序号 id
 * 2. 名称 name
 * 3. 价格 price
 * 4. 最大载货物数量 mixNumberLoad
 * 4.2 最大载人数量 mixNumberPeople
 * 5. 类型（载客车，载货车，皮卡车.）typeOfCar
 * -------------------
 * 非构造
 * 6. 个数 numberOfCars
 * 7. 租车天数  rentalDays
 * 8. 总价格.  totalPrice
 * `
```
#### 2. 数据层 DateOfCar

用来储存，车的数据，放入一个HashMap里面.

#### 3. 逻辑层，buyCar
1. 展示车.
2. 选择车
2.2. 是否继续？
3. 结算
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200518104808659.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
### 三、解决的问题：

#### 逻辑层的实现并没有实现可拓展性,HashMap 储值后就，必须使用相应的序号拿出，而不是通过自动的比较,导致数据层就白搭了

1. 解决方案1 ：3种车继承 Vehicle 交通工具类，然后构造的时候传入3种车车型，调用的时候先遍历对应的数字，然后强转Vehicle，get 车型，根据对应的车型再强转对应的3种车型中的一种，实现代码的简化和数据层的可复用.(**导入新的问题**，继承的使用导致了该类无法继承其他类，拓展性降低)

2. 解决方案2：使用草鸡大类 Vehicle 拥有 之前3种车的所有字段.
构造的时候全部构造，不能载物或者人的就给0 就可以了.
