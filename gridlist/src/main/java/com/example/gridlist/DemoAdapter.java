package com.example.gridlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AI on 2018/3/16.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater mLayoutInflater;

    private List<DataModel> mList=new ArrayList<>();



    public DemoAdapter(Context context) {

        mLayoutInflater=LayoutInflater.from(context);

    }

    public void addList(List<DataModel> list){
        mList.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch(viewType){
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder
                        (mLayoutInflater.inflate
                                (R.layout.item_type_one,
                                        parent,
                                        false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder
                        (mLayoutInflater.
                                inflate(R.layout.item_type_two,
                                        parent,false));

            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder
                        (mLayoutInflater.
                                inflate(R.layout.item_type_three,
                                        parent,false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((TypeAbstractViewHolder)holder).bindHolder(mList.get(position));


    }


    /**
     * 这里的type最终会回调到OnCreateViewHolder中的viewType
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
