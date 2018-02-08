package com.example.himanshu.kubratest;

/**
 * Created by Himanshu on 2/8/2018.
 */

public class User {
    /*{
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
  }*/

    int id; String name,username,email,phone,website;
    Address address;Company company;
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setWebsite(String website){
        this.website=website;
    }
    public void setAddress(Address address){
        this.address=address;
    }
    public void setCompany(Company company){
        this.company=company;
    }

    public String getUsername(){
        return username;
    }
    public int getId(){
        return id;
    }
    public Address getAddress(){
        return address;
    }


}
