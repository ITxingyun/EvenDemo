package com.xingyun.architecture.mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class MvpPresenterTest {
    @Mock
    private MvpContract.IView mView;

    @Mock
    private MvpContract.IModel mModel;

    @Captor
    private ArgumentCaptor<LoadDataCallback<String>> loadDataCallbackCaptor;

    private MvpPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new MvpPresenter(mView, mModel);
    }

    @Test
    public void test_loadData_success() {
        presenter.loadData();
        verify(mView).showSpanner();
        verify(mModel).fetchData(loadDataCallbackCaptor.capture());
        loadDataCallbackCaptor.getValue().onSuccess("success");
        verify(mView).showMessage("success");
        verify(mView).hideSpanner();
    }

    @Test
    public void test_loadData_error() {
        presenter.loadData();
        verify(mView).showSpanner();
        verify(mModel).fetchData(loadDataCallbackCaptor.capture());
        loadDataCallbackCaptor.getValue().onError(-1, "error");
        verify(mView).showMessage("-1error");
        verify(mView).hideSpanner();
    }

}