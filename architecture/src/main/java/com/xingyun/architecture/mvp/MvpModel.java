package com.xingyun.architecture.mvp;

import com.xingyun.architecture.data.DataRepository;

/**
 * @author chenyiwen2
 * date: 2020/10/15
 * desc:
 */
public class MvpModel implements MvpContract.IModel {
    private DataRepository dataRepository;

    public MvpModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void fetchData(LoadDataCallback<String> callback) {
        dataRepository.loadArticles(123, false);
    }
}
