/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package com.atss.getrepairnewapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atss.getrepairnewapplication.Activity.OrderActivity;
import com.atss.getrepairnewapplication.Activity.OrderfullActivity;
import com.atss.getrepairnewapplication.Pojoclass.DataObjectorder;
import com.atss.getrepairnewapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerVieworderAdapter extends RecyclerView.Adapter<MyRecyclerVieworderAdapter.MyViewHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<DataObjectorder> mDataset;
int pos;
    private List<DataObjectorder> orderlist;
    Context mcontext;

    public MyRecyclerVieworderAdapter(Context context, List<DataObjectorder> orderlist) {

    }

    public MyRecyclerVieworderAdapter(OrderActivity context, List<DataObjectorder> orderlist) {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder    {
        TextView tvlegendName;
        TextView legendBorn;
        TextView tvbrand;
        TextView tvprice;
        ImageView ivimage;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvlegendName = (TextView) itemView.findViewById(R.id.tvlegendName);
            legendBorn = (TextView) itemView.findViewById(R.id.legendBorn);
            tvbrand = (TextView) itemView.findViewById(R.id.tvbrand);
            tvprice = (TextView) itemView.findViewById(R.id.tvprice);
            ivimage=(ImageView)itemView.findViewById(R.id.ivimage);

            Log.i(LOG_TAG, "Adding Listener");
           // itemView.setOnClickListener(this);
        }


    }



//    public MyRecyclerVieworderAdapter(ArrayList<DataObjectorder> myDataset) {
//        mDataset = myDataset;
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layoutorder, parent, false);
        return new MyViewHolder(view);
//        MyViewHolder dataObjectHolder = new MyViewHolder(view);
//        return dataObjectHolder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvlegendName.setText(orderlist.get(position).getTvlegendName());
        holder.legendBorn.setText(orderlist.get(position).getLegendBorn());
        holder.tvbrand.setText(orderlist.get(position).getTvbrand());
        holder.tvprice.setText(orderlist.get(position).getTvprice());
        holder.ivimage.setImageResource(orderlist.get(position).getIvimage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v){

                                                           Context context = v.getContext();
                                                           Intent intent = new Intent(context, OrderfullActivity.class);
                                                           context.startActivity(intent);

                                                   }
                                               }
        );
     //  holder.ivimage.setImageResource(Integer.parseInt(String.valueOf(orderlist.get(position).getIvimage())));
    }



    @Override
    public int getItemCount() {
        return orderlist.size();
    }


}