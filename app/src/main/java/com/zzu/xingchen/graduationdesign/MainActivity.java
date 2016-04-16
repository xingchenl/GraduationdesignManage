package com.zzu.xingchen.graduationdesign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import de.greenrobot.event.EventBus;


public class MainActivity extends AppCompatActivity {

    String ss,ts_json;
    Spinner spinner;
    Button reStar,unStar;

    EditText name ,pass;

    String identity;
    String student="学生",teacher="老师";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reStar= (Button) findViewById(R.id.sure);
        unStar= (Button) findViewById(R.id.no_sure);

        name= (EditText) findViewById(R.id.userName);
        pass= (EditText) findViewById(R.id.passWord);

        spinner= (Spinner) findViewById(R.id.spin_name);
        sharedPreferences=getSharedPreferences("xingchen", MODE_PRIVATE);
        editor=sharedPreferences.edit();

        if(!(sharedPreferences.getString("name","null").equals("null"))){
           int id=sharedPreferences.getInt("id",0);
            String name=sharedPreferences.getString("name", "");
            String pass=sharedPreferences.getString("pass","");
            if(id==3){
                json(id,name,pass);
            }else if(id==2) {
                json(id,name,pass);
            }

        }

//        final Intent intent1= new Intent(MainActivity.this,Student.class);
//        final Intent intent2= new Intent(MainActivity.this,Teacher.class);
        reStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                identity =spinner.getSelectedItem().toString();

                if (identity.trim().equals(student.trim())) {

                    json(3, name.getText().toString().trim(), pass.getText().toString().trim());
                    //startActivity(intent1);
                }else if (identity.trim().equals(teacher.trim())){

                    json(2, name.getText().toString().trim(), pass.getText().toString().trim());
                  //  startActivity(intent2);
                }else {
                    Toast.makeText(getApplicationContext(), "暂无权限登录！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }




    public void  json(final Integer id, final String us, final String ps){

        RequestQueue requestQueue= Volley.newRequestQueue(this);

         editor.putInt("id",id);
        editor.putString("name", us);
            editor.putString("pass", ps);
         editor.commit();
        String url1="http://192.168.127.120:8888/by/face/student/toProcessList?sno="+us;


        JsonObjectRequest jsonObjectRequest1=new JsonObjectRequest(Request.Method.POST, url1, null,
                new Response.Listener<JSONObject>() {
                    public JSONObject JS;

                    @Override
                    public void onResponse(JSONObject jsonObject) {

                        ss=jsonObject.toString();



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });

             requestQueue.add(jsonObjectRequest1);



        String url="http://192.168.127.120:8888/by/face/login?"+"userType="+id+"&login_pass="+ps+"&login_name="+us;

        //  String url="http://192.168.127.120:8888/by/face/login?userType=2&login_pass=2&login_name=2";

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                        final Intent intent1= new Intent(MainActivity.this,Student.class);
                        final Intent intent2= new Intent(MainActivity.this,Teacher.class);

                        intent1.putExtra("id",us);
                        intent1.putExtra("json",ss);
                        intent2.putExtra("id",us);

                        try {
                            Log.e("xxxx",jsonObject.get("success").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {

                            if(jsonObject.get("success").toString()=="true")

                            {

                                if (id == 3) {


                                    startActivity(intent1);

                                }
                                if (id == 2) {
                                    startActivity(intent2);
                                }
                            }else {
//                                Toast.makeText(getApplicationContext(), "学号或密码错误！！！",
//                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                          e.printStackTrace();
                        }

                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "用户名或密码错误！！！",
                        Toast.LENGTH_SHORT).show();
            }
        });



        requestQueue.add(jsonObjectRequest);
    }


//    public String request_me( final Integer id, final String us, final String ps){
//
//
//
//        RequestQueue requestQueue= Volley.newRequestQueue(this);
//
//        String url="http://192.168.127.120:8888/by/face/login";
//
//        //  StringRequest stringRequest=new StringRequest(url,new Response.ErrorListener(){})
//
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        final Intent intent1= new Intent(MainActivity.this,Student.class);
//                        final Intent intent2= new Intent(MainActivity.this,Teacher.class);
//
//                        Log.e("xxxxxxxx",response);
//                     if(response.toString()!=null){
//
//                         if(id==1){
//
//                             startActivity(intent1);
//
//                         }if(id==2){
//                             startActivity(intent2);
//                         }
//
//                     }
//                        Log.d("TAG", response);
//                        Log.e("xxxxxxxxxx:",response);
//
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("TAG", error.getMessage(), error);
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("userType",id.toString());
//                map.put("log_pass",ps);
//                map.put("log_name",us);
//                return map;
//
//
//            }
//        };
//
//
//        requestQueue.add(stringRequest);
//
//        return " ";
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "点击1！！！",
                    Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.action_settings1){
            editor.clear();

            editor.commit();
            Toast.makeText(getApplicationContext(), "清除登陆信息！！",
                    Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }



}
