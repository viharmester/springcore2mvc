package com.andorid.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.andorid.model.Event;

@Entity
public class EventImp implements Event {
    @Id

    private long id;
    private String title;
    private Date date;

    public EventImp(long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }
}
