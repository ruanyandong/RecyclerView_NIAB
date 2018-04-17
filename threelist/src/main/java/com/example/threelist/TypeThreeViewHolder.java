package com.example.threelist;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AI on 2018/3/17.
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder<DataModelThree> {

    public ImageView avatar;

    public TextView name;

    public TextView content;

    public ImageView contentImage;


    public TypeThreeViewHolder(View itemView) {
        super(itemView);

        avatar = (ImageView) itemView.findViewById(R.id.avatar);

        contentImage=(ImageView)itemView.findViewById(R.id.contentImage);

        name = (TextView) itemView.findViewById(R.id.name);

        content=(TextView)itemView.findViewById(R.id.content);

        itemView.setBackgroundColor(Color.GREEN);




    }

    /**
     * 不可以使用setBackGroundColor，无法显示出来
     * @param model
     */

    @Override
    public void bindHolder(DataModelThree model) {
        avatar.setBackgroundResource(model.avatarColor);

        name.setText(model.name);

        content.setText(model.content);

        contentImage.setBackgroundResource(model.contentColor);
    }
}