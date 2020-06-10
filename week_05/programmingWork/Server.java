package Git.GitHub.NMID.week_05.programmingWork;

import Git.GitHub.NMID.week_04.programmingWork.JudgeAndSendMessage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 3.服务器类Server，while（true）接受消息，如果接受到消息就开启判断发送消息的多线程JudgeMessage。
 */
public class Server {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static HashMap<Integer, String> users = new HashMap<>();
    public static int countUser = 0;

    /**
     * UDP 接受消息：
     * 1.开 Socket new dagSocket，
     * 2.新建接受包 new dapackege
     * 3.while true 阻塞接受
     * 4.判断发送消息的多线程JudgeAndSendMessage。
     */
    private static void recieve() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                //声明定义分离
                DatagramSocket datagramSocket;
                DatagramPacket datagramPacket;
                try {
                    //1.
                    datagramSocket = new DatagramSocket(2000);
                    //2.
                    byte[] bytes = new byte[1020 * 10];
                    byte[] toJudgebytes = new byte[1020 * 10];
                    datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
                    System.out.println("Server: 启动成功，");
                    //3.
                    while (true) {
                        //阻塞接受
                        System.out.println("Server: 等待数据.");
                        datagramSocket.receive(datagramPacket);
                        //4.4.判断发送消息的多线程JudgeAndSendMessage。
                        toJudgebytes = new String(datagramPacket.getData(), 0, datagramPacket.getLength()).getBytes();
                        executorService.submit(new JudgeAndSendMessage(toJudgebytes));
                        System.out.println("Server: 接受数据: " + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));

                    }

                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        recieve();
    }
}
