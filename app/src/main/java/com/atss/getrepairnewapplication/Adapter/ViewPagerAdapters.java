package com.atss.getrepairnewapplication.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.atss.getrepairnewapplication.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

/**
 * Created by system1 on 7/28/2016.
 */
public class ViewPagerAdapters extends PagerAdapter {
    Context c;
    ImageView indicator1,indicator2,indicator3, indicator4 , indicator5;
    int size;
    int imag1,img2;
    String[] images;
    ImageLoader imageLoader;
    LayoutInflater layoutInflater;
    public ViewPagerAdapters(Context c,String[] images) {
        this.c = c;
        this.images=images;
//        imag1=a;
//        img2=b;
        /*this.indicator1 = indicator1;
        this.indicator2 = indicator2;
        this.indicator3 = indicator3;
        this.indicator4 = indicator4;
        this.indicator5 = indicator5;
        size = noofsize;*/
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View itemview=layoutInflater.inflate(R.layout.viewitem,container,false);
        ImageView image=(ImageView)itemview.findViewById(R.id.image4);
        Picasso.with(c).load(images[position]).into(image);
        container.addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

}
