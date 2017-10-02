package com.atss.getrepairnewapplication;

/**
 * Created by Admin on 02-02-2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

   @SerializedName("fsname")
   @Expose
   private String fsname;
   @SerializedName("lsname")
   @Expose
   private String lsname;
   @SerializedName("phno")
   @Expose
   private String phno;
   @SerializedName("email")
   @Expose
   private String email;
   @SerializedName("password")
   @Expose
   private String password;
   @SerializedName("cust_id")
   @Expose
   private String custId;

   public String getFsname() {
       return fsname;
   }

   public void setFsname(String fsname) {
       this.fsname = fsname;
   }

   public String getLsname() {
       return lsname;
   }

   public void setLsname(String lsname) {
       this.lsname = lsname;
   }

   public String getPhno() {
       return phno;
   }

   public void setPhno(String phno) {
       this.phno = phno;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }

   public String getCustId() {
       return custId;
   }

   public void setCustId(String custId) {
       this.custId = custId;
   }

}


