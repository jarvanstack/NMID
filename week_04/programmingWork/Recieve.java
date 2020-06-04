package Git.GitHub.NMID.week_04.programmingWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 用于客户端的接受信息，防止阻塞使用多线程
 * 1.开Socket，使用自己的接收端口
 * 2.做package包
 * 3.接收并打印 while(true)
 * 4.异常关闭并提醒
 */
public class Recieve implements Runnable {
    private int recievePort;

    public Recieve(int recievePort) {
        this.recievePort = recievePort;
    }

    @Override
    public void run() {
        //声明构造分离
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket;


        try {
            //1.
            datagramSocket = new DatagramSocket(recievePort);
            //2.
            byte[] bytes = new byte[1024 * 10];
            datagramPacket = new DatagramPacket(bytes,0,bytes.length);
            //3.
            while (true){
                datagramSocket.receive(datagramPacket);
                String printMessage = new String(datagramPacket.getData(),0,datagramPacket.getLength())  ;
                System.out.println(printMessage);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (datagramSocket != null){
                datagramSocket.close();
            }
        }

    }
}
