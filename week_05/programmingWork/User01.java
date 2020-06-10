package Git.GitHub.NMID.week_05.programmingWork;

import Git.GitHub.NMID.week_04.programmingWork.User;

import java.util.Scanner;

/**
 * 实体类User01，
 * 1.发送信息
 * (1)new User(),,sendBasicInformationToServer()发送基本信息，
 * (2)调用user()的方法，sendMessageToServer()发送基本信息.
 * 2.接受信息
 * (1)user类使用接受方法recieve()，开启一个多线程阻塞接受信息
 */
public class User01 {
    private static Git.GitHub.NMID.week_04.programmingWork.User user01 = new User("张三", "localhost", 1001,1011);
    public static void main(String[] args) {
        /**
         * (1)new User(),
         */
        String message;
        String destinationId;
        Scanner scanner = new Scanner(System.in);
        user01.recieve();
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-- 您要发送的信息:");
            message = scanner.nextLine();
            System.out.println("-- 你要发送用户的id:");
            destinationId = scanner.nextLine();
            user01.sendMessageToServer(message, destinationId, user01);
            if (destinationId.contains("-1")) {
                System.out.println("-- 退出聊天");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-- 退出成功");
                System.exit(0);
            }
        }
    }
}
