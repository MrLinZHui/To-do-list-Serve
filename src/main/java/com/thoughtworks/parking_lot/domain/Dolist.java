package com.thoughtworks.parking_lot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dolist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
