package com.example.test1_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private  static String TAG = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(TAG,"(1)onCreate(2)");

//        打开第三个界面
        Button btn_third_activity = (Button) findViewById(R.id.open_third_activity);
        btn_third_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG,"(2)onStart(2)");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"(3)onRestoreInstanceState(2)");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG,"(4)onResume(2)");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"(5)onSaveInstanceState(2)");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.i(TAG,"(6)onRestart(2)");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG,"(7)onPause(2)");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG,"(8)onStop(2)");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"(9)onDestroy(2)");
    }

}