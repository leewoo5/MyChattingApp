package com.topfactory.leewoo5629.mychattingapp;

/**
 * Created by leewoo5629.lee on 2017-08-30.
 */

public class Message {
    private String id;
    private String sender;
    private String recevier;
    private String text;

    public Message() {

    }

    public Message(String sender, String recevier, String text) {
        this.sender = sender;
        this.text = text;
        this.recevier = recevier;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecevier() {return recevier;}

    public void setRecevier(String recevier) {this.recevier = recevier;}
}
