package com.xingyun.javalib.testdouble;

import java.util.List;

public interface BookDatabase {
    Book selectBookByName(String bookName);

    List<Book> selectBookByType(String type);
}
