package com.example.ai.recyclerviewimooc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by AI on 2018/3/17.
 */

public class TypeOneViewHolder extends TypeTwoViewHolder{

    public ImageView avatar;

    public TextView name;




    public TypeOneViewHolder(View itemView) {
        super(itemView);

        avatar=(ImageView)itemView.findViewById(R.id.avatar);
        name=(TextView)itemView.findViewById(R.id.name);

    }

    /**
     * 不可以使用setBackGroundColor，无法显示出来
     * @param model
     */
    @Override
    public void bindHolder(DataModel model){
        avatar.setBackgroundResource(model.avatarColor);

        name.setText(model.name);
    }

}
