package Git.GitHub.NMID.week_04.programmingWork;

public class JudgeAndSendMessage implements Runnable {
private byte[] bytes ;

    public JudgeAndSendMessage(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public void run() {
        String sourceUser = new String(bytes);
        String[] split = sourceUser.split("@");
        //String someText= ""+user.getIp()+"@"-----0 ip
        // +user.getAcceptPort()+"@"+  ------------1 acceptPort
        // user.getName()+"@"+ --------------------2 name
        // message ;(message@id)                   3 message
        //                                         4 目标id

        //(1）添加用户+广播
        if (split[4].contains("basicInformation")){
            //添加用户到User。分配id,储存端口和名字.
            Server.users.put(++Server.countUser,split[0]+"@"+split[1]+"@"+split[2]);

            //广播现有用户.
            //(1)获取现有用户的名称和id 为一个字符串
            StringBuilder currentUsers = new StringBuilder();
            currentUsers.append("### （有人上线）： "+split[2]+"\n");
            currentUsers.append("### （聊天室现有成员）： ");
            for (Integer key : Server.users.keySet()) {
                String[] users = Server.users.get(key).split("@");
                currentUsers.append("名字:"+users[2]+" id:"+key+"，");
            }


            for (Integer key : Server.users.keySet()) {
                String[] users = Server.users.get(key).split("@");
                Server.executorService.submit(new ServerSend(users[0],//遍历所有人的ip
                        Integer.valueOf(users[1]), //遍历所有人端口
                        //广播现有用户的名称和id 为一个字符串
                        currentUsers.toString()));
            }

            System.out.println(sourceUser + " 添加成功");

        }
        //(2)删除用户
        else if (split[4].contains("-1")){
            int idNeedToRemove = -1;
            //遍历map
            for (Integer integer : Server.users.keySet()) {
                //删除用户
                if (Server.users.get(integer).contains(split[2])){
                    Server.users.remove(integer);
                    idNeedToRemove = integer;
                    break;
                }
            }
            //广播删除用户
            for (Integer key : Server.users.keySet()) {
                String[] users = Server.users.get(key).split("@");
                Server.executorService.submit(new ServerSend(users[0],//遍历所有人的ip
                        Integer.valueOf(users[1]), //遍历所有人端口
                        "name:"+split[2]+",id:"+idNeedToRemove+"已经下线"));//广播的内容，名字+被删除的id+
            }
            //广播现有用户.
            //(1)获取现有用户的名称和id 为一个字符串
            StringBuilder currentUsers = new StringBuilder();
            currentUsers.append("### （有人下线）： "+split[2]+"\n");
            currentUsers.append("### （聊天室现有成员）： ");
            for (Integer key : Server.users.keySet()) {
                String[] users = Server.users.get(key).split("@");
                currentUsers.append("名字:").append(users[2]).append(" id:").append(key).append("，");
            }

            for (Integer key : Server.users.keySet()) {
                String[] users = Server.users.get(key).split("@");
                Server.executorService.submit(new ServerSend(users[0],//遍历所有人的ip
                        Integer.parseInt(users[1]), //遍历所有人端口
                        //广播现有用户的名称和id 为一个字符串
                        currentUsers.toString()));
            }
            System.out.println(sourceUser+" 删除成功");

        }
        //(3)群发
        else if (split[4].contains("0")){
            //1.遍历所有用户
            for (Integer key : Server.users.keySet()) {
                String[] users = Server.users.get(key).split("@");
                Server.executorService.submit(new ServerSend(users[0],//遍历所有人的ip
                        Integer.parseInt(users[1]), //遍历所有人端口
                        //发送传入的信息 message
                        "### "+split[2]+"@全体成员: "+split[3]));
            }
            System.out.println(sourceUser+" 群发成功");

        }
        //（4）私发
        else{
            for (Integer key : Server.users.keySet()) {
                if (key.toString().contains(split[4])) {
                    System.out.println("目标id ：" + split[4]);
                    String[] users = Server.users.get(key).split("@");

                    Server.executorService.submit(new ServerSend(users[0],
                            Integer.parseInt(users[1]),
                            //发送传入的信息 message
                            "### " + split[2] + "对你的私聊: " + split[3]));
                }
            }
            //返回原发送人发送成功的信息
            Server.executorService.submit(new ServerSend(split[0],
                    Integer.parseInt(split[1]),
                    (split[3] + " 发送成功")
            ));
            System.out.println(sourceUser + " 私聊成功");

        }

    }
}
