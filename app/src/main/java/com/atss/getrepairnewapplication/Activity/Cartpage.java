package com.atss.getrepairnewapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.atss.getrepairnewapplication.MInterface;
import com.atss.getrepairnewapplication.Mainclass;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Admin on 18-09-2017.
 */

public class Cartpage {
    String url = "http://getrepair.in";
    boolean stat=false;
    String res="failed";
    Context con;
    Mainclass mclass;
    RelativeLayout relativeLayout;
    String userid,request,cart,orderca, one;
    public  Cartpage(String userid ,Context context, Mainclass mcla){
       this.userid=userid;
        con=context;
        this.mclass = mcla;


    }

    RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();

    MInterface restInt = radapter.create(MInterface.class);
 public String buliding(String subcat,String brand,String subtype,String asize,String floor,String budget,String ordercat) {

     restInt.Buildcont_order(

             //Passing the values by getting it from editTexts
             userid, "1", ordercat,subcat,brand,subtype,asize, floor, budget,


             //Creating an anonymous callback
             new Callback<Response>() {
                 @Override
                 public void success(Response result, Response response) {
                     //On success we will read the server's output using bufferedreader
                     //Creating a bufferedreader object
                     BufferedReader reader = null;

                     //An string to store output from the server
                     String output = "";


                     try {
                         //Initializing buffered reader
                         reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                         //Reading the output in the string
                         output = reader.readLine();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     try {

                         JSONObject json_data = new JSONObject(output);
                         //json_data.put("us", result);
                         //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                         //json_data.put("code", result);

                         String code = json_data.getString("status");
                         String code1 = json_data.getString("id");
                         mclass.setCartid(code1);
                         //  String vendorid = json_data.getString("venid");
                         // String user = json_data.getString("userid");
                         //String code1 = json_data.getString("userid");
                         if (code.equalsIgnoreCase("success")) {
                             //  mclass.setUserid(user);
                             //  session(user);
                             // mclass.setVendorid(vendorid);
                             // mclass.setLogin(true);
                             res="success";
                        stat=true;
                         }
                         else if(code.equalsIgnoreCase("Exist")) {
                             stat=false;
                             res="exist";

                         }

                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                     //Displaying the output as a toast
                     //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                 }

                 @Override
                 public void failure(RetrofitError error) {
                     stat=false;
                     //If any error occured displaying the error as toast
                     // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                 }
             }
     );
     return res;
 }
    public String Manpowerservice (String subcat, String brand, String subtype, String duty, String qty, String intime, String outtime, String service, String weekoff, String gender, String orderca){

        restInt. Manpower_order(

                //Passing the values by getting it from editTexts
                userid, "2",orderca,subcat,brand,subtype,duty,qty,intime,outtime,service,weekoff,gender,


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("status");
                            String code1 = json_data.getString("id");
                            mclass.setCartid(code1);
                            //  String vendorid = json_data.getString("venid");
                            // String user = json_data.getString("userid");
                            //String code1 = json_data.getString("userid");
                            if (code.equalsIgnoreCase("success")) {
                                res="success";
                                stat=true;
                                //  mclass.setUserid(user);
                                //  session(user);
                                // mclass.setVendorid(vendorid);
                                // mclass.setLogin(true);

                            } else if(code.equalsIgnoreCase("Exist")) {
                                res="exist";
                                stat=false;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        stat=false;
                        //If any error occured displaying the error as toast
                        // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }

        );
        return res;
 }
    public String Moverpackers(String subcat,String brand,String subtype,String name, String vqty, String eqty, String fqty, String floor, String crtlift, String movingfloor, String lift, String floorlocation, String location,String orderca){

        restInt.Movpack_order(

                //Passing the values by getting it from editTexts
                userid,"3",orderca,subcat,brand,subtype,name,vqty,eqty,fqty,floor,crtlift,movingfloor,lift,floorlocation,location,


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("status");
                            String code1 = json_data.getString("id");
                            mclass.setCartid(code1);
                            //  String vendorid = json_data.getString("venid");
                            // String user = json_data.getString("userid");
                            //String code1 = json_data.getString("userid");
                            if (code.equalsIgnoreCase("success")) {
                                //  mclass.setUserid(user);
                                //  session(user);
                                // mclass.setVendorid(vendorid);
                                // mclass.setLogin(true);
                                res="success";
                                stat=true;
                            } else if(code.equalsIgnoreCase("Exist")) {
                                res="exist";
                                stat=false;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        stat=false;
                        //If any error occured displaying the error as toast
                        // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        return res;
    }
    public String RealEstate( String subcat,String brand,String subtype,String name,String building,String address,String budget,String negotation,String floor,String year,String orderca){

        restInt.RealEstate_order(

                //Passing the values by getting it from editTexts
                userid,"4",orderca,subcat,brand,subtype,name,building,address,budget,negotation,floor,year,


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("status");
                            String code1 = json_data.getString("id");
                            mclass.setCartid(code1);
                            //  String vendorid = json_data.getString("venid");
                            // String user = json_data.getString("userid");
                            //String code1 = json_data.getString("userid");
                            if (code.equalsIgnoreCase("success")) {
                                //  mclass.setUserid(user);
                                //  session(user);
                                // mclass.setVendorid(vendorid);
                                // mclass.setLogin(true);
                                res="success";
                                stat=true;
                            } else if(code.equalsIgnoreCase("Exist")) {
                                res="exist";
                                stat=false;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        stat=false;
                        //If any error occured displaying the error as toast
                        // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        return res;
    }
    public String ToursandTravelers(String subcat,String brand,String subtype,String name,String fromloc,String toloc,String adult,String children,String vechicletype,String fromtrip,String totrip,String orderca){

        restInt.ToursandTravelers_order (

                //Passing the values by getting it from editTexts
                userid,"5",orderca, subcat,brand,subtype, name,fromloc,toloc,adult,children,vechicletype,fromtrip,totrip,


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("status");
                            String code1 = json_data.getString("id");
                            mclass.setCartid(code1);
                            //  String vendorid = json_data.getString("venid");
                            // String user = json_data.getString("userid");
                            //String code1 = json_data.getString("userid");
                            if (code.equalsIgnoreCase("success")) {
                                //  mclass.setUserid(user);
                                //  session(user);
                                // mclass.setVendorid(vendorid);
                                // mclass.setLogin(true);
                                res="success";
                                stat=true;
                            } else if(code.equalsIgnoreCase("Exist")) {
                                res="exist";
                                stat=false;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        stat=false;
                        //If any error occured displaying the error as toast
                        // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        return res;
    }
    public String Events(String subcat,String brand,String subtype,String foodtype,String expguest,String hostarea,String orderca){

        restInt.Events_order (

                //Passing the values by getting it from editTexts
                userid,"6",orderca, subcat,brand,subtype,foodtype,expguest,hostarea,


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("status");
                            String code1 = json_data.getString("id");
                            mclass.setCartid(code1);
                            //  String vendorid = json_data.getString("venid");
                            // String user = json_data.getString("userid");
                            //String code1 = json_data.getString("userid");
                            if (code.equalsIgnoreCase("success")) {
                                //  mclass.setUserid(user);
                                //  session(user);
                                // mclass.setVendorid(vendorid);
                                // mclass.setLogin(true);
                                res="success";
                                stat=true;
                            } else if(code.equalsIgnoreCase("Exist")) {
                                res="exist";
                                stat=false;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        stat=false;
                        //If any error occured displaying the error as toast
                        // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        return res;
    }
    public String budgets(String subcat,String brand,String subtype,String budget,String orderca){

        restInt.finance_budget(

                //Passing the values by getting it from editTexts
               userid,"8",orderca,subcat,brand,subtype,budget,


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("status");
                            String code1 = json_data.getString("id");
                            mclass.setCartid(code1);
                            //  String vendorid = json_data.getString("venid");
                            // String user = json_data.getString("userid");
                            //String code1 = json_data.getString("userid");
                            if (code.equalsIgnoreCase("success")) {
                                //  mclass.setUserid(user);
                                //  session(user);
                                // mclass.setVendorid(vendorid);
                                // mclass.setLogin(true);
                                res="success";
                                stat=true;
                            } else if(code.equalsIgnoreCase("Exist")) {
                                res="exist";
                                stat=false;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        stat=false;
                        //If any error occured displaying the error as toast
                        // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        return res;
    }
    public String specialins(String subcat, String brand, String subtype, String issue, String orderca){

        restInt.spclinstr_order(

                //Passing the values by getting it from editTexts
                userid,"7",orderca,subcat,brand,subtype,issue,


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("status");
                            String code1 = json_data.getString("id");
                            mclass.setCartid(code1);
                            //  String vendorid = json_data.getString("venid");
                            // String user = json_data.getString("userid");
                            //String code1 = json_data.getString("userid");
                            if (code.equalsIgnoreCase("success")) {
                                //  mclass.setUserid(user);
                                //  session(user);
                                // mclass.setVendorid(vendorid);
                                // mclass.setLogin(true);
                                res="success";
                                stat=true;
                                //Toast.makeText(con,"success", Toast.LENGTH_LONG).show();

                            } else if(code.equalsIgnoreCase("Exist")) {
                                stat=false;
                                res="exist";

                                //Toast.makeText(con,"exist", Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        stat=false;
                        //If any error occured displaying the error as toast
                        // Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        return res;
    }
}
