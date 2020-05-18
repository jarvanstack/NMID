package Git.GitHub.NMID.week_02.src;

import java.util.HashMap;

/**
 * 二、数据区储存层 车的数据
 */
public class DateOfCar {
    public   PassengerCar 小轿车     = new PassengerCar(1,"小轿车",40,4);
    public   PassengerCar 面包车     = new PassengerCar(2,"面包车",65,7);
    public   PassengerCar 大巴车     = new PassengerCar(3,"大巴车",180,20);
    public   Truck 低栏车     = new Truck(4,"低栏车",30, 1.5f);
    public   Truck 高栏车     = new Truck(5,"高栏车",47,  2.5f);
    public   Truck 厢式车     = new Truck(6,"厢式车",80,4.5f);
    public   PickupTruck 日式皮卡车 = new PickupTruck(7,"日式皮卡车",60,1.0f,5);
    public   PickupTruck 美式皮卡车 = new PickupTruck(8,"美式皮卡车",60,3.0f,2);
    public  HashMap<Integer, Object> allCars = new HashMap();



    /**
     * 构造函数初始化，定义hashMap的值
     */
    public DateOfCar() {
        allCars.put(小轿车  .getId(),小轿车  );
        allCars.put(面包车  .getId(),面包车  );
        allCars.put(大巴车  .getId(),大巴车  );
        allCars.put(低栏车  .getId(),低栏车  );
        allCars.put(高栏车  .getId(),高栏车  );
        allCars.put(厢式车  .getId(),厢式车  );
        allCars.put(日式皮卡车.getId(),日式皮卡车);
        allCars.put(美式皮卡车.getId(),美式皮卡车);
    }
}
