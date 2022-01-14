package com.example.list_view_arnau;

public class Item {
    private String title_stores;
    private int img_stores;
    private String emp;
    private int web;
    private String text_web;
    private int horario;
    private String text_horario;
    private int map;
    private String text_map;
    private int save;
    private int unsave;

    public Item(String title_stores, int img_stores, String emp, int web, String text_web, int horario, String text_horario, int map, String text_map, int save, int unsave) {
        this.title_stores = title_stores;
        this.img_stores = img_stores;
        this.emp = emp;
        this.web = web;
        this.text_web = text_web;
        this.horario = horario;
        this.text_horario = text_horario;
        this.map = map;
        this.text_map = text_map;
        this.save = save;
        this.unsave = unsave;
    }

    public String getTitle_stores() {
        return title_stores;
    }

    public void setTitle_stores(String title_stores) {
        this.title_stores = title_stores;
    }

    public int getImg_stores() {
        return img_stores;
    }

    public void setImg_stores(int img_stores) {
        this.img_stores = img_stores;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }

    public String getText_web() {
        return text_web;
    }

    public void setText_web(String text_web) {
        this.text_web = text_web;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getText_horario() {
        return text_horario;
    }

    public void setText_horario(String text_horario) {
        this.text_horario = text_horario;
    }

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public String getText_map() {
        return text_map;
    }

    public void setText_map(String text_map) {
        this.text_map = text_map;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getUnsave() {
        return unsave;
    }

    public void setUnsave(int unsave) {
        this.unsave = unsave;
    }
}
