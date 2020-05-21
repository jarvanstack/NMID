package Git.GitHub.NMID.week_03.programmingWork;

import java.util.Random;

/**
 * #### 4.主类 Demo
 * 1. 随机产生 借书Borrow 和还书的 线程.
 */
public class Demo {
    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            int number = random.nextInt(2);
            if (number == 0) {
                new Return().run();
            } else {
                new Borrow().run();
            }
        }
    }
}
