package com.xingyun.javalib.testdouble;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookManageSystemTest {
    private Logger logger;

    private BookDatabase bookDatabase;

    private BookManageSystem bookManageSystem;

    private LibrarianStub stubLibrarian;

    private LibrarianMock mockLibrarian;

    private LibrarianSpy spyLibrarian;

    @Before
    public void setup() {
        //dummy
        logger = new LoggerDummy();

        //fake
        bookDatabase = new FakeBookDatabase();

        //stub
        stubLibrarian = new LibrarianStub(true);

        //mock
        mockLibrarian = new LibrarianMock();

        //spy
        spyLibrarian = new LibrarianSpy();
    }

    @Test
    public void test_borrowBookByStub() {
        bookManageSystem = new BookManageSystem(logger, bookDatabase, stubLibrarian);
        Book book = bookManageSystem.borrowBook();
        assertThat(book.getBookName()).isEqualTo("三国演义");
    }

    @Test
    public void test_borrowBookByMock() {
        bookManageSystem = new BookManageSystem(logger, bookDatabase, mockLibrarian);
        Book book = bookManageSystem.borrowBook();
        mockLibrarian.expect(book);
        mockLibrarian.verify();
    }

    @Test
    public void test_borrowBookBySpy() {
        bookManageSystem = new BookManageSystem(logger, bookDatabase, spyLibrarian);
        Book book = bookManageSystem.borrowBook();
        assertThat(spyLibrarian.timesCalled()).isEqualTo(1);
        assertThat(spyLibrarian.calledWith(book)).isTrue();
    }


    @Test
    public void test_borrowBookWithMockito() {
        Logger logger = mock(Logger.class); //相当于Dummy

        Librarian librarian = mock(Librarian.class);

        //Stub
        doReturn(true).when(librarian).approve((Book) any());

        BookManageSystem bookManageSystem = new BookManageSystem(logger, bookDatabase, librarian);
        Book book = bookManageSystem.borrowBook();

        //Mock
        verify(librarian).approve(book);

        //Mock and spy
        verify(librarian, times(1)).approve(book);
    }

}