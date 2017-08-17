package com.atss.getrepairnewapplication.SchedulePage;

import android.widget.LinearLayout;

/**
 * Created by DFMS1 on 05-Jan-17.
 */

public class Getrepairpojo {
    LinearLayout linearLayout;

    // ImageView imageView;

    int position;


    public Getrepairpojo(LinearLayout linearLayout, int j) {

        this.linearLayout = linearLayout;

        this.position = position;

    }


    public LinearLayout getLinearLayout() {

        return linearLayout;

    }


    public void setLinearLayout(LinearLayout linearLayout) {

        this.linearLayout = linearLayout;

    }

    public int getPosition()
    {
        return position;

    }


    public void setPosition(int position) {

        this.position = position;

    }

}
