package com.atss.getrepairnewapplication.Pojoclass;

import android.widget.LinearLayout;

/**
 * Created by system1 on 8/4/2016.
 */
public class RepairPojoClass {
    LinearLayout linearLayout;
    int position;

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public RepairPojoClass(LinearLayout linearLayout, int position) {

        this.linearLayout = linearLayout;
        this.position = position;
    }
}
