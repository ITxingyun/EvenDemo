package com.xingyun.javalib.testdouble;

/**
 * @author chenyiwen2
 * date: 2020/11/19
 * desc:
 */
public class Book {
    private String bookName;
    private String type;
    private int stock;

    public Book(String bookName, String type, int stock) {
        this.bookName = bookName;
        this.type = type;
        this.stock = stock;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", type='" + type + '\'' +
                ", stock=" + stock +
                '}';
    }
}
