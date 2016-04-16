package com.zzu.xingchen.graduationdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentReport extends AppCompatActivity {

    TextView textView;
    String s="Windows 98 操作系统；\n" +
            "Delohi 5.0开发工具（软件开发）；\n" +
            "C++（VC或C-Builder 5）开发工具；\n" +
            "Paradex 数据库软件。\n" +
            "4 .1计算机系统支持\n" +
            "本软件的开发需要工作平台：PC 主机；\n" +
            "4 .2需要交办单位承担的工作\n" +
            "需要（略）公司提供：\n" +
            "需求，在本周提供；\n" +
            "PF 1文件格式，或读写代码；\n" +
            "4 .3需要其它单位提供的条件\n" +
            "测试数据项目列表。\n" +
            "5 质量保证\n" +
            "质量审核：赵健颖，廖燕宁\n" +
            "5 .1评审和审查计划\n" +
            "见评审表；\n" +
            "5 .2标准、条例和约定\n" +
            "代码每日发送到小组共享区，由廖燕宁提取。\n" +
            "5 .3人员\n" +
            "赵健颖，廖燕宁\n" +
            "5 .4对任务间接承办单位的管理\n" +
            "略\n" +
            "6 软件配置管理\n" +
            "6 .1基线\n" +
            "开发编码结束后一周内，交齐文档、代码。\n" +
            "6 .2配置标识规则\n" +
            "软件开发计划：2000-10-1-1；\n" +
            "文档目录：2000-10-1-0；\n" +
            "\t需求分析报告：2000-10-1-2；\n" +
            "\t概要设计文档：2000-10-1-3；\n" +
            "详细设计文档：2000-10-1-4；\n" +
            "源代码：2000-10-1-5；\n" +
            "软件使用说明书：2000-10-1-6；\n" +
            "软件测试报告：2000-10-1-7；\n" +
            "软件审查报告：2000-10-1-8。\n" +
            "其他（略）。\n" +
            "6 .3配置控制\n" +
            "6 .3.1更改控制\n" +
            "软件设计的更改权限为：廖燕宁；\n" +
            "软件需求的更改权限为：赵健颖；\n" +
            "需求分析的更改权限为：廖燕宁；\n" +
            "编码的更改权限为：耿江涛，高小光；\n" +
            "文档的更改权限为：廖燕宁, 张欣；";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_report);

        textView= (TextView) findViewById(R.id.textView_lang);

        textView.setText(s);
    }
}
