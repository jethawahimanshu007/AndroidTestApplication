package com.example.himanshu.kubratest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

//Class to save user posts
public class UserPosts extends Activity implements OnItemClickListener
{
    /** Called when the activity is first created. */
    private String url;
    UserPosts activity;
    ListView lview;
    ListViewAdapter lviewAdapter;

    String title[];

    String body[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_posts);

        activity=this;
        String id = getIntent().getStringExtra("id");
        url="https://mobile-code-test.ifactornotifi.com/json/posts?userId="+id;

        lview = (ListView) findViewById(R.id.listView2);


        new HttpRequestTask().execute();
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
        // TODO Auto-generated method stub

    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Void> {
        Post[] posts;
        @Override
        protected Void doInBackground(Void... params) {
            try {

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                posts= restTemplate.getForObject(url, Post[].class);
                title=new String[posts.length];
                body=new String[posts.length];
                int i=0;
                for(Post post:posts){
                    Logger.log_d(post.getTitle());
                    title[i]=post.getTitle();
                    body[i++]=post.getBody();
                }

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void t) {

            lviewAdapter = new ListViewAdapter(activity, title, body);


            lview.setAdapter(lviewAdapter);

            lview.setOnItemClickListener(activity);
            lviewAdapter.notifyDataSetChanged();
        }

    }
}
