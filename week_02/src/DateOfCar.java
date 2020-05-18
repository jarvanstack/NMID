package Git.GitHub.NMID.week_02.src;

import java.util.HashMap;

/**
 * 二、数据区储存层 车的数据
 */
public class DateOfCar {
    public   PassengerCar 小轿车     = new PassengerCar(1,"小轿车",40,4);
    public   PassengerCar 面包车     = new PassengerCar(2,"面包车",65,7);
    public   PassengerCar 大巴车     = new PassengerCar(3,"大巴车",180,20);
    public   PassengerCar 低栏车     = new PassengerCar(4,"低栏车",30,4);
    public   PassengerCar 高栏车     = new PassengerCar(5,"高栏车",47,4);
    public   PassengerCar 厢式车     = new PassengerCar(6,"厢式车",80,4);
    public   PassengerCar 日式皮卡车 = new PassengerCar(7,"日式皮卡车",60,4);
    public   PassengerCar 美式皮卡车 = new PassengerCar(8,"美式皮卡车",60,4);
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
