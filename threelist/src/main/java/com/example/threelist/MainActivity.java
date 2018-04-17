package com.example.threelist;

import android.Manifest;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
         * 一行有两列
         */
        final GridLayoutManager gridLayoutManager=
                new GridLayoutManager(this,2);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            /**
             * 横跨度是多少
             * @param position
             * @return
             */
            @Override
            public int getSpanSize(int position) {

                int type=mRecyclerView.getAdapter().getItemViewType(position);

                if(type==mAdapter.TYPE_THREE){
                    return gridLayoutManager.getSpanCount();
                }else{
                    return 1;
                }

            }
        });

        mRecyclerView.setLayoutManager(gridLayoutManager);


        mAdapter=new DemoAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        /**
         * 设置item间距
         */
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams=(GridLayoutManager.LayoutParams)view.getLayoutParams();

                /**
                 * 每行有几列
                 */
                int spanSize=layoutParams.getSpanSize();
                /**
                 * 一行有几列，每一列的下标
                 */
                int spanIndex=layoutParams.getSpanIndex();

                /**
                 * 距离顶部的距离
                 */
                outRect.top=20;

                if(spanSize!=gridLayoutManager.getSpanCount()){
                    if(spanIndex==1){
                        outRect.left=10;
                    }else{
                        outRect.right=10;
                    }
                }


            }
        });


        initData();//ALT+回车
    }

    private void initData() {

        List<DataModelOne> list1=new ArrayList<>();
        for(int i=0;i<30;i++){
            DataModelOne dataModel=new DataModelOne();
            dataModel.avatarColor=colors[0];
            dataModel.name="name:"+1;
            list1.add(dataModel);
        }


        List<DataModelTwo> list2=new ArrayList<>();
        for(int i=0;i<30;i++){
            DataModelTwo dataModel=new DataModelTwo();
            dataModel.avatarColor=colors[1];
            dataModel.name="name:"+1;
            dataModel.content="content";
            list2.add(dataModel);
        }

        List<DataModelThree> list3=new ArrayList<>();
        for(int i=0;i<30;i++){
            DataModelThree dataModel=new DataModelThree();
            dataModel.avatarColor=colors[2];
            dataModel.name="name:"+1;
            dataModel.content="content";
            dataModel.contentColor=colors[2];
            list3.add(dataModel);
        }


        mAdapter.addList(list1,list2,list3);
        /**
         * 数据更新
         */
        mAdapter.notifyDataSetChanged();
    }
}
