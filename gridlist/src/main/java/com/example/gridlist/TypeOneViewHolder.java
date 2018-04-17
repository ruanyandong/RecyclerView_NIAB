package com.example.gridlist;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        itemView.setBackgroundColor(Color.BLACK);

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
