package com.xingyun.javalib.testdouble;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyiwen2
 * date: 2020/11/19
 * desc:
 */
public class FakeBookDatabase implements BookDatabase {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("三国演义", "小说", 2));
    }

    @Override
    public Book selectBookByName(String bookName) {
        if ("三国演义".equals(bookName)) return books.get(0);
        return null;
    }

    @Override
    public List<Book> selectBookByType(String type) {
        return null;
    }
}
