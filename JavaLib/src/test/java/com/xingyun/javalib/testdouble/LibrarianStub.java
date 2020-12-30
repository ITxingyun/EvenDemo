package com.xingyun.javalib.testdouble;

/**
 * desc: Stub不包含逻辑，只返回指定的逻辑
 */
public class LibrarianStub implements Librarian {
    private boolean isApprove;

    public LibrarianStub(boolean isApprove) {
        this.isApprove = isApprove;
    }

    @Override
    public boolean approve(Book book) {
        return isApprove;
    }
}
