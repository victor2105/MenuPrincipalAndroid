package com.vhsstudio.simpletable.cansado;

import java.util.ArrayList;

/**
 * Created by VictorHS on 10/26/2014.
 */
public class Table {
    private long id;
    private String name;

    public Table(){
        name = "";
    }
    public String getName() {
        if(name.equals("")) name = "Table "+id;
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
}
