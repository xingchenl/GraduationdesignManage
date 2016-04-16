package com.zzu.xingchen.graduationdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

//public class Teacher extends AppCompatActivity  implements AdapterView.OnItemClickListener{

public class Teacher extends AppCompatActivity  {

    TabHost tabHost;

   private List<StudentEnty> mDtat,data2,data3,data4,data5,data6;
    Context mContext;
    private     StudentAdapt studentAdapt,studentAdapt2,studentAdapt3,studentAdapt4,studentAdapt5,studentAdapt6;

  private   ListView listStudent,listStudent2,listStudent3,listStudent4,listStudent5,listStudent6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);


        try {
            tabHost= (TabHost) findViewById(R.id.tabHost1);

            tabHost.setup();


            tabHost.addTab(tabHost.newTabSpec("tab_1")
                    .setContent(R.id.linearLayout1)
                    .setIndicator("任务   书", this.getResources().getDrawable(R.drawable.one_host)));

            tabHost.addTab(tabHost.newTabSpec("tab_2")
                    .setContent(R.id.linearLayout2)
                    .setIndicator("开题报告", this.getResources().getDrawable(R.drawable.two_host)));
            tabHost.addTab(tabHost.newTabSpec("tab_3")
                    .setContent(R.id.linearLayout3)
                    .setIndicator("中期检查", this.getResources().getDrawable(R.drawable.three_host)));

            tabHost.addTab(tabHost.newTabSpec("tab_4")
                    .setContent(R.id.linearLayout4)
                    .setIndicator("毕业论文", this.getResources().getDrawable(R.drawable.four_host)));

            tabHost.addTab(tabHost.newTabSpec("tab_5")
                    .setContent(R.id.linearLayout5)
                    .setIndicator("查重报告", this.getResources().getDrawable(R.drawable.five_host)));
            tabHost.addTab(tabHost.newTabSpec("tab_6")
                    .setContent(R.id.linearLayout6)
                    .setIndicator("成绩评定", this.getResources().getDrawable(R.drawable.six_host)));
        //    tabHost.setCurrentTab(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        mContext=Teacher.this;

        listStudent= (ListView) findViewById(R.id.list_student_1);
        listStudent2= (ListView) findViewById(R.id.list_student_2);
        listStudent3= (ListView) findViewById(R.id.list_student_3);
        listStudent4= (ListView) findViewById(R.id.list_student_4);
        listStudent5= (ListView) findViewById(R.id.list_student_5);
        listStudent6= (ListView) findViewById(R.id.list_student_6);

            mDtat=new  LinkedList<StudentEnty>();
        data2=new  LinkedList<StudentEnty>();
        data3=new  LinkedList<StudentEnty>();
        data4=new  LinkedList<StudentEnty>();
        data5=new  LinkedList<StudentEnty>();
        data6=new  LinkedList<StudentEnty>();

        Bundle extras = getIntent().getExtras();
        String mText = extras.getString("id");


        for(int i=0;i<30;i++){
            mDtat.add(new StudentEnty("小明"+i,"2013778010"+i));
            data2.add(new StudentEnty("小强"+i,"123778010"+i));
            data3.add(new StudentEnty("小丁"+i,"33313778010"+i));
            data4.add(new StudentEnty("梨花"+i,"4443778010"+i));
            data5.add(new StudentEnty("小崔"+i,"5553778010"+i));
            data6.add(new StudentEnty("大王"+i,"6663778010"+i));

        }

        studentAdapt=new StudentAdapt((LinkedList<StudentEnty>)mDtat,mContext);
        studentAdapt2=new StudentAdapt((LinkedList<StudentEnty>)data2,mContext);
        studentAdapt3=new StudentAdapt((LinkedList<StudentEnty>)data3,mContext);
        studentAdapt4=new StudentAdapt((LinkedList<StudentEnty>)data4,mContext);
        studentAdapt5=new StudentAdapt((LinkedList<StudentEnty>)data5,mContext);
        studentAdapt6=new StudentAdapt((LinkedList<StudentEnty>)data6,mContext);
        listStudent.setAdapter(studentAdapt);
        listStudent2.setAdapter(studentAdapt2);
        listStudent3.setAdapter(studentAdapt3);
        listStudent4.setAdapter(studentAdapt4);
        listStudent5.setAdapter(studentAdapt5);
        listStudent6.setAdapter(studentAdapt6);


listStudent6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"你点击了第" + position + "项", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(Teacher.this,StudentReport.class);

        startActivity(intent);
    }
});

    }

//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//
//       // Toast.makeText(mContext,"你点击了第" + position + "项", Toast.LENGTH_SHORT).show();
//
//        Log.e("xxxxxxxxxxxx","你点击了第" + parent.getId() + "项");
//
//    }


}
