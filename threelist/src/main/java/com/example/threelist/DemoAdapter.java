package com.example.threelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AI on 2018/3/16.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int TYPE_ONE=1;

    public static final int TYPE_TWO=2;

    public static final int TYPE_THREE=3;


    private LayoutInflater mLayoutInflater;



    public DemoAdapter(Context context) {

        mLayoutInflater=LayoutInflater.from(context);

    }

    private List<DataModelOne> list1;

    private List<DataModelTwo> list2;

    private List<DataModelThree> list3;


    private List<Integer> types=new ArrayList<>();

    private Map<Integer,Integer> mPositions=new HashMap<>();


    public void addList(List<DataModelOne> list1,
                        List<DataModelTwo> list2,
                        List<DataModelThree> list3){

        addListByType(TYPE_ONE,list1);

        addListByType(TYPE_TWO,list2);

        addListByType(TYPE_THREE,list3);


        this.list1=list1;
        this.list2=list2;
        this.list3=list3;

    }

    private void addListByType(int type,List list){

        /**
         * types.size()的值变化为0====>30====>60
         */
        mPositions.put(type,types.size());

        Log.d("types", "addListByType:====> "+types.size());

        for (int i=0;i<list.size();i++){
            types.add(type);
        }
        Log.d("types=======>", "addListByType: "+types.size());

        /**
         * types最终的值为90
         */


    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch(viewType){
            case TYPE_ONE:
                return new TypeOneViewHolder
                        (mLayoutInflater.inflate
                                (R.layout.item_type_one,
                                        parent,
                                        false));
            case TYPE_TWO:
                return new TypeTwoViewHolder
                        (mLayoutInflater.
                                inflate(R.layout.item_type_two,
                                        parent,false));

            case TYPE_THREE:
                return new TypeThreeViewHolder
                        (mLayoutInflater.
                                inflate(R.layout.item_type_three,
                                        parent,false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

       int viewType=getItemViewType(position);
       int realPosition=position-mPositions.get(viewType);

        switch(viewType){
            case TYPE_ONE:
                ((TypeOneViewHolder)holder).bindHolder(list1.get(realPosition));
                break;

            case TYPE_TWO:
                ((TypeTwoViewHolder)holder).bindHolder(list2.get(realPosition));
                break;

            case TYPE_THREE:
                ((TypeThreeViewHolder)holder).bindHolder(list3.get(realPosition));
                break;
        }

    }


    /**
     * 这里的type最终会回调到OnCreateViewHolder中的viewType
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
