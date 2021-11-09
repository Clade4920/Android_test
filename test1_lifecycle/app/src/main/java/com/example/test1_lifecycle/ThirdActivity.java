package com.example.test1_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {
    private  static String TAG = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.i(TAG,"(1)onCreate(3)");
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG,"(2)onStart(3)");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"(3)onRestoreInstanceState(3)");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG,"(4)onResume(3)");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"(5)onSaveInstanceState(3)");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.i(TAG,"(6)onRestart(3)");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG,"(7)onPause(3)");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG,"(8)onStop(3)");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"(9)onDestroy(3)");
    }
}