/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package com.atss.getrepairnewapplication.Pojoclass;

public class DataObjectorder {
    private String tvlegendName;
    private String legendBorn;
    private int ivimage;
    private String tvbrand;
    private  String tvprice;
    public DataObjectorder(String tvlegendName, String legendBorn, String tvbrand, String  tvprice, int ivimage){
     this.tvlegendName = tvlegendName;
        this.legendBorn=legendBorn ;
        this.tvbrand=tvbrand;
        this.tvprice= tvprice;
        this.ivimage=ivimage;
    }




    public String getTvlegendName() {
        return tvlegendName;
    }

    public void setTvlegendName(String tvlegendName) {
        this.tvlegendName = tvlegendName;
    }

    public String getTvbrand() {
        return tvbrand;
    }

    public void setTvbrand(String tvbrand) {
        this.tvbrand = tvbrand;
    }
    public String getTvprice() {
        return tvprice;
    }

    public void setTvprice(String tvprice) {
        this.tvprice = tvprice;
    }
    public int getIvimage() {
        return ivimage;
    }

    public void setIvimage(int ivimage) {
        this.ivimage = ivimage;
    }
    public String getLegendBorn() {
        return legendBorn;
    }

    public void setLegendBorn(String legendBorn) {
        this.legendBorn = legendBorn;
    }
}
