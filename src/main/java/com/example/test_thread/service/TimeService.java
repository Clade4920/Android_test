package com.example.test_thread.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.test_thread.MainActivity;

public class TimeService extends Service {

    private final IBinder mBinder = new LocalBinder();
    private Thread timeThread;
    private int number = 0;
    private int ten = 0;

    public class LocalBinder extends Binder{
        public TimeService getService(){
            return TimeService.this;
        }
    }

    public void add_ten(){
        ten += 10;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent){
        return false;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        timeThread = new Thread(null,backgroundTime,"TimeThread");
    }
    
    @Override
    public void onStart(Intent intent, int startId){
        super.onStart(intent,startId);
        if(!timeThread.isAlive()){
            timeThread.start();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        timeThread.interrupt();
    }

    private final Runnable backgroundTime = new Runnable() {
        @Override
        public void run() {
            //秒表
            try {
                while (!Thread.interrupted()){
                    MainActivity.UpdateGUI(number+ten);
                    number+=1;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
