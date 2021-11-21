package com.example.test_listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapt extends ArrayAdapter<MusicListArray> {
    private int resourceId;
    private CheckBox checkBox;

    public MusicAdapt(Context context, int resourceId, List<MusicListArray> musicListArrays) {
        super(context, resourceId, musicListArrays);
        this.resourceId = resourceId;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        MusicListArray musicList = getItem(position);
        LinearLayout music_list_item = new LinearLayout(getContext());

        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
        convertView =  vi.inflate(resourceId, music_list_item, true);

//        RecyclerView.ViewHolder viewHolder;
//        viewHolder = (RecyclerView.ViewHolder)convertView.getTag();
//
//        ViewHolder viewHolder = new ViewHolder();
        checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
//        viewHolder.checkBox = (CheckBox) ;
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(musicList.isCheck()){
                    musicList.setCheck(false);
                }else {
                    musicList.setCheck(true);
                }
            }
        });



//        this.checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);

        //填充数据
        ImageView image = (ImageView) music_list_item.findViewById(R.id.music_image);
        TextView name = (TextView) music_list_item.findViewById(R.id.music_name);
        TextView info = (TextView) music_list_item.findViewById(R.id.music_info);
        CheckBox check = (CheckBox) music_list_item.findViewById(R.id.checkbox);
        image.setImageResource(musicList.getImageId());
        name.setText(musicList.getName());
        info.setText(musicList.getIfo());
        check.setChecked(musicList.isCheck());
        return music_list_item;
    }

//    private class ViewHolder{
//        CheckBox checkBox;
//    }
}
