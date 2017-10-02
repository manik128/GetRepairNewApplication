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
public class ViewPagerAdapter extends PagerAdapter {
    Context c;
    ImageView indicator1,indicator2,indicator3, indicator4 , indicator5;
int size;
    String[] images;
    ImageLoader imageLoader;
LayoutInflater layoutInflater;
    public ViewPagerAdapter(Context c, String[] images) {
        this.c = c;
        this.images=images;
        this.imageLoader=imageLoader;
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
        //imageLoader.displayImage(images[position],image);

        Picasso.with(c).load(images[position]).into(image);
        container.addView(itemview);
        return itemview;

//        int pagenumbertxt=position+1;
//        try {
//            if (pagenumbertxt ==1){
//                image.setImageResource(R.drawable.homebc);
//            }else if (pagenumbertxt ==2){
//                image.setImageResource(R.drawable.homeac);
//
//            }else if (pagenumbertxt ==3) {
//                image.setImageResource(R.drawable.homecar);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        ((ViewPager)container).addView(itemview);
//        return itemview ;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

}
