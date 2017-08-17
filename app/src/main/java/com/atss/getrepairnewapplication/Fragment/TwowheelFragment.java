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
public  class TwowheelFragment extends Fragment {
    LinearLayout linearbike;
    int j;
    TextView tvselect;
    String fName, fcat,fservice;
    String[] models={"Bajaj","Hero","Honda","Mahindra","Suzuki","TVS","Yamaha","Others"};
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    int count=0,count1=0;
    Context con;
    Mainclass mclass;
    TextInputLayout txtlay;
    View view1, view2;
    @SuppressLint("ValidFragment")
    public TwowheelFragment(Context cont){
     con=cont;
    }
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.bikefragment,null);
        linearbike=(LinearLayout)view.findViewById(R.id.linearbike);
        mclass=(Mainclass)getActivity().getApplicationContext();
        //tvselectmake.setText(fservice);
       // fservice = intent.getStringExtra("service");
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
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                        final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);

                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                        final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                        final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                        Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvservices);
                        gr.grfonttxt(tvrepair);

                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                {
                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                    // new RegisterAsyntaskNew().execute();
                                }
//                                else
//                                {
//                                    Toast.makeText(_con, "Image isn't ivPic", Toast.LENGTH_LONG).show();
//                                    // new RegisterAsyntask().execute();
//                                }

                                   else if (count == 1 & count1 == 0) {


                                        Intent intent = new Intent(getContext(), ServicingActivity.class);
                                        intent.putExtra("message", tvservices.getText().toString());
                                        intent.putExtra("service", tvproduct.getText().toString());
                                        mclass.setType("Bikes");
                                        mclass.setModel(tvproduct.getText().toString());
                                        mclass.setService(tvservices.getText().toString());
                                        intent.putExtra("sertyp", 0);
                                        startActivity(intent);

                                    } else if (count1 == 1 & count == 0) {


                                        Intent intent = new Intent(getContext(), ServicingActivity.class);
                                        intent.putExtra("message", tvrepair.getText().toString());
                                        intent.putExtra("service", tvproduct.getText().toString());
                                        mclass.setType("Bikes");
                                        mclass.setModel(tvproduct.getText().toString());
                                        mclass.setService(tvrepair.getText().toString());
                                        intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                        startActivity(intent);

                                    }
                                }


                        });

                        tvservices.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = 1;
                                count1 = 0;
                                ivlist.setImageResource(R.drawable.checkbox2);
                                tvrepair.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                            }
                        });

                        tvrepair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count1 = 1;
                                count = 0;
                                tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                ivlist.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox2);

                                //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                            }

                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//}


                    } else if (position == 1) {
                        builder = new AlertDialog.Builder(getContext());
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                        final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);
                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                        final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                        final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                        Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvservices);
                        gr.grfonttxt(tvrepair);

                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                {
                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                    // new RegisterAsyntaskNew().execute();
                                }
                             else    if (count == 1 & count1 == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvservices.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvservices.getText().toString());
                                    intent.putExtra("sertyp", 0);
                                    startActivity(intent);
                                } else if (count1 == 1 & count == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvrepair.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvrepair.getText().toString());
                                    intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                    startActivity(intent);
                                }
                            }
                        });
                        tvservices.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = 1;
                                count1 = 0;
                                ivlist.setImageResource(R.drawable.checkbox2);
                                tvrepair.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                            }
                        });

                        tvrepair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count1 = 1;
                                count = 0;
                                tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                ivlist.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox2);

                                //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                            }
                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//
                    }else if (position == 2) {
                        builder = new AlertDialog.Builder(getContext());
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                        final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);
                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                        final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                        final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                        Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvservices);
                        gr.grfonttxt(tvrepair);

                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                {
                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                    // new RegisterAsyntaskNew().execute();
                                }
                              else if (count == 1 & count1 == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvservices.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvservices.getText().toString());
                                    intent.putExtra("sertyp", 0);
                                    startActivity(intent);
                                } else if (count1 == 1 & count == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvrepair.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvrepair.getText().toString());
                                    intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                    startActivity(intent);
                                }
                            }
                        });
                        tvservices.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = 1;
                                count1 = 0;
                                ivlist.setImageResource(R.drawable.checkbox2);
                                tvrepair.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                            }
                        });

                        tvrepair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count1 = 1;
                                count = 0;
                                tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                ivlist.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox2);

                                //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                            }
                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//
                    }else if(position==3){
                        builder = new AlertDialog.Builder(getContext());
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                        final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);
                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                        final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                        final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                        Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvservices);
                        gr.grfonttxt(tvrepair);

                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                {
                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                    // new RegisterAsyntaskNew().execute();
                                }
                            else  if (count == 1 & count1 == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvservices.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvservices.getText().toString());
                                    intent.putExtra("sertyp", 0);
                                    startActivity(intent);
                                } else if (count1 == 1 & count == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvrepair.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvrepair.getText().toString());
                                    intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                    startActivity(intent);
                                }
                            }
                        });
                        tvservices.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = 1;
                                count1 = 0;
                                ivlist.setImageResource(R.drawable.checkbox2);
                                tvrepair.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                            }
                        });

                        tvrepair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count1 = 1;
                                count = 0;
                                tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                ivlist.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox2);

                                //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                            }
                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//
                    }else if(position==4){
                        builder = new AlertDialog.Builder(getContext());
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                        final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);
                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                        final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                        final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                        Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvservices);
                        gr.grfonttxt(tvrepair);

                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                {
                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                    // new RegisterAsyntaskNew().execute();
                                }
                             else  if (count == 1 & count1 == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvservices.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvservices.getText().toString());
                                    intent.putExtra("sertyp", 0);
                                    startActivity(intent);
                                } else if (count1 == 1 & count == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvrepair.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvrepair.getText().toString());
                                    intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                    startActivity(intent);
                                }
                            }
                        });
                        tvservices.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = 1;
                                count1 = 0;
                                ivlist.setImageResource(R.drawable.checkbox2);
                                tvrepair.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                            }
                        });

                        tvrepair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count1 = 1;
                                count = 0;
                                tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                ivlist.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox2);

                                //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                            }
                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//
                    }else  if(position==5){
                        builder = new AlertDialog.Builder(getContext());
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                        final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);
                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                        final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                        final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                        Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvservices);
                        gr.grfonttxt(tvrepair);

                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                {
                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                    // new RegisterAsyntaskNew().execute();
                                }
                              else   if (count == 1 & count1 == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvservices.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvservices.getText().toString());
                                    intent.putExtra("sertyp", 0);
                                    startActivity(intent);
                                } else if (count1 == 1 & count == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvrepair.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvrepair.getText().toString());
                                    intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                    startActivity(intent);
                                }
                            }
                        });
                        tvservices.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = 1;
                                count1 = 0;
                                ivlist.setImageResource(R.drawable.checkbox2);
                                tvrepair.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                            }
                        });

                        tvrepair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count1 = 1;
                                count = 0;
                                tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                ivlist.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox2);

                                //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                            }
                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//
                    }else  if(position==6){
                        builder = new AlertDialog.Builder(getContext());
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                        final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);
                        final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                        final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                        final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                        Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                        final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                        grfont gr = new grfont(getContext());
                        gr.grfonttxt(tvservices);
                        gr.grfonttxt(tvrepair);

                        gr.grfonttxt(tvselect);
                        gr.grfontbut(btnsubmit);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                {
                                    Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                    // new RegisterAsyntaskNew().execute();
                                }
                              else if (count == 1 & count1 == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvservices.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvservices.getText().toString());
                                    intent.putExtra("sertyp", 0);
                                    startActivity(intent);
                                } else if (count1 == 1 & count == 0) {
                                    Intent intent = new Intent(getContext(), ServicingActivity.class);
                                    intent.putExtra("message", tvrepair.getText().toString());
                                    intent.putExtra("service", tvproduct.getText().toString());
                                    mclass.setType("Bikes");
                                    mclass.setModel(tvproduct.getText().toString());
                                    mclass.setService(tvrepair.getText().toString());
                                    intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                    startActivity(intent);
                                }
                            }
                        });
                        tvservices.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = 1;
                                count1 = 0;
                                ivlist.setImageResource(R.drawable.checkbox2);
                                tvrepair.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                            }
                        });

                        tvrepair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count1 = 1;
                                count = 0;
                                tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                ivlist.setImageResource(R.drawable.checkbox);
                                tvservices.setTextColor(Color.parseColor("#737272"));
                                ivlist1.setImageResource(R.drawable.checkbox2);

                                //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                            }
                        });

                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//
                    }else if(position==7){
                        builder = new AlertDialog.Builder(getContext());
                        View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupbrand, null);
                        final EditText etemail = (EditText) vw.findViewById(R.id.etemail);
                        Button btnyes = (Button) vw.findViewById(R.id.btnyes);
                        Button btnno = (Button) vw.findViewById(R.id.btnno);
                        final TextInputLayout  txtlay = (TextInputLayout)vw.findViewById(R.id.input_layout_email);
                        grfont gr = new grfont(getContext());

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


                                builder = new AlertDialog.Builder(getContext());
                                View vw = getLayoutInflater(savedInstanceState).inflate(R.layout.popupmenu, null);
                                final TextView tvservices = (TextView) vw.findViewById(R.id.tvservices);
                                final TextView tvrepair = (TextView) vw.findViewById(R.id.tvrepair);
                                final ImageView ivlist = (ImageView) vw.findViewById(R.id.ivlist);
                                final ImageView ivlist1 = (ImageView) vw.findViewById(R.id.ivlist1);
                                Button btnsubmit = (Button) vw.findViewById(R.id.btnsubmit);
                                final TextView tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(getContext());
                                gr.grfonttxt(tvservices);
                                gr.grfonttxt(tvrepair);

                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnsubmit);

                                btnsubmit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if ( ivlist.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState()&& ivlist1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.checkbox).getConstantState() )
                                        {
                                            Toast.makeText(getActivity(), "Select atleast one service", Toast.LENGTH_LONG).show();
                                            // new RegisterAsyntaskNew().execute();
                                        }
                                     else  if (count == 1 & count1 == 0) {
                                            Intent intent = new Intent(getContext(), ServicingActivity.class);
                                            intent.putExtra("message", tvservices.getText().toString());
                                            intent.putExtra("service", etemail.getText().toString());
                                            mclass.setType("Bikes");
                                            mclass.setModel(tvproduct.getText().toString());
                                            mclass.setService(tvservices.getText().toString());
                                            intent.putExtra("sertyp", 0);
                                            startActivity(intent);
                                        } else if (count1 == 1 & count == 0) {
                                            Intent intent = new Intent(getContext(), ServicingActivity.class);
                                            intent.putExtra("message", tvrepair.getText().toString());
                                            intent.putExtra("service",etemail.getText().toString());
                                            mclass.setType("Bikes");
                                            mclass.setModel(tvproduct.getText().toString());
                                            mclass.setService(tvrepair.getText().toString());
                                            intent.putExtra("sertyp", 0);
//                                    intent.putExtra("sertyp", position);
                                            startActivity(intent);
                                        }
                                    }
                                });
                                tvservices.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        count = 1;
                                        count1 = 0;
                                        ivlist.setImageResource(R.drawable.checkbox2);
                                        tvrepair.setTextColor(Color.parseColor("#737272"));
                                        ivlist1.setImageResource(R.drawable.checkbox);
                                        tvservices.setTextColor(Color.parseColor("#4fc5e6"));

//count++;
/*else {
    count=0;

    ivlist.setImageResource(R.drawable.checkbox);
    tvservices.setTextColor(Color.parseColor("#737272"));
    count++;
}*/
                                    }
                                });

                                tvrepair.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        count1 = 1;
                                        count = 0;
                                        tvrepair.setTextColor(Color.parseColor("#4fc5e6"));
                                        ivlist.setImageResource(R.drawable.checkbox);
                                        tvservices.setTextColor(Color.parseColor("#737272"));
                                        ivlist1.setImageResource(R.drawable.checkbox2);

                                        //  count1++;
/*else {
    count1=0;

    tvrepair.setTextColor(Color.parseColor("#737272"));
    ivlist1.setImageResource(R.drawable.checkbox);
    count1++;
}*/
                                    }
                                });

                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
//

                            }

                        });
                        builder.setView(vw);
                        alertDialog = builder.create();
                        alertDialog.show();
//
                    }
                }

            });

            linearbike.addView(pojo.getLinearLayout());

        }



        return view;
    }

}

