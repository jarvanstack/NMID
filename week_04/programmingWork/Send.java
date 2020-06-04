package Git.GitHub.NMID.week_04.programmingWork;

import java.io.IOException;
import java.net.*;

public class Send implements Runnable {
    private byte[] messageBytes;//获取信息的字节
    private int sendPort;

    public Send(byte[] messageBytes, int sendPort) {
        this.messageBytes = messageBytes;
        this.sendPort = sendPort;
    }

    @Override
    public void run() {
        /**
         * 发送信息的的步骤
         * 1. new DatagramSocket(sendPort)新建Socket
         * 2. new DatagramPacket() 新建发送的包，包含发送的信息，和对方的账号密码
         * 3. datagramSocket.send(datagramPacket) 发送
         * 4. 关闭Socket.
         */
        //构造和定义分离。
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket;

        try {
            //1. new DatagramSocket(sendPort)新建Socket
            datagramSocket = new DatagramSocket(sendPort);
            //2. new DatagramPacket() 新建发送的包，包含发送的信息，和对方的账号密码
            datagramPacket = new DatagramPacket(messageBytes,//信息
                    0,//开始索引
                    messageBytes.length,//长度
                    InetAddress.getByName("localhost"),//目标地址
                    2000);//目标端口
            //3. datagramSocket.send(datagramPacket) 发送
            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.close
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
