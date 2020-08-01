package com.yushuhuai.bean;

public class Clazz {

    private Integer id;
    private String name;
    private Integer t_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Clazz() {
    }

    public Clazz(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Clazz(String name, Integer t_id) {
        this.name = name;
        this.t_id = t_id;
    }

    public Clazz(Integer id, String name, Integer t_id) {
        this.id = id;
        this.name = name;
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", t_id=" + t_id +
                "} \n";
    }
}
