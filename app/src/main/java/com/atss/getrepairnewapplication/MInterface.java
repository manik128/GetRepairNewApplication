package com.atss.getrepairnewapplication;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Admin on 02-02-2017.
 */

public interface MInterface {
//    @GET("/GetRepairApi/Login.php")
    void getUser(Callback<Datalist> uscb);
    @FormUrlEncoded
    @POST("/GetRepairApi/Register.php")
    public void insertUser(
            @Field("idkey") String mail,
            @Field("pass") String password,
            @Field("name") String username,

            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/Images.php")
    public void insertUsers(
            @Field("category") String category,
            @Field("type") String type,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/Login.php")
    public void insertlogin(
          @Field("idkey") String mail,
            @Field("pass") String password,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/article.php")
    public void insertarticle(
            @Field("category") String category,

            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/RetrievUserDet.php")
    public void insertuserid(
            @Field("userid") String userid,

            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/verifymob.php")
    public void insertotp(
            @Field("userid") String userid,
            @Field("mob") String mobile,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/checkotp.php")
    public void insertcheck(
            @Field("userid") String userid,
            @Field("otp") String otp,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/cartcount.php")
    public void insertcart(
            @Field("userid") String userid,

            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void Buildcont_order(
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("asize") String size,
            @Field("floor") String floor,
            @Field("budget") String budget,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void Manpower_order(
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("duty_sft") String duty,
            @Field("qty") String qty,
            @Field("intime") String intime,
            @Field("outtime") String outtime,
            @Field("service") String service,
            @Field("woff") String weekoff,
            @Field("gender") String gender,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void Movpack_order(
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("name") String name,
            @Field("vqty") String vqty,
            @Field("eqty") String eqty,
            @Field("fqty") String fqty,
            @Field("cfloor") String floor,
            @Field("clft") String crtlift,
            @Field("mfloor") String movingfloor,
            @Field("mlft") String lift,
            @Field("floc") String floorlocation,
            @Field("tloc") String location,

            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void RealEstate_order(
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("name") String name,
            @Field("buildtype") String building,
            @Field("preaddress") String address,
            @Field("budget") String budget,
            @Field("negotation") String negotation,
            @Field("floor") String floor,
            @Field("year") String year,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void ToursandTravelers_order (
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("name") String name,
            @Field("from_loc") String fromloc,
            @Field("to_loc") String toloc,
            @Field("adult") String adult,
            @Field("children") String children,
            @Field("vechicle_type") String vechicletype,
            @Field("from_trip") String fromtrip,
            @Field("to_trip") String totrip,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void Events_order(
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("food_type") String foodtype,
            @Field("exp_guest") String expguest,
            @Field("hostarea") String hostarea,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void spclinstr_order(
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("issue_details") String issue,

            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/GetRepairApi/insertcart.php")
    public void finance_budget(
            @Field("userid") String userid,
            @Field("reqid") String request,
            @Field("orderct") String order,
            @Field("subcat") String subcat,
            @Field("brand") String brand,
            @Field("stype") String subtype,
            @Field("budget") String budget,

            Callback<Response> callback);
}
