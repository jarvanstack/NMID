package Git.GitHub.NMID.week_04.programmingWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.实体类 User ，包含用户的：**姓名**，性别，年龄，**ip，端口**，
 */
public class User {
    //：**姓名**，性别，年龄，**ip，端口**，
    public static ExecutorService executorService = Executors.newFixedThreadPool(12);
    private String name;
    private String sex;
    private int age;
    private String ip;
    private int acceptPort;
    private int sendPort;

    public User(String name, String ip, int acceptPort, int sendPort) {
        this.name = name;
        this.ip = ip;
        this.acceptPort = acceptPort;
        this.sendPort = sendPort;
        this.sex = "男";
        this.age = 0;
        sendBasicInformationToServer();
    }

    /**
     * 自动发送基本信息.
     */
    private void sendBasicInformationToServer() {
        //多线程发送
        String messageTotal = "" + this.getIp() + "@" + this.getAcceptPort() + "@" + this.getName() + "@" + "null" + "@" + "basicInformation";
        executorService.submit(new Send(messageTotal.getBytes(), this.sendPort));
    }

    /**
     * @param message 信息
     * @param user    用户
     */
    public void sendMessageToServer(String message, String destinationId, User user) {
        message = user.getIp() + "@" + user.getAcceptPort() + "@" + user.getName() + "@" + message + "@" + destinationId;
        executorService.submit(new Send(message.getBytes(), sendPort));
    }

    /**
     * 接受 信息
     *
     * @return
     */
    public void recieve() {
        executorService.submit(new Recieve(this.acceptPort));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getAcceptPort() {
        return acceptPort;
    }

    public void setAcceptPort(int acceptPort) {
        this.acceptPort = acceptPort;
    }

    public int getSendPort() {
        return sendPort;
    }

    public void setSendPort(int sendPort) {
        this.sendPort = sendPort;
    }
}
