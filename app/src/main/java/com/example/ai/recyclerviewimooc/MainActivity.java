package com.example.ai.recyclerviewimooc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private DemoAdapter mAdapter;

    int colors[]={
            android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview);

        /**
         * 第三个参数是是否反转，true为反转，新数据在顶部；false为不反转，新数据在底部
         */
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));

        mAdapter=new DemoAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        initData();//ALT+回车
    }

    private void initData() {

        List<DataModel> list=new ArrayList<>();

        for(int i=0;i<20;i++){
            int type=(int)(Math.random()*3+1);

            DataModel dataModel=new DataModel();

            dataModel.avatarColor=colors[type-1];

            dataModel.type=type;

            dataModel.name="name:"+1;

            dataModel.content="content:"+i;

            dataModel.contentColor=colors[(type+1)%3];

            list.add(dataModel);


        }

        mAdapter.addList(list);

        /**
         * 数据更新
         */
        mAdapter.notifyDataSetChanged();
    }
}
