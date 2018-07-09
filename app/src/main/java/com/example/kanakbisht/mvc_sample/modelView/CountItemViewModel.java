package com.example.kanakbisht.mvc_sample.modelView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.kanakbisht.mvc_sample.data.Count;

public class CountItemViewModel extends ViewModel {

    private MutableLiveData<Integer> countViewModel;

    public CountItemViewModel(){
        countViewModel=new MutableLiveData<>();
        countViewModel.setValue(0);

    }

    public void addCount(int count){
        countViewModel.setValue(countViewModel.getValue()+1);
    }

    public void reset(int count ){
        countViewModel.setValue(0);
    }
    public LiveData<Integer> getCountUpdated(){
        return countViewModel;
    }
}
