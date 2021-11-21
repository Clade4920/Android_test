package com.example.test_listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
//    TextView textView;
    ListView listView;
    Button btn_delete;
    List<MusicListArray> musics = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        init_ListView();
    }

    private void init_ListView(){
        //获取
//        textView = (TextView) findViewById(R.id.music);
        listView = (ListView) findViewById(R.id.musicView);

        //添加数据
        add_data();

        //创建适配器--自定义适配器
        MusicAdapt adapter = new MusicAdapt(this,R.layout.music_option,musics);
        listView.setAdapter(adapter);

        //删除按钮
        btn_delete = (Button) findViewById(R.id.btn_delete);
        //删除按钮的监视器
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //删除被选中的项
                for(int i=musics.size()-1;i>=0;i--){
                    if(adapter.getItem(i).isCheck()){
                        adapter.remove(adapter.getItem(i));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });


        //创建监听器
        AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //显示AlertDialog提示
                showNormalDialog(i);

//                String msg = "父 View:" + adapterView.toString() + "\n" +
//                        "子 View:" + view.toString() + "\n" +
//                        "位置:" + String.valueOf(i) +
//                        ",ID:" + String.valueOf(l);
//                textView.setText(msg);
            }
        };
        listView.setOnItemClickListener(listViewListener);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////
////                MusicListArray temp = adapter.getItem(i);
////                //选中
////                CheckBox checkBox = (CheckBox)view.getTag();
////                if(checkBox.isChecked()){
////                    temp.setCheck(true);
////                }else {
////                    temp.setCheck(false);
////                }
//
//                //显示AlertDialog提示
//                showNormalDialog(i);
//            }
//        });
    }

    public void add_data(){
        MusicListArray one = new MusicListArray(R.drawable.spongeswap, "Rpongeswap","Nick Nitro");
        musics.add(one);
        MusicListArray two = new MusicListArray(R.drawable.doonderful, "Doonderful!","Namco Sound Team");
        musics.add(two);
        MusicListArray three = new MusicListArray(R.drawable.roundtable_rival, "Roundtable Rival","Lindsey Stirling");
        musics.add(three);
        MusicListArray four = new MusicListArray(R.drawable.samurai_45, "Samurai 45","MIYAVI");
        musics.add(four);
        MusicListArray five = new MusicListArray(R.drawable.drown, "Drown","milet");
        musics.add(five);
    }

    private void showNormalDialog(int i){
        //创建dialog构造器
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        //设置title
        normalDialog.setTitle(musics.get(i).getName());
//        //设置icon
//        normalDialog.setIcon();
        //设置内容
        normalDialog.setMessage("正在播放该歌曲");
        //设置按钮
        normalDialog.setPositiveButton("确定"
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        //创建并显示
        normalDialog.create().show();
    }
}