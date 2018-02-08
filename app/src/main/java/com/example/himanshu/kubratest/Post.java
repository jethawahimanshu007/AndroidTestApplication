package com.example.himanshu.kubratest;

/**
 * Created by Himanshu on 2/8/2018.
 */

public class Post {
    String userId,id, title, body;

    public void setId(String id){
        this.id=id;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setBody(String body){
        this.body=body;
    }

    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }

}
