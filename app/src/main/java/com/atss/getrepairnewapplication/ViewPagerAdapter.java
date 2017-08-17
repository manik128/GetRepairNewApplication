package com.atss.getrepairnewapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by system1 on 7/28/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {
    Context c;
    ImageView indicator1,indicator2,indicator3, indicator4 , indicator5;
int size;
LayoutInflater layoutInflater;
    public ViewPagerAdapter(Context c) {
        this.c = c;
        /*this.indicator1 = indicator1;
        this.indicator2 = indicator2;
        this.indicator3 = indicator3;
        this.indicator4 = indicator4;
        this.indicator5 = indicator5;
        size = noofsize;*/
    }

    @Override
    public int getCount() {
        return 3 ;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View itemview=layoutInflater.inflate(R.layout.viewitem,container,false);
        ImageView image=(ImageView)itemview.findViewById(R.id.image4);
        int pagenumbertxt=position+1;
        try {
            if (pagenumbertxt ==1){
                image.setImageResource(R.drawable.homebc);
            }else if (pagenumbertxt ==2){
                image.setImageResource(R.drawable.homeac);

            }else if (pagenumbertxt ==3) {
                image.setImageResource(R.drawable.homecar);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ((ViewPager)container).addView(itemview);
        return itemview ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

}