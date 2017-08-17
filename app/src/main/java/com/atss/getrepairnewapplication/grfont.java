package com.atss.getrepairnewapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gigamole.navigationtabstrip.NavigationTabStrip;

/**
 * Created by Admin on 09-01-2017.
 */

public class grfont {
    Context con;
    public grfont(Context con) {
        this.con=con;

    }
    public void grfonttxt(TextView tx){
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Bold.otf");
        tx.setTypeface(type);
    }
    public void grfontra(RadioButton tx){
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Bold.otf");
        tx.setTypeface(type);
    }
    public void grfonmul(MultiAutoCompleteTextView tx){
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Bold.otf");
        tx.setTypeface(type);
    }

    public void grfonttxt(NavigationTabStrip tx){
//        Typeface type= Typeface.createFromAsset( con.getAssets(), "font/font.ttf");
//        tx.setTypeface(type);
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Bold.otf");
        tx.setTypeface(type);
    }
    public void grfontbut(Button bt){
//        Typeface face= Typeface.createFromAsset( con.getAssets(), "font/font.ttf");
//        bt.setTypeface(face);
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Bold.otf");
        bt.setTypeface(type);
    }
    public void grfonted(EditText ed){
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Bold.otf");
        ed.setTypeface(type);
    }

    public void grfontlgttxt(TextView tx){
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Light.otf");
        tx.setTypeface(type);
    }
    public void grfonttxtinpt(TextInputLayout tx){
        Typeface type = Typeface.createFromAsset(con.getAssets(), "Kontrapunkt-Bold.otf");
        tx.setTypeface(type);
    }
}
