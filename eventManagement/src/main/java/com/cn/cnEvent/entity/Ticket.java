package com.cn.cnEvent.entity;

import javax.persistence.*;

public class Ticket {

    private Long id;

    private String name;

    private String price;

    private Event event;

    private Attender attender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Attender getAttender() {
        return attender;
    }

    public void setAttender(Attender attender) {
        this.attender = attender;
    }
}