package com.xingyun.architecture.mvp;

/**
 * @author evenChen
 * date: 2020/10/15
 * desc:
 */
public class MvpPresenter implements MvpContract.IPresenter {
    private MvpContract.IView mView;
    private MvpContract.IModel mModel;

    public MvpPresenter(MvpContract.IView mView, MvpContract.IModel model) {
        this.mView = mView;
        this.mModel = model;
    }

    @Override
    public void loadData() {
        mModel.fetchData();
        mView.showMessage();
    }
}
