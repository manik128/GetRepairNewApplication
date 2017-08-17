package com.atss.getrepairnewapplication.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.R;
import com.atss.getrepairnewapplication.SchedulePage.Getrepairpojo;
import com.atss.getrepairnewapplication.ServicingActivity;
import com.atss.getrepairnewapplication.grfont;


/**
 * Created by DFMS1 on 05-Jan-17.
 */

@SuppressLint("ValidFragment")
public  class FunctionhallFragment extends Fragment {
    LinearLayout linearbike;
    int j;
    String[] models={"Weeding","Birthday","Babyshower","Anniversary","Receptions","Others"};
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    int count,count1;
    Context con;
    Mainclass mclass;
    View view1, view2;
    @SuppressLint("ValidFragment")
    public FunctionhallFragment(Context cont){
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
                       Intent intent = new Intent(getContext(), ServicingActivity.class);
                       intent.putExtra("sertyp", 0);
                       mclass.setType("Function");
                       mclass.setModel(tvproduct.getText().toString());
                       intent.putExtra("service", tvproduct.getText().toString());
                       startActivity(intent);
                   }else if (position == 1) {
                       Intent intent = new Intent(getContext(), ServicingActivity.class);
                       intent.putExtra("sertyp", 0);
                       mclass.setType("Function");
                       mclass.setModel(tvproduct.getText().toString());
                       intent.putExtra("service", tvproduct.getText().toString());
                       startActivity(intent);
                   }else if (position == 2) {
                       Intent intent = new Intent(getContext(), ServicingActivity.class);
                       intent.putExtra("sertyp", 0);
                       mclass.setType("Function");
                       mclass.setModel(tvproduct.getText().toString());
                       intent.putExtra("service", tvproduct.getText().toString());
                       startActivity(intent);
                   }else if (position == 3) {
                       Intent intent = new Intent(getContext(), ServicingActivity.class);
                       intent.putExtra("sertyp", 0);
                       mclass.setType("Function");
                       mclass.setModel(tvproduct.getText().toString());
                       intent.putExtra("service", tvproduct.getText().toString());
                       startActivity(intent);
                   }else if (position == 4) {
                       Intent intent = new Intent(getContext(), ServicingActivity.class);
                       intent.putExtra("sertyp", 0);
                       mclass.setType("Function");
                       mclass.setModel(tvproduct.getText().toString());
                       intent.putExtra("service", tvproduct.getText().toString());
                       startActivity(intent);


                   }else if (position == 5) {
                       builder = new AlertDialog.Builder(getContext());
                       View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupbrand, null);
                       final EditText etemail = (EditText) vw.findViewById(R.id.etemail);
                       Button btnyes = (Button) vw.findViewById(R.id.btnyes);
                       Button btnno = (Button) vw.findViewById(R.id.btnno);
                       final TextInputLayout txtlay = (TextInputLayout) vw.findViewById(R.id.input_layout_email);
                       grfont gr = new grfont(getContext());
                       txtlay.setHint("Enter Event Type Here");
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

                               Intent intent = new Intent(getContext(), ServicingActivity.class);
                               intent.putExtra("sertyp", 0);
                               mclass.setType("Function");
                               mclass.setModel(etemail.getText().toString());
                               intent.putExtra("service",etemail.getText().toString());
                               startActivity(intent);
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

