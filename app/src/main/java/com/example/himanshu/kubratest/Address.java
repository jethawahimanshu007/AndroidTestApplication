package com.example.himanshu.kubratest;

/**
 * Created by Himanshu on 2/8/2018.
 */

public class Address {
    /*"address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }}*/

    String street, suite, city,zipcode;
    geo geo;
    public void setStreet(String street){this.street=street;}
    public void setSuite(String suite){this.suite=suite;}
    public void setCity(String city){this.city=city;}
    public void setZipCode(String zipcode){this.zipcode=zipcode;}
    public void setGeo(geo geo){this.geo=geo;}

    public String getStreet(){return street;}
    public String getSuite(){return suite;}
    public String getCity(){return city;}
    public String getZipcode(){return zipcode;}
    public geo getGeo(){return geo;}
}
