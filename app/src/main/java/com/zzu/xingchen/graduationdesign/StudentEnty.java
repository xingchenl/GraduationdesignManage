package com.zzu.xingchen.graduationdesign;

/**
 * Created by xingchen on 2016/3/23.
 */
public class StudentEnty {

    String name;
    String id;
    public StudentEnty(String name,String id){

        this.name=name;
        this.id=id;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
