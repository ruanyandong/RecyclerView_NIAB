package com.example.ai.recyclerviewimooc;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by AI on 2018/3/17.
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder{


    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel dataModel);
}
