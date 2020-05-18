
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

### 二、类图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200518190230926.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)