package Git.GitHub.NMID.week_04.programmingWork;

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
    private static User user01 = new User("张三", "localhost", 1001,1011);
    public static void main(String[] args) {
        /**
         * (1)new User(),
         */
        String message;
        String destinationId;
        Scanner scanner = new Scanner(System.in);
        user01.recieve();
        while (true){
            System.out.println("-- 您要发送的信息:");
            message = scanner.nextLine();
            System.out.println("-- 你要发送用户的id:");
            destinationId = scanner.nextLine();
            user01.sendMessageToServer(message,destinationId,user01);
        }
    }
}
