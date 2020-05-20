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
        allCars = new DateOfCar().getAllCars();
    }

    /**
     * 1. 展示车.
     */
    public void displayCars() {
        Set<Integer> keySet = allCars.keySet();
        for (Integer key : keySet) {
            System.out.println(allCars.get(key));
        }
        System.out.println("多次选择重复的车会自动为您累加车辆和租期");
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
            if (allCars.keySet().contains(id)) {
                Vehicle vehicle = (Vehicle) allCars.get(id);
                vehicle.addNumberOfCars(numberOfCars);
                vehicle.addRentalDays(rentalDays);
                System.out.println("恭喜，订购成功！");
                System.out.println("序号：" + id + "、数量：" + numberOfCars + "、租期：" + rentalDays);
                System.out.println("---");
                System.out.println("您要继续借车么(y/n)?");
                isContinue = scanner.next().toLowerCase().charAt(0) == 'y';

            } else {
                System.out.println("你输入的数据有误");
            }
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
        System.out.println("各个车辆的租用数目清单：");
        System.out.println();
        int count = 0;
        for (Integer integer : keySet) {
            Vehicle vehicle = (Vehicle) allCars.get(integer);
            totalNumberOfCars += vehicle.getNumberOfCars();//总体租用车辆总数:
            totalMaxPeopel += vehicle.getMixNumberPeople();//总体租车的最大载人
            totalMaxLoad += vehicle.getMixNumberLoad();//总体租车的最大载货
            totalTotalPrice += vehicle.getTotalPrice();//总体租车费用: "
            //各个车辆的租用数目（分行列出，数目为0不用列出）
            if (vehicle.getNumberOfCars() > 0) {
                count++;
                System.out.println(count + ". 车辆名称: " + vehicle.getName() + "、" +
                        "数量：" + vehicle.getNumberOfCars() +
                        "、租期：" + vehicle.getRentalDays() +
                        "、此类型总费用: " + vehicle.getTotalPrice());
            }
        }
        System.out.println("总体租用车辆总数: " + totalNumberOfCars + "（辆）");
        System.out.println("总体租车的最大载人: " + totalMaxPeopel + "（个）");
        System.out.println("总体租车的最大载货：" + totalMaxLoad + "（吨）");
        System.out.println("总体租车费用: " + totalTotalPrice + "（元）");

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
