package com.example.padraomvvm.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.padraomvvm.util.MyModel;

public class AppViewModel extends ViewModel {

    // 4 - Live Data
    LiveData liveData;
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    // 3 - Conectando a ViewModel com o DB ou API (Model)

    private MyModel getAppFromDatabase(){

        //Live Data vs MutableLiveData
        //Mutable: O Mutable pode dar um post e um set no live data

        return  new MyModel("Padrão MVVM", 90000, 4);
    }

    // 5 - Conectando a ViewModel com a MainActivity (VIEW)
    public void getAppName(){
        String appName = getAppFromDatabase().getAppName();
        mutableLiveData.setValue(appName);
    }

}
