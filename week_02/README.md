
### 一、实现步骤
#### 1.汽车类实体层 
1.PassergerCar
```
 * #### 1.载客车 PassengerCar
 * 储存 以下字段
 * 构造
 * 1. 序号 id
 * 2. 名称 name
 * 3. 价格 price
 * 4. 最大载人数量 numbersOfPeopleEachCar
 * 5. 类型（载客车，载货车，皮卡车.）typeOfCar
 * -------------------
 * 非构造
 * 6. 个数 numberOfCars
 * 7. 租车天数  rentalDays
 * 8. 总价格.  totalPrice
 * `
```
2.Truck
```
 * #### 2. 载货卡车 Truck
 * 储存 以下字段
 * 构造
 * 1. 序号 id
 * 2. 名称 name
 * 3. 价格 price
 * 4. 最大载货（吨） mixNumberLoad
 * 5. 类型（载客车，载货车，皮卡车.）typeOfCar
 * -------------------
 * 非构造
 * 6. 个数 numberOfCars
 * 7. 租车天数  rentalDays
 * 8. 总价格.  totalPrice
 * 二、 要求
 * 1， 面向对象，低耦合高内聚
 * 2. 声明定义分离
```

3.PickupTruck 

```
 * #### 2. 皮卡车 PickupTruck
 * 储存 以下字段
 * 构造
 * 1. 序号 id
 * 2. 名称 name
 * 3. 价格 price
 * 4. 最大载货（吨） mixNumberLoad
 * //4.2 最大载人数量 mixNumberPeople
 * 5. 类型（载客车，载货车，皮卡车.）typeOfCar
 * -------------------
 * 非构造
 * 6. 个数 numberOfCars
 * 7. 租车天数  rentalDays
 * 8. 总价格.  totalPrice
```
#### 2. 数据层 初始化 车的数据(DateOfCar.java)
1.储存8种车的对象
2.将8种车的对象储存到HashMap集合里 hashMap

#### 3. 逻辑层实现逻辑 (BuyCar.java)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200518104808659.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
1. 展示车.
2. 选择车
2。2. 是否继续？
3. 结算
#### 4. 效果：
```$xslt
车辆序号: 1、名称: 小轿车、费用: 40、载人最大数量：4
车辆序号: 2、名称: 面包车、费用: 65、载人最大数量：7
车辆序号: 3、名称: 大巴车、费用: 180、载人最大数量：20
车辆序号: 4、名称: 低栏车、费用: 30、载货最大重量量：1.5
车辆序号: 5、名称: 高栏车、费用: 47、载货最大重量量：2.5
车辆序号: 6、名称: 厢式车、费用: 80、载货最大重量量：4.5
车辆序号: 7、名称: 日式皮卡车、费用: 60、载人最大数量：5、载货最大重量量：1.0
车辆序号: 8、名称: 美式皮卡车、费用: 60、载人最大数量：2、载货最大重量量：3.0
请输入你要租借的车的序号，回车键确认
1
请输入你租借的车的数量，回车确认
1
请输入你租借的车的时间(天数)，回车确认
-1
你输入的数据有误
请输入你要租借的车的序号，回车键确认
1
请输入你租借的车的数量，回车确认
1
请输入你租借的车的时间(天数)，回车确认
3
恭喜，订购成功！
序号：1、数量：1、租期：3
---
您要继续借车么(y/n)?
y
请输入你要租借的车的序号，回车键确认
1
请输入你租借的车的数量，回车确认
1
请输入你租借的车的时间(天数)，回车确认
6
恭喜，订购成功！
序号：1、数量：1、租期：6
---
您要继续借车么(y/n)?
n
1号载客车 数量: 1，租期：6（天），租金：240（元）
总体租用车辆总数: 1（辆）
总体租车的最大载人: 4（个）
总体租车的最大载货：0.0（吨）
总体租车费用: 240（元）

Process finished with exit code 0

```

### 二、类图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200518190230926.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)