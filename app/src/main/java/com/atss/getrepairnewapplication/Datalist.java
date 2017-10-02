package com.atss.getrepairnewapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 06-02-2017.
 */

public class Datalist {


        @SerializedName(" data ")
        @Expose
        private List<Data> data = null;

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }


}
