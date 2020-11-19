package com.xingyun.javalib.testdouble;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * @author chenyiwen2
 * date: 2020/11/19
 * desc: Mock用来跟踪方法调用，根据方法是否被正确的调用来判断测试是否通过
 */
public class LibrarianMock implements Librarian {
    private List<Book> bookApproved = new ArrayList<>();
    private List<Book> expectBook = new ArrayList<>();


    @Override
    public boolean approve(Book book) {
        bookApproved.add(book);
        return true;
    }

    public void expect(Book book) {
        expectBook.add(book);
    }

    /**
     * 验证方法approve是否被调用
     */
    public void verify() {
        assertThat(bookApproved).isEqualTo(expectBook);
    }
}
