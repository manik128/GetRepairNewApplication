package com.atss.getrepairnewapplication;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by Admin on 08-02-2017.
 */

public class Mainclass extends Application {
    String address;
    String fulladdress;
    String locadd;
    String name;
    String house;
    String area;
    String state;
    String city;
    String date;
    String userid;
    String time;
    String category;
    String pin;
    int sertyp;
    String gender;
    String veg;
    String nonveg;
    String guest;
    String host;
    String duty;
    String type;
    String qty;
    String model;
    String size;
    String sqft;
    String number;
    String choose;
    String weekoff;
    String floor;
    String floors;
    String intime;
    String outtime;
    int budgetflag;
    String budget;
    String furnitureqty;
    String electricalqty;
    String vehicleqty;
    String company;
    String service;
    String repair;
    String issue;
    String currently;
    String move;
    String yes;
    String from;
    String buliding;
    String add;
    String quotation;
    String negotiation;
    String adult;
    String child;
    String to;
    String year;
    String newvar;
    String cart;
    String vechicle;
    String tripfrom;
    String tripto;
    String servicelift;
    String mobilenumber;
    int position;
Double lat;
    Double lang;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
    public String getFulladdress() {
        return fulladdress;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state =state;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getModel() {
        return model;
    }



    public void setBuliding(String buliding) {
        this.buliding =buliding;
    }
    public String getBuliding() {
        return buliding;
    }
    public void setAdd(String add) {
        this.add = add;
    }
    public String getAdd() {
        return add;
    }
    public void setBudgetflag(int budgetflag) {
        this.budgetflag = budgetflag;
    }
    public int getBudgetflag() {
        return budgetflag;
    }
    public void setChild(String child) {
        this.child = child;
    }
    public String getchild() {
        return child;
    }
    public void setVeg(String veg) {
        this.veg= veg;
    }
    public String getVeg() {
        return veg;
    }
    public void setNonveg(String nonveg) {
        this.nonveg = nonveg;
    }
    public String getNonveg() {
        return nonveg;
    }
    public void setGuest(String guest) {
        this.guest = guest;
    }
    public String getGuest() {
        return guest;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getHost() {
        return host;
    }
    public void setAdult(String adult) {
        this.adult = adult;
    }
    public String getAdult() {
        return adult;
    }
    public void setTripfrom(String tripfrom) {
        this.tripfrom = tripfrom;
    }
    public String getTripfrom() {
        return tripfrom;
    }
    public void setTripto(String tripto) {
        this.tripto = tripto;
    }
    public String getTripto() {
        return tripto;
    }
    public void setVechicle(String vechicle) {
        this.vechicle = vechicle;
    }
    public String getVechicle() {
        return vechicle;
    }
    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }
    public String getQuotation() {
        return quotation;
    }
    public void setNegotiation(String negotiation) {
        this.negotiation = negotiation;
    }
    public String getNegotiation() {
        return negotiation;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getFurnitureqty() {
        return furnitureqty;
    }
    public void setFurnitureqty(String furnitureqty) {
        this.furnitureqty = furnitureqty;
    }
    public String getElectricalqty() {
        return electricalqty;
    }

    public void setElectricalqty(String electricalqty) {
        this.electricalqty = electricalqty;
    }
    public String getVehicleqty() {
        return vehicleqty;
    }

    public void setVehicleqty(String vehicleqty) {
        this.vehicleqty = vehicleqty;
    }
    public String getCurrently() {
        return currently;
    }

    public void setCurrently(String currently) {
        this.currently = currently;
    }
    public String getServicelift() {
        return servicelift;
    }

    public void setServicelift(String servicelift) {
        this.servicelift = servicelift;
    }
    public String getmove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getNumber() {
        return number;
    }
    public void setGender(String gender) {
        this.gender= gender;
    }
    public String getGender() {
        return gender;
    }
    public void setDuty(String duty) {
        this.duty = duty;
    }
    public String getDuty() {
        return duty;
    }
    public void setQty(String qty) {
        this.qty = qty;
    }
    public String getQty() {
        return qty;
    }
    public void setIntime(String intime) {
        this.intime = intime;
    }
    public String getIntime() {
        return intime;
    }
    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }
    public String getOuttime() {
        return outtime;
    }
    public void setChoose(String choose) {
        this.choose = choose;
    }
    public String getChoose() {
        return choose;
    }
    public void setWeekoff(String weekoff) {
        this.weekoff= weekoff;
    }
    public String getWeekoff() {
        return weekoff;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getFloors() {
        return floors;
    }
    public void setSertyp(int sertyp) {
        this.sertyp = sertyp;
    }
    public int getSertyp() {
        return sertyp;
    }
    public void setFloors(String floors) {
        this.floors = floors;
    }
    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }
    public String getissue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getLocadd() {
        return locadd;
    }

    public void setLocadd(String locadd) {
        this.locadd = locadd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getHouse() {
        return house;
    }


    public void setHouse(String house) {
        this.house = house;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area= area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city= city;
    }


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLang() {
        return lang;
    }

    public void setLang(Double lang) {
        this.lang = lang;
    }
    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber= mobilenumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void sertyp(int i) {
    }
}
