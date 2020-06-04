package Git.GitHub.NMID.week_04.programmingWork;

import java.io.IOException;
import java.net.*;
import java.util.Random;

/**
 * 多线程实现服务器Server到用户User的私发或者广播
 * 1.对方的 IP和端口
 * 2.需要发送的信息
 */
public class ServerSend implements Runnable {
    private String ip;
    private int port ;
    private String message;

    public ServerSend(String ip, int port, String message) {
        this.ip = ip;
        this.port = port;
        this.message = message;
    }

    /**
     * 用来发送信息给用户User
     * 1.开Socket
     * 2.打包Package
     * 3.发送
     * 4.关闭
     */
    @Override
    public void run() {
        //定义声明分离
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket;
        try {
            //1.
            datagramSocket = new DatagramSocket(2010+new Random().nextInt(1000));
            //2.打包
            datagramPacket = new DatagramPacket(
                    message.getBytes(),
                    0,message.getBytes().length,
                    InetAddress.getByName(ip),
                    port);
            //3.发送
            datagramSocket.send(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.
            if (datagramSocket != null){
                datagramSocket.close();
            }
        }

    }
}
