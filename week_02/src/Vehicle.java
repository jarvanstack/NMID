package Git.GitHub.NMID.week_02.src;

/**
 * 实体层：
 * 车的实体.包含车的各种属性.
 */
public class Vehicle {
    //构造 get
    private int id;                   //1. 序号 id
    private String name;               //2. 名称 name
    private int price;                 //3. 价格 price
    private float mixNumberLoad;         //4.1 最大载货（吨） mixNumberLoad
    private int mixNumberPeople;        //4.2 最大载人数
    private String typeOfCar;          //5. 类型（载客车，载货车，皮卡车.）typeOfCar
    //非构造
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
     * @param typeOfCar       5. 车的3种类型 载客车，载货车，皮卡车.
     */
    public Vehicle(int id, String name, int price, float mixNumberLoad, int mixNumberPeople, String typeOfCar) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mixNumberLoad = mixNumberLoad;
        this.mixNumberPeople = mixNumberPeople;
        this.typeOfCar = typeOfCar;
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
        if (mixNumberLoad == 0) {
            return "车辆序号: " + id + "、名称: " + name + "、费用: " + price + "、载货最大数量：" + mixNumberLoad;

        } else if (mixNumberPeople == 0) {
            return "车辆序号: " + id + "、名称: " + name + "、费用: " + price + "、载人最大数量：" + mixNumberPeople;
        } else {
            return "车辆序号: " + id + "、名称: " + name + "、费用: " + price + "、载人最大数量：" + mixNumberPeople + "、载货最大重量：" + mixNumberLoad;
        }
    }

    //增加加车而不是仅仅，设置车会覆盖之前的订购.
    public void addNumberOfCars(int numberOfCars) {
        this.numberOfCars += numberOfCars;
    }

    public void addRentalDays(int rentalDays) {
        this.rentalDays += numberOfCars;
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
        return mixNumberLoad * numberOfCars;
    }

    public void setMixNumberLoad(int mixNumberLoad) {
        this.mixNumberLoad = mixNumberLoad;
    }

    public int getMixNumberPeople() {
        return mixNumberPeople * numberOfCars;
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
