package com.xingyun.architecture.mvp;

public interface MvpContract {
    interface IView {
        void showMessage();
    }

    interface IPresenter {
        void loadData();
    }

    interface IModel {
        void fetchData();
    }
}
