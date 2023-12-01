package com.example.message.Models;

public class MsgModel {
    String id, message, type;

    public MsgModel(){

    }
    public MsgModel(String id, String message, String type) {
        this.id = id;
        this.message = message;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
