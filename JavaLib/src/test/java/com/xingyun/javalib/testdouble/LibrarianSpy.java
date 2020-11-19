package com.xingyun.javalib.testdouble;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyiwen2
 * date: 2020/11/19
 * desc: Spy用来跟踪一些信息，例如方法被调用的次数
 */
public class LibrarianSpy implements Librarian {
    private List<Book> bookApproved = new ArrayList<>();

    @Override
    public boolean approve(Book book) {
        bookApproved.add(book);
        return true;
    }

    public int timesCalled() {
        return bookApproved.size();
    }

    public boolean calledWith(Book book) {
        return bookApproved.contains(book);
    }
}
