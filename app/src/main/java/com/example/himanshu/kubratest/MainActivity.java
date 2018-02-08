package com.example.himanshu.kubratest;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/*Activity launch and shows the list of users fetched from Spring REST API*/
public class MainActivity extends AppCompatActivity {

    ArrayList<String> userList;
    ListView lv;
    ArrayAdapter<String> mAdapter;
    private String url="https://mobile-code-test.ifactornotifi.com/json/users";
    Button sort;
    int state=0; //ascending 0, descending 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sort=findViewById(R.id.sort);
        userList=new ArrayList<String>();
        lv = (ListView) findViewById(R.id.userList);
        mAdapter = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, userList);
        lv.setAdapter(mAdapter);

        //Redirection to HTTP Spring rest fetching data
        new HttpRequestTask().execute();

        //Redirection to posts activity
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedUser=userList.get(position);
                Intent intent = new Intent(MainActivity.this, UserPosts.class);
                intent.putExtra("id", selectedUser.split("\\(")[1].split("\\)")[0]);
                startActivity(intent);
            }
        });

        //Code for sorting
        sort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(state==1){
                Collections.sort(userList);
                mAdapter.notifyDataSetChanged();
                state=0;
                }
                else{
                    Collections.reverse(userList);
                    mAdapter.notifyDataSetChanged();
                    state=1;
                }
            }
        });

    }




    private class HttpRequestTask extends AsyncTask<Void, Void, Void> {
        User[] users;
        @Override
        protected Void doInBackground(Void... params) {
            try {

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                users = restTemplate.getForObject(url, User[].class);

                for(User user:users) {
                    userList.add(user.getUsername()+"   ("+user.getId()+")" + "\n" + user.getAddress().getStreet() + "  " + user.getAddress().getSuite()
                            + " " + user.getAddress().getCity() + " " + user.getAddress().getZipcode()+" ");
                }
                Collections.sort(userList);


            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void t) {

            Logger.log_d("Length of list:"+userList.size());
            mAdapter.notifyDataSetChanged();
        }

    }

}
