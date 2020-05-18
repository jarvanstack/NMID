package Git.GitHub.NMID.week_02.src;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 三、买车的逻辑层。实现买车的逻辑
 * 1. 展示车.
 * 2. 选择车
 * 2.2. 是否继续？
 * 3. 结算
 */
public class BuyCars {
    HashMap<Integer, Object> allCars;

    //初始化数据
    public void init() {
        allCars = new DateOfCar().allCars;
    }

    /**
     * 1. 展示车.
     */
    public void displayCars() {
        Set<Integer> keySet = allCars.keySet();
        for (Integer key : keySet) {
            System.out.println(allCars.get(key));
        }
    }

    /**
     * * 2. 选择车
     * *      2.2. 是否继续？
     */
    public void chooseCars() {
        //声明定义分离
        boolean isContinue = true;
        int id;
        int numberOfCars;
        int rentalDays;
        while (isContinue) {
            System.out.println("请输入你要租借的车的序号，回车键确认");
            Scanner scanner = new Scanner(System.in);
            id = scanner.nextInt();
            System.out.println("请输入你租借的车的数量，回车确认");
            numberOfCars = scanner.nextInt();
            System.out.println("请输入你租借的车的时间(天数)，回车确认");
            rentalDays = scanner.nextInt();
            if (id <= 0 || id > 8 || numberOfCars < 0 || rentalDays < 0) {
                System.out.println("你输入的数据有误");
                continue;
            } else if (id <= 3) {
                PassengerCar passengerCar = (PassengerCar) allCars.get(id);
                passengerCar.setNumberOfCars(numberOfCars);
                passengerCar.setRentalDays(rentalDays);
            } else if (id > 3 && id <= 6) {
                Truck truck = (Truck) allCars.get(id);
                truck.setNumberOfCars(numberOfCars);
                truck.setRentalDays(rentalDays);
            } else if (id > 6 && id <= 8) {
                PickupTruck pickupTruck = (PickupTruck) allCars.get(id);
                pickupTruck.setNumberOfCars(numberOfCars);
                pickupTruck.setRentalDays(rentalDays);
            }
            System.out.println("恭喜，订购成功！");
            System.out.println("序号：" + id + "、数量：" + numberOfCars + "、租期：" + rentalDays);
            System.out.println("---");
            System.out.println("您要继续借车么(y/n)?");
            isContinue = scanner.next().toLowerCase().charAt(0) == 'y';
        }

    }

    /**
     * 3. 结算
     * (2)  结算与展示内容包括：
     * 1.各个车辆的租用数目（分行列出，数目为0不用列出）租车天数，
     * 2.租用车辆总数，
     * 3.总体租车的最大载人量，
     * 4.总体租车的最大载货量，
     * 5、总体租车费用，
     */
    private void checkBills() {
        //2.租用车辆总数
        int totalNumberOfCars = 0;
        //3 4 总体租车的最大载人（货）量，
        float totalMaxLoad = 0;
        int totalMaxPeopel = 0;
        //5.总体租车费用，
        int totalTotalPrice = 0;
        Set<Integer> keySet = allCars.keySet();
        for (Integer key : keySet) {
            if (key <= 3) {

                PassengerCar passengerCar = (PassengerCar) allCars.get(key);
                //1.各个车辆的租用数目（分行列出，数目为0不用列出）
                if (passengerCar.getNumberOfCars() > 0) {
                    System.out.println(key + "号" + passengerCar.getTypeOfCar() + " 数量: " + passengerCar.getNumberOfCars() + "，租期：" + passengerCar.getRentalDays() + "（天），租金：" + passengerCar.getTotalPrice() + "（元）");
                    totalNumberOfCars += passengerCar.getNumberOfCars();
                    totalMaxPeopel += passengerCar.getMixNumberPeople();
                    totalTotalPrice += passengerCar.getTotalPrice();
                }
            }
            else if(key > 3 && key<7){
                Truck truck = (Truck) allCars.get(key);
                //各个车辆的租用数目（分行列出，数目为0不用列出）
                if (truck.getNumberOfCars() > 0) {
                    System.out.println(key + "号" + truck.getTypeOfCar() + " 数量: " + truck.getNumberOfCars() + "，租期：" + truck.getRentalDays() + "，租金：" + truck.getTotalPrice());
                    totalNumberOfCars += truck.getNumberOfCars() * truck.getNumberOfCars();
                    totalMaxLoad += truck.getMixNumberLoad() * truck.getNumberOfCars();
                    totalTotalPrice += truck.getTotalPrice() * truck.getNumberOfCars();
                }
            }
            else if (key <=8){
                PickupTruck pickupTruck = (PickupTruck) allCars.get(key);
                //各个车辆的租用数目（分行列出，数目为0不用列出）
                if (pickupTruck.getNumberOfCars()>0) {
                    System.out.println(key + "号" + pickupTruck.getTypeOfCar() + " 数量: " + pickupTruck.getNumberOfCars() + "，租期：" + pickupTruck.getRentalDays() + "，租金：" + pickupTruck.getTotalPrice());
                    totalNumberOfCars += pickupTruck.getNumberOfCars();
                    totalMaxPeopel += pickupTruck.getMixNumberLoad();
                    totalMaxLoad += pickupTruck.getMixNumberLoad();
                    totalTotalPrice += pickupTruck.getTotalPrice();
                }
            }

        }
        System.out.println("总体租用车辆总数: "+totalNumberOfCars+"（辆）");
        System.out.println("总体租车的最大载人: "+totalMaxPeopel+"（个）");
        System.out.println("总体租车的最大载货："+totalMaxLoad+"（吨）");
        System.out.println("总体租车费用: "+totalTotalPrice+"（元）");

    }

    public static void main(String[] args) {
        BuyCars buyCars = new BuyCars();
        buyCars.init();
        //1. 展示车.
        buyCars.displayCars();
        // * 2. 选择车
        // *      2.2. 是否继续？
        buyCars.chooseCars();
        //3. 结算
        buyCars.checkBills();
    }
}
