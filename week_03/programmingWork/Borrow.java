package Git.GitHub.NMID.week_03.programmingWork;

/**
 * #### 2. 借书类 Borrow
 * 1. 实现Runnable接口，
 * 2. 判断是否有书，有就借书，无等待.
 * 3. 结束完打印信息.
 */
public class Borrow implements Runnable {
    @Override
    public void run() {
        synchronized (Books.getObject()) {
            if (Books.getBooks() > 0) {
                Books.setBooks(Books.getBooks() - 1);
                System.out.println("借书： 借书成功，剩余书 " + Books.getBooks() + "（本）");
            }
            //无等待.
            else if (Books.getBooks() == 0) {
                try {
                    System.out.println("借书：书为 0 （本）等待还书......");
                    Books.getObject().wait();
                    if (Books.getBooks() > 0) {
                        Books.setBooks(Books.getBooks() - 1);
                        System.out.println("借书： 借书成功，剩余书 " + Books.getBooks() + "（本）");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
