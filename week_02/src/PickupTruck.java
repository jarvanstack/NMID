package Git.GitHub.NMID.week_02.src;

/**
 * 一、包含内容
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
 * 二、 要求
 * 1， 面向对象，低耦合高内聚
 * 2. 声明定义分离
 */
public class PickupTruck {
    //构造 get
    private int id;                   //1. 序号 id
    private String name;               //2. 名称 name
    private int price;                 //3. 价格 price
    private float mixNumberLoad;         //4.1 最大载货（吨） mixNumberLoad
    private int mixNumberPeople;        //4.2 最大载人数
    //非构造
    private String typeOfCar;          //5. 类型（载客车，载货车，皮卡车.）typeOfCar
    private int numberOfCars;  //6. 个数 numberOfCars
    private int rentalDays;    //7. 租车天数  rentalDays
    private int totalPrice;    //8. 总价格.  totalPrice

    /**
     * 构造函数，初始化值.
     *
     * @param id              1. 序号 id
     * @param name            2. 名称 name
     * @param price           3. 价格 price
     * @param mixNumberLoad   4. 最大载货（吨） mixNumberLoad
     * @param mixNumberPeople 4.2 最大载人数
     */
    public PickupTruck(int id, String name, int price, float mixNumberLoad, int mixNumberPeople) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mixNumberLoad = mixNumberLoad;
        this.mixNumberPeople = mixNumberPeople;
        typeOfCar = "皮卡车";
    }

    /**
     * @return getTotalPrice总价格.
     */
    public int getTotalPrice() {
        return price * numberOfCars * rentalDays;
    }

    //展示 车辆序号 id、名称(name)、费用(price)、载人（货）能力
    @Override
    public String toString() {
        return "车辆序号: " + id + "、名称: " + name + "、费用: " + price + "、载人最大数量：" + mixNumberPeople + "、载货最大重量量：" + mixNumberLoad;
    }
//------------------------------getter（） setter（）-------------------


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getMixNumberLoad() {
        return mixNumberLoad;
    }

    public void setMixNumberLoad(int mixNumberLoad) {
        this.mixNumberLoad = mixNumberLoad;
    }

    public int getMixNumberPeople() {
        return mixNumberPeople;
    }

    public void setMixNumberPeople(int mixNumberPeople) {
        this.mixNumberPeople = mixNumberPeople;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

