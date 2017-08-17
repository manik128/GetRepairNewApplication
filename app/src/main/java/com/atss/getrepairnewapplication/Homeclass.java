package com.atss.getrepairnewapplication;

/**
 * Created by Admin on 16-03-2017.
 */

public class Homeclass {

    public String[] homeappliances(String cat){
        String[] brand=new  String[100];
        switch (cat){
            case "Television":  brand= new String[]{"sony", "samsung", "LG", "Toshiba", "Panasonic", "micromax", "Haier", "Hitachi", "Hyundai", "Mitashi", "Onida", "philips", "Sansui", "sharp", "Videocon", "vu", "intex", "Vizio", "dell"};
                                break;
            case "DVD Player": brand= new String[]{"sony","philips","LG","Samsung","Panasonic","intex","Pioneer","yamaha","Xenet","Bexton","iBell","Denon","Marantz","Maxbell","Worldtech"};
                               break;
        }

        return brand ;
    }

}
