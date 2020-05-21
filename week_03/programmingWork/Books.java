package Git.GitHub.NMID.week_03.programmingWork;

/**
 * #### 1. 书类 Books
 * 1. 储存书的数量
 * 2.注意线程安全问题，用 static 解决,
 */
public class Books {
    private static int books = 1;
    private static Books object = new Books();

    public static int getBooks() {
        return books;
    }

    public static void setBooks(int books) {
        Books.books = books;
    }

    public static Books getObject() {
        return object;
    }
}
