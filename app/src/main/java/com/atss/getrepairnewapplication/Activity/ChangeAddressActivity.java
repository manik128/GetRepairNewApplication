package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atss.getrepairnewapplication.LocalDb.DBManager;
import com.atss.getrepairnewapplication.LocalDb.Mysqlite;
import com.atss.getrepairnewapplication.R;


public class ChangeAddressActivity extends AppCompatActivity {
TextView tvaddress,tvname,tvmobile,tvaddress1,tvhouse,tvstreet,tvid;
    private DBManager dbManager;
    ListView lv;
    private SimpleCursorAdapter adapter;
    Cursor cursor;
    Mysqlite mysqlite;
    ImageView ivedit,ivdelete;
    final String[] from = new String[] {"_id", "name", "address" ,"mobile" };
RelativeLayout rladdress,rlpermanantaddress;
    final int[] to = new int[] {R.id.tvname, R.id.tvaddress, R.id.tvmobile,R.id.tvid};
ImageView ivradio;
    Button btnedit,btnupdate;
    String names,id,address,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);
        tvaddress = (TextView) findViewById(R.id.tvaddress);
      //  tvaddress1=(TextView)findViewById(R.id.tvaddres1);
        rladdress=(RelativeLayout)findViewById(R.id.rladdress);
        tvname=(TextView)findViewById(R.id.tvname);
        tvmobile=(TextView)findViewById(R.id.tvmobile);
        btnedit=(Button)findViewById(R.id.btnedit);
        btnupdate=(Button)findViewById(R.id.btnupdate);
      //  tvhouse=(TextView)findViewById(R.id.tvhousenumber);
      //  tvstreet=(TextView)findViewById(R.id.tvstreet);


   /* rlpermanantaddress=(RelativeLayout)findViewById(R.id.rlpermenantaddress);
      //  ivradio=(ImageView)findViewById(R.id.ivradio);
    rlpermanantaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //  ivradio.setBackgroundResource(R.drawable.radiobutton);
            }
        });
*/

        tvaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeAddressActivity.this, EditaddressActivity11.class);
                startActivityForResult(intent,1);
            }
        });

       /* ivedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvname.setVisibility(View.VISIBLE);
                rladdress.setVisibility(View.VISIBLE);
                tvmobile.setVisibility(View.VISIBLE);
                Intent intent = new Intent(ChangeAddressActivity.this, EditaddressActivity11.class);
                startActivityForResult(intent, 2);
            }
        });*/

//        dbManager = new DBManager(this);
//        dbManager.open();
//        cursor = dbManager.fetch();
//        lv = (ListView) findViewById(R.id.lvaddress);
//    //    lv.setEmptyView(findViewById(R.id.empty));
//
//        adapter = new SimpleCursorAdapter(this, R.layout.item_addaddress, cursor, from, to, 0);
//        adapter.notifyDataSetChanged();
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
//TextView idTextView = (TextView) view.findViewById(R.id.tvid);
//                TextView tvname = (TextView) view.findViewById(R.id.tvaddress);
//                TextView tvaddress= (TextView) view.findViewById(R.id.tvmobile);
//          TextView tvmobile=(TextView)view.findViewById(R.id.tvmobile);
//                RelativeLayout rlitemaddress=(RelativeLayout)view.findViewById(R.id.rlitemaddress);
////ImageView ivitemedit=(ImageView)view.findViewById(R.id.ivitemedit);
//
//               id = idTextView.getText().toString();
//                 names = tvname.getText().toString();
//              address = tvaddress.getText().toString();
//         mobile=tvmobile.getText().toString();
//                rlitemaddress.setBackgroundColor(Color.parseColor("#d425d2"));
//Intent intent1=new Intent();
//                intent1.putExtra("name", names);
//                intent1.putExtra("address", address);
//                intent1.putExtra("id", id);
//                intent1.putExtra("mobile", mobile);
//btnedit.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Intent modify_intent=new Intent(getApplicationContext(), ModifyCountryActivity.class);
//        modify_intent.putExtra("name", names);
//        modify_intent.putExtra("address", address);
//        modify_intent.putExtra("id", id);
//        modify_intent.putExtra("mobile", mobile);
//        startActivity(modify_intent);
//    }
//});
//                btnupdate.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                   Intent intent=new Intent(getApplicationContext(), SchedulePageActivity.class);
//                        intent.putExtra("address",address);
//                intent.putExtra("mobile",mobile);
//                intent.putExtra("name", names);
//                setResult(RESULT_OK,intent);
//                finish();
//
//                    }
//                });
//
//
//            }
//        });
//
//  mysqlite = new Mysqlite(getApplicationContext());
//        cursor = mysqlite.getdetails();
//        adapter = new SimpleCursorAdapter(this, R.layout.item_addaddress, cursor, from, to, 0);
//        lv.setAdapter(adapter);
//        if (cursor.getCount() > 1) {
//
//            tvaddress.setEnabled(false);
//            tvaddress.setTextColor(Color.parseColor("#f4f4f4"));
//        }
//    }
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//       if (requestCode == 1) {
//            if (resultCode == RESULT_OK) {
//                mysqlite = new Mysqlite(getApplicationContext());
//                cursor = mysqlite.getdetails();
//                adapter = new SimpleCursorAdapter(this, R.layout.item_addaddress, cursor,from, to, 0);
//                lv.setAdapter(adapter);
//                if (cursor.getCount() > 1) {
//
//                    tvaddress.setEnabled(false);
//                    tvaddress.setTextColor(Color.parseColor("#f4f4f4"));
//                }
//            }
//        }

    }
}

