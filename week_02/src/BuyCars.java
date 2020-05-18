package Git.GitHub.NMID.week_02.src;

import java.util.HashMap;
import java.util.Set;

/**
 * 三、买车的逻辑层。实现买车的逻辑
 * 1. 展示车.
 * 2. 选择车
 *      2.2. 是否继续？
 * 4. 结算
 */
public class BuyCars {
     HashMap<Integer,Object> allCars;
     //初始化数据
     public void init(){
         allCars = new DateOfCar().allCars;
     }

    /**
     * 1. 展示车.
     */
    public void diplayModels(){
        Set<Integer> keySet = allCars.keySet();
        for (Integer key : keySet) {
            System.out.println(allCars.get(key));
        }
    }
    public static void main(String[] args) {
        BuyCars buyCars = new BuyCars();
        buyCars.init();
        buyCars.diplayModels();
    }
}
