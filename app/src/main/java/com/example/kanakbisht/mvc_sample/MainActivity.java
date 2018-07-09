package com.example.kanakbisht.mvc_sample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kanakbisht.mvc_sample.modelView.CountItemViewModel;

public class MainActivity extends AppCompatActivity {
    Button myButton,myButtonReset;
    TextView txtView;
    int count;
    private CountItemViewModel countItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton=findViewById(R.id.button);
        myButtonReset=findViewById(R.id.buttonReset);

        txtView=findViewById(R.id.txt);
        count=0;
        txtView.setText(Integer.toString(count));

        countItemViewModel = ViewModelProviders.of(this).get(CountItemViewModel.class);
        countItemViewModel.getCountUpdated().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer newCount) {
                txtView.setText(newCount.toString());

            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                countItemViewModel.addCount(count);
                //LiveData<Integer> countUpdate=countItemViewModel.getCountUpdated();
                //txtView.setText(countUpdate.toString());

            }
        });

        myButtonReset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                countItemViewModel.reset(count);
            }
        });



    }





}
