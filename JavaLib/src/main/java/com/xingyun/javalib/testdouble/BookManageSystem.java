package com.xingyun.javalib.testdouble;

/**
 * @author chenyiwen2
 * date: 2020/11/19
 * desc: 演示Test Double的demo
 */
public class BookManageSystem {
    private Logger logger;
    private BookDatabase bookDatabase;
    private Librarian librarian;

    public BookManageSystem(Logger logger, BookDatabase bookDatabase, Librarian librarian) {
        this.logger = logger;
        this.bookDatabase = bookDatabase;
        this.librarian = librarian;
    }

    public Book borrowBook() {
        //从数据库里查询书籍
        Book book = bookDatabase.selectBookByName("三国演义");
        //图书管理员审批
        boolean isApprove = librarian.approve(book);

        logger.append(book.toString());

        System.out.println("借阅书籍：" + book.getBookName() + " 是否成功： " + isApprove);

        return isApprove ? book : null;
    }

}
