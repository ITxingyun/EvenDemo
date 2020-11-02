package com.xingyun.architecture.mvp;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MvpPresenterTest {
    private MvpContract.IView mView = mock(MvpContract.IView.class);
    private MvpContract.IModel mModel = mock(MvpContract.IModel.class);
    private MvpPresenter presenter;

    @Before
    public void setup() {
        presenter = new MvpPresenter(mView, mModel);
    }

    @Test
    public void test_loadData() {
        presenter.loadData();
        verify(mModel).fetchData();
        verify(mView).showMessage();
    }


}