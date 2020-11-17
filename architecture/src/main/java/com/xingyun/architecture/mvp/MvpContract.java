package com.xingyun.architecture.mvp;

public interface MvpContract {
    interface IView {
        void showSpanner();

        void hideSpanner();

        void showMessage(String message);
    }

    interface IPresenter {
        void loadData();
    }

    interface IModel {
        void fetchData(LoadDataCallback<String> callback);
    }
}
