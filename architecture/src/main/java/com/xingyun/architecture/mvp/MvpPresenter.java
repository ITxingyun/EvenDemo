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
        mView.showSpanner();
        mModel.fetchData(new LoadDataCallback<String>() {
            @Override
            public void onSuccess(String data) {
                mView.showMessage(data);
                mView.hideSpanner();
            }

            @Override
            public void onError(int error, String message) {
                mView.showMessage(error + message);
                mView.hideSpanner();
            }
        });
    }
}
