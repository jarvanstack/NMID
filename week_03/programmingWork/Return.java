package Git.GitHub.NMID.week_03.programmingWork;

/**
 * #### 3.还书类 Return
 * 1. 实现 Runnable 接口
 * 2. 判断是否书为零，如果为0就还书并解除 等待.
 * 3. 不满书就，还书并打印信息.
 * 4. 判断是否满书，满书退出程序
 */
public class Return implements Runnable {

    @Override
    public void run() {
        synchronized (Books.getObject()) {
            // * 2. 判断是否书为零，如果为0就还书并解除 等待.
            if (Books.getBooks() == 0) {
                Books.setBooks(Books.getBooks() + 1);
                System.out.println("还书： 还书成功,剩余书：" + Books.getBooks() + "（本）");
                Books.getObject().notifyAll();

            }
            // * 3. 不满书就，还书并打印信息.
            else if (Books.getBooks() > 0 && Books.getBooks() < 3) {
                Books.setBooks(Books.getBooks() + 1);
                System.out.println("还书： 还书成功,剩余书：" + Books.getBooks() + "（本）");
            }
            // * 4. 判断是否满书，满书退出程序
            else if (Books.getBooks() >= 3) {
                System.out.println("图书馆的书已经满了,图书馆爆炸，程序结束..Bye...");
                System.exit(0);
            }
        }
    }
}
