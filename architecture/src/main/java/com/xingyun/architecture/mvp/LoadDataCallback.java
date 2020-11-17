package com.xingyun.architecture.mvp;

public interface LoadDataCallback<T> {
    void onSuccess(T data);

    void onError(int error, String message);
}
