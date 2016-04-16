package com.zzu.xingchen.graduationdesign;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Student extends AppCompatActivity  implements View.OnClickListener{

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    timeSchedule[] timearr=new timeSchedule[7];
    JSONObject jsonObject;
    String  jsooo;
    String pingyu1,pingyu2,pingyu3,pingyu4,pingyu5,pingyu6,pingyu7;
    String mText;
    TextView pingyu;
    int colorA=Color.argb(188,114,232,81);
    int colorB=Color.argb(188,228,240,242);
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        sharedPreferences=getSharedPreferences("xingchen", MODE_PRIVATE);
        editor=sharedPreferences.edit();

        pingyu= (TextView) findViewById(R.id.text_pingyu);

        pingyu.setText("这里放置老师对项目所有进度选项的评语！！！！！！！！！！！！");


        timearr[0]=(timeSchedule) findViewById(R.id.yuan1);
        timearr[1]=(timeSchedule) findViewById(R.id.yuan2);
        timearr[2]=(timeSchedule) findViewById(R.id.yuan3);
        timearr[3]=(timeSchedule) findViewById(R.id.yuan4);
        timearr[4]=(timeSchedule) findViewById(R.id.yuan5);
        timearr[5]=(timeSchedule) findViewById(R.id.yuan6);
        timearr[6]=(timeSchedule) findViewById(R.id.yuan7);




        timearr[0].setOnClickListener(this);
        timearr[1].setOnClickListener(this);
        timearr[2].setOnClickListener(this);
        timearr[3].setOnClickListener(this);
        timearr[4].setOnClickListener(this);
        timearr[5].setOnClickListener(this);
        timearr[6].setOnClickListener(this);


        Bundle extras = getIntent().getExtras();
        mText = extras.getString("id");
     jsooo = extras.getString("json");

        Log.e("hehehehhe", jsooo.toString());




        try {
             jsonObject=new JSONObject(jsooo.toString());

            JSONArray  arr=jsonObject.getJSONArray("processList");
            int stuStatus= (int) jsonObject.get("stuStatus");
            Log.e("-----xxxxxxxxxx", String.valueOf(stuStatus));
            Log.e("-----xxxxxxxxxx", String.valueOf(arr));
            for(int i=0;i<arr.length();i++){
                int k=i+1;
                JSONObject obj= (JSONObject) arr.get(i);
                timearr[i].setXunlie((Integer) obj.get("id"));
                timearr[i].setShijian((String) obj.get("time"));
                Log.e("-----xxxxxxxxxx", String.valueOf(obj.get("time")));
                timearr[i].setShuoming((String) obj.get("name"));
                if(stuStatus>i){
                    timearr[i].setBack_ground(colorA);
                }else {
                    timearr[i].setBack_ground(colorB);
                }

            }
            pingyu1=getPingYU("openingReportList",jsonObject,"openingReportCommentList");
            pingyu2=getPingYU("taskList",jsonObject,"taskCommentList");

            pingyu4=getPingYU("thesisList",jsonObject,"thesisCommentList");

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void onClick(View v) {

        switch ( v.getId()){

            case R.id.yuan1: {

            pingyu.setText(pingyu1);


                break;
            }
            case R.id.yuan2: {

                pingyu.setText(pingyu2);
                break;
            }
            case R.id.yuan3: {
                pingyu.setText("评语3");

                break;
            }
            case R.id.yuan4: {

                pingyu.setText(pingyu4);
                break;
            }
            case R.id.yuan5: {

                pingyu.setText("评语5");
                break;
            }
            case R.id.yuan6: {


                break;
            }
            case R.id.yuan7: {


                break;
            }



        }
    }

    public  String getPingYU(String S,JSONObject jsonObject,String p) throws JSONException {

        String pingyuL = "";

       // Log.e("jesonnnnn",jsonObject.toString());

        JSONObject json=new JSONObject(jsonObject.toString());

       // Log.e(S,json.toString());
        JSONArray openList=json.getJSONArray(S.trim().toString());
      //  Log.e("jeso11111nnnnn",openList.toString());
        JSONArray openReport= new JSONArray(openList.toString());

    //    Log.e("jesoxxxxx1nnnnn",openReport.get(0).toString());

        JSONObject obj= (JSONObject) openReport.get(0);
        JSONArray jarr3= (JSONArray) obj.get(p);
        Log.e("jeszzzzzz1nnnnn",jarr3.toString());

        for(int i=0;i<jarr3.length();i++){
            JSONObject ob= (JSONObject) jarr3.get(i);
            pingyuL=pingyuL+ob.get("time")+"\n";
            pingyuL=pingyuL+ob.get("comment")+"\n";

        }
Log.e("评语字符",pingyuL);
        return  pingyuL;

    }
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
