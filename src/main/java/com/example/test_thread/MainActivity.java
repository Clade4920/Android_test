package com.example.test_thread;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test_thread.service.TimeService;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private TimeService timeService;
    private static Handler handler = new Handler();
    private static TextView time;
    private static int now_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //服务
        final Intent serviceIntent = new Intent(this, TimeService.class);
        //启动服务
        startService(serviceIntent);
        //绑定
        bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE);


        time = (TextView)findViewById(R.id.time);
        Button fast_button = (Button) findViewById(R.id.fast);
        Button pause_button = (Button) findViewById(R.id.pause);
        fast_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeService.add_ten();
            }
        });
        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeService.onDestroy();
                stopService(serviceIntent);
            }
        });

    }

    public static void UpdateGUI(int refreshnumber){
            now_number = refreshnumber;
            handler.post(RefreshLable);
    }

    public static Runnable RefreshLable = new Runnable() {
        @Override
        public void run() {
            time.setText(String.valueOf(now_number));
        }
    };

    public ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            timeService = ((TimeService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            timeService = null;
        }
    };
}