package com.atss.getrepairnewapplication.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.R;
import com.atss.getrepairnewapplication.SchedulePage.Getrepairpojo;
import com.atss.getrepairnewapplication.ServicingActivity;
import com.atss.getrepairnewapplication.grfont;


/**
 * Created by DFMS1 on 05-Jan-17.
 */

@SuppressLint("ValidFragment")
public  class MaleFragment extends Fragment {
    LinearLayout linearbike;
    int j;
    String[] models={"Shave","Hair cut","Streaking Crown Area","Streaking Global","Waxing Chest","Beard Trim","Beard Coloring","Others"};
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    int count,count1;
    Context con;
    String[]cons={"schedule  appointment  in salon","Book  appointment in home"};
    View v2;
    Mainclass mclass;
    View view1, view2;
    @SuppressLint("ValidFragment")
    public MaleFragment(Context cont){
     con=cont;
    }
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.bikefragment,null);
        linearbike=(LinearLayout)view.findViewById(R.id.linearbike);
        mclass=(Mainclass)getActivity().getApplicationContext();
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        for( j=0;j<models.length;j++) {
            Getrepairpojo pojo = new Getrepairpojo(new LinearLayout(getContext()), j);
            pojo.getLinearLayout().setOrientation(LinearLayout.VERTICAL);
            pojo.getLinearLayout().setPadding(10, 10, 10, 10);
            params1.setMargins(4, 0, 4, 0);
            pojo.setPosition(j);
            pojo.getLinearLayout().setLayoutParams(params1);
            pojo.getLinearLayout().setClickable(true);
            final TextView tvproduct=new TextView(getContext());
            tvproduct.setText(models[j]);
            grfont gr = new grfont(getContext());
            gr.grfonttxt(tvproduct);
            tvproduct.setPadding(20, 5, 20, 5);
            pojo.getLinearLayout().addView(tvproduct);
            final int position =pojo.getPosition();

            pojo.getLinearLayout().setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    changeView(position);
                }
                private void changeView(final int position) {
                    if (position == 0) {
                        builder = new AlertDialog.Builder(getContext());

                        View vw = null, vw2;
                        builder = new AlertDialog.Builder(getContext());
                        vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                        LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                        final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);
                        for (int i = 0; i < 2; i++) {
                            vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                            final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                            gr.grfonttxt(tvrepair);
                            tvrepair.setText(cons[i]);
                            insertPoint.addView(vw);
                            final View finalVw = vw;
                            finalVw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //View v3 = finalVw;
                                    if (v2 != null) {
                                        //
                                        mclass.setService(tvrepair.getText().toString());
                                        final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                        tv2.setTextColor(Color.parseColor("#737272"));
                                        final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                        iv3.setImageResource(R.drawable.checkbox);
                                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                    }
                                    //if (count ==1) {
                                    //ivlist.setImageResource(R.drawable.checkbox2);
                                    mclass.setService(tvrepair.getText().toString());
                                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                    final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                    final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                    iv3.setImageResource(R.drawable.checkbox2);
                                    tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                    v2 = v;
                                    //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);


                                    //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                }
                            });
//
                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if ( v2==null )
                                    {
                                        Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                        // new RegisterAsyntaskNew().execute();
                                    }else {

                                        Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        mclass.setType("Male");
                                        mclass.setModel(tvproduct.getText().toString());

                                        intent.putExtra("service", tvproduct.getText().toString());

                                        startActivity(intent);
                                    }
                                }

                            });
                        }
                        builder.setView(vw2);

                        alertDialog = builder.create();
                        alertDialog.show();

                    }else if(position==1){
                        builder = new AlertDialog.Builder(getContext());

                        View vw = null, vw2;
                        builder = new AlertDialog.Builder(getContext());
                        vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                        LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                        final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);
                        for (int i = 0; i < 2; i++) {
                            vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                            final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                            gr.grfonttxt(tvrepair);
                            tvrepair.setText(cons[i]);
                            insertPoint.addView(vw);
                            final View finalVw = vw;
                            finalVw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //View v3 = finalVw;
                                    if (v2 != null) {
                                        //
                                        mclass.setService(tvrepair.getText().toString());
                                        final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                        tv2.setTextColor(Color.parseColor("#737272"));
                                        final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                        iv3.setImageResource(R.drawable.checkbox);
                                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                    }
                                    //if (count ==1) {
                                    //ivlist.setImageResource(R.drawable.checkbox2);
                                    mclass.setService(tvrepair.getText().toString());
                                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                    final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                    final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                    iv3.setImageResource(R.drawable.checkbox2);
                                    tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                    v2 = v;
                                    //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);


                                    //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                }
                            });
//
                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if ( v2==null )
                                    {
                                        Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                        // new RegisterAsyntaskNew().execute();
                                    }else {

                                        Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                        // intent.putExtra("message", tvtheatre.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        mclass.setType("Male");
                                        mclass.setModel(tvproduct.getText().toString());

                                        intent.putExtra("service", tvproduct.getText().toString());
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        startActivity(intent);
                                    }
                                }

                            });
                        }
                        builder.setView(vw2);

                        alertDialog = builder.create();
                        alertDialog.show();
                    }else if(position==2){
                        builder = new AlertDialog.Builder(getContext());

                        View vw = null, vw2;
                        builder = new AlertDialog.Builder(getContext());
                        vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                        LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                        final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);
                        for (int i = 0; i < 2; i++) {
                            vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                            final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                            gr.grfonttxt(tvrepair);
                            tvrepair.setText(cons[i]);
                            insertPoint.addView(vw);
                            final View finalVw = vw;
                            finalVw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //View v3 = finalVw;
                                    if (v2 != null) {
                                        //
                                        mclass.setService(tvrepair.getText().toString());
                                        final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                        tv2.setTextColor(Color.parseColor("#737272"));
                                        final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                        iv3.setImageResource(R.drawable.checkbox);
                                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                    }
                                    //if (count ==1) {
                                    //ivlist.setImageResource(R.drawable.checkbox2);
                                    mclass.setService(tvrepair.getText().toString());
                                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                    final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                    final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                    iv3.setImageResource(R.drawable.checkbox2);
                                    tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                    v2 = v;
                                    //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);

                                    //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                }
                            });
//
                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if ( v2==null )
                                    {
                                        Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                        // new RegisterAsyntaskNew().execute();
                                    }else {

                                        Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                        // intent.putExtra("message", tvtheatre.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        mclass.setType("Male");
                                        mclass.setModel(tvproduct.getText().toString());

                                        intent.putExtra("service", tvproduct.getText().toString());
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        startActivity(intent);
                                    }
                                }

                            });

                        }
                        builder.setView(vw2);

                        alertDialog = builder.create();
                        alertDialog.show();
                    }else if(position==3){
                        builder = new AlertDialog.Builder(getContext());

                        View vw = null, vw2;
                        builder = new AlertDialog.Builder(getContext());
                        vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                        LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                        final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);
                        for (int i = 0; i < 2; i++) {
                            vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                            final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                            gr.grfonttxt(tvrepair);
                            tvrepair.setText(cons[i]);
                            insertPoint.addView(vw);
                            final View finalVw = vw;
                            finalVw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //View v3 = finalVw;
                                    if (v2 != null) {
                                        //
                                        mclass.setService(tvrepair.getText().toString());
                                        final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                        tv2.setTextColor(Color.parseColor("#737272"));
                                        final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                        iv3.setImageResource(R.drawable.checkbox);
                                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                    }
                                    //if (count ==1) {
                                    //ivlist.setImageResource(R.drawable.checkbox2);
                                    mclass.setService(tvrepair.getText().toString());
                                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                    final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                    final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                    iv3.setImageResource(R.drawable.checkbox2);
                                    tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                    v2 = v;
                                    //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);


                                    //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                }
                            });
//
                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if ( v2==null )
                                    {
                                        Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                        // new RegisterAsyntaskNew().execute();
                                    }else {

                                        Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                        // intent.putExtra("message", tvtheatre.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        mclass.setType("Male");
                                        mclass.setModel(tvproduct.getText().toString());


                                        intent.putExtra("service", tvproduct.getText().toString());
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        startActivity(intent);
                                    }
                                }

                            });
                        }
                        builder.setView(vw2);

                        alertDialog = builder.create();
                        alertDialog.show();
                    }else if(position==4){
                        builder = new AlertDialog.Builder(getContext());

                        View vw = null, vw2;
                        builder = new AlertDialog.Builder(getContext());
                        vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                        LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                        final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);
                        for (int i = 0; i < 2; i++) {
                            vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                            final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                            gr.grfonttxt(tvrepair);
                            tvrepair.setText(cons[i]);
                            insertPoint.addView(vw);
                            final View finalVw = vw;
                            finalVw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //View v3 = finalVw;
                                    if (v2 != null) {
                                        //
                                        mclass.setService(tvrepair.getText().toString());
                                        final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                        tv2.setTextColor(Color.parseColor("#737272"));
                                        final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                        iv3.setImageResource(R.drawable.checkbox);
                                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                    }
                                    //if (count ==1) {
                                    //ivlist.setImageResource(R.drawable.checkbox2);
                                    mclass.setService(tvrepair.getText().toString());
                                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                    final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                    final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                    iv3.setImageResource(R.drawable.checkbox2);
                                    tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                    v2 = v;
                                    //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);


                                    //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                }
                            });
//
                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if ( v2==null )
                                    {
                                        Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                        // new RegisterAsyntaskNew().execute();
                                    }else {

                                        Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                        // intent.putExtra("message", tvtheatre.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        mclass.setType("Male");
                                        mclass.setModel(tvproduct.getText().toString());

                                        intent.putExtra("service", tvproduct.getText().toString());
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        startActivity(intent);
                                    }
                                }

                            });
                        }
                        builder.setView(vw2);

                        alertDialog = builder.create();
                        alertDialog.show();
                    }else if(position==5){
                        builder = new AlertDialog.Builder(getContext());

                        View vw = null, vw2;
                        builder = new AlertDialog.Builder(getContext());
                        vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                        LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                        final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);
                        for (int i = 0; i < 2; i++) {
                            vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                            final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                            gr.grfonttxt(tvrepair);
                            tvrepair.setText(cons[i]);
                            insertPoint.addView(vw);
                            final View finalVw = vw;
                            finalVw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //View v3 = finalVw;
                                    if (v2 != null) {
                                        //
                                        mclass.setService(tvrepair.getText().toString());
                                        final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                        tv2.setTextColor(Color.parseColor("#737272"));
                                        final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                        iv3.setImageResource(R.drawable.checkbox);
                                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                    }
                                    //if (count ==1) {
                                    //ivlist.setImageResource(R.drawable.checkbox2);
                                    mclass.setService(tvrepair.getText().toString());
                                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                    final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                    final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                    iv3.setImageResource(R.drawable.checkbox2);
                                    tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                    v2 = v;
                                    //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);

                                    //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                }
                            });
//
                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if ( v2==null )
                                    {
                                        Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                        // new RegisterAsyntaskNew().execute();
                                    }else {

                                        Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                        // intent.putExtra("message", tvtheatre.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        mclass.setType("Male");
                                        mclass.setModel(tvproduct.getText().toString());

                                        intent.putExtra("service", tvproduct.getText().toString());
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        startActivity(intent);
                                    }
                                }

                            });

                        }
                        builder.setView(vw2);

                        alertDialog = builder.create();
                        alertDialog.show();
                    }else if(position==6){
                        builder = new AlertDialog.Builder(getContext());

                        View vw = null, vw2;
                        builder = new AlertDialog.Builder(getContext());
                        vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                        LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                        final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);
                        for (int i = 0; i < 2; i++) {
                            vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                            final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                            gr.grfonttxt(tvrepair);
                            tvrepair.setText(cons[i]);
                            insertPoint.addView(vw);
                            final View finalVw = vw;
                            finalVw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //View v3 = finalVw;
                                    if (v2 != null) {
                                        mclass.setService(tvrepair.getText().toString());
                                        final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                        tv2.setTextColor(Color.parseColor("#737272"));
                                        final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                        iv3.setImageResource(R.drawable.checkbox);
                                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                    }
                                    //if (count ==1) {
                                    //ivlist.setImageResource(R.drawable.checkbox2);
                                    mclass.setService(tvrepair.getText().toString());
                                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                    final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                    final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                    iv3.setImageResource(R.drawable.checkbox2);
                                    tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                    v2 = v;
                                    //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);


                                    //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                }
                            });
//
                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if ( v2==null )
                                    {
                                        Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                        // new RegisterAsyntaskNew().execute();
                                    }else {

                                        Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                        // intent.putExtra("message", tvtheatre.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        mclass.setType("Male");
                                        mclass.setModel(tvproduct.getText().toString());

                                        intent.putExtra("service", tvproduct.getText().toString());
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        startActivity(intent);
                                    }
                                }

                            });
                        }
                        builder.setView(vw2);

                        alertDialog = builder.create();
                        alertDialog.show();
                    }else if(position==7){

                        builder = new AlertDialog.Builder(getContext());

                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupbrand, null);
                        final EditText etemail = (EditText) vw.findViewById(R.id.etemail);
                        Button btnyes = (Button) vw.findViewById(R.id.btnyes);
                        Button btnno = (Button) vw.findViewById(R.id.btnno);
                        final TextInputLayout txtlay = (TextInputLayout) vw.findViewById(R.id.input_layout_email);

                        grfont gr = new grfont(getContext());
                        txtlay.setHint("Enter Service Type Here");
                        gr.grfonttxtinpt(txtlay);

                        gr.grfonttxtinpt(txtlay);
                        gr.grfonted(etemail);
                        gr.grfontbut(btnyes);
                        gr.grfontbut(btnno);

                        btnyes.setOnClickListener(new View.OnClickListener() {


                            @Override
                            public void onClick(View v) {


                                alertDialog.dismiss();

                            }

                        });
                        btnno.setOnClickListener(new View.OnClickListener() {


                            @Override
                            public void onClick(View v) {
                                if (etemail.getText().toString().equals("")) {
                                    Toast.makeText(getActivity(), "Service type field Should not be blank", Toast.LENGTH_LONG).show();
//
                                } else {
                                    builder = new AlertDialog.Builder(getContext());

                                    View vw = null, vw2;
                                    builder = new AlertDialog.Builder(getContext());
                                    vw2 = getLayoutInflater(savedInstanceState).inflate(R.layout.linearlayout, null);

                                    LinearLayout insertPoint = (LinearLayout) vw2.findViewById(R.id.linear);
                                    final Button btnsubmit = (Button) vw2.findViewById(R.id.btnsubmit);
                                    final TextView tvselect = (TextView) vw2.findViewById(R.id.tvselect);
                                    grfont gr = new grfont(getContext());
                                    gr.grfonttxt(tvselect);
                                    gr.grfontbut(btnsubmit);
                                    for (int i = 0; i < 2; i++) {
                                        vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popup, null);

                                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                                        gr.grfonttxt(tvrepair);
                                        tvrepair.setText(cons[i]);
                                        insertPoint.addView(vw);
                                        final View finalVw = vw;
                                        finalVw.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //View v3 = finalVw;
                                                if (v2 != null) {
                                                    //
                                                    mclass.setService(tvrepair.getText().toString());
                                                    final TextView tv2 = (TextView) v2.findViewById(R.id.tvrepair);
                                                    tv2.setTextColor(Color.parseColor("#737272"));
                                                    final ImageView iv3 = (ImageView) v2.findViewById(R.id.ivlist);
                                                    iv3.setImageResource(R.drawable.checkbox);
                                                    v2.setBackgroundColor(Color.parseColor("#ffffff"));
                                                }
                                                //if (count ==1) {
                                                //ivlist.setImageResource(R.drawable.checkbox2);
                                                mclass.setService(tvrepair.getText().toString());
                                                v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                                final TextView tv3 = (TextView) v.findViewById(R.id.tvrepair);
                                                final ImageView iv3 = (ImageView) v.findViewById(R.id.ivlist);
                                                iv3.setImageResource(R.drawable.checkbox2);
                                                tv3.setTextColor(Color.parseColor("#4fc5e6"));
                                                v2 = v;
                                                //Button btnsubmit = (Button) v.findViewById(R.id.btnsubmit);

                                                //count++;
                                            /*}else{
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                            }
                                        });
//
                                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (v2 == null) {
                                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                                    // new RegisterAsyntaskNew().execute();
                                                } else {

                                                    Intent intent = new Intent(getActivity(), ServicingActivity.class);
                                                    // intent.putExtra("message", tvtheatre.getText().toString());
                                                    intent.putExtra("sertyp", 0);
                                                    mclass.setType("Male");
                                                    mclass.setModel(etemail.getText().toString());

                                                    intent.putExtra("service", etemail.getText().toString());
                                                    intent.putExtra("message", tvrepair.getText().toString());
                                                    startActivity(intent);
                                                }
                                            }

                                        });

                                    }
                                    builder.setView(vw2);
                                    alertDialog = builder.create();
                                    alertDialog.show();
                                }
                            }
                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
                    }
                }

            });

            linearbike.addView(pojo.getLinearLayout());

        }





        return view;
    }
}


