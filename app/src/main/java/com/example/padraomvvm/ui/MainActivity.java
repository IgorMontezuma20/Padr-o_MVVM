package com.example.padraomvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.padraomvvm.R;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    // Padrão MVVM
    // É necessário fazer a conexão "Binding" - "ViewModel"

    // 6 - Conectando a MainActivity com a ViewModel e dando um listening no Live Data

    AppViewModel appViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MVVM
        // 1 - Implementando a dependência da ViewModel
        // 2 - Criando a classe ViewModel


        startComponents();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appViewModel.getAppName();

            }
        });

        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        // 7 - Listening & observing the changes to Live Data
        appViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //Qualquer mudança no Live Data faz isso:
                textView.setText(s);

            }
        });
    }



    public void startComponents(){
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }
}