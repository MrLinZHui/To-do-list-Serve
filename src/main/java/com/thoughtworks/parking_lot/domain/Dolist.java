package com.thoughtworks.parking_lot.domain;

import javax.persistence.Entity;
public class Dolist {

    private String listValue;

    private boolean isSelecting;

    public Dolist(String listValue, boolean isSelecting) {
        this.listValue = listValue;
        this.isSelecting = isSelecting;
    }

    public Dolist() {
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public boolean isSelecting() {
        return isSelecting;
    }

    public void setSelecting(boolean isSelecting) {
        this.isSelecting = isSelecting;
    }
}
