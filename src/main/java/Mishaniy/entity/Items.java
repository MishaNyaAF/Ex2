package Mishaniy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {
    @JsonProperty("owner_id")
    private int ownerId;
    private int id;
    private int date;
    private String text;

    public Items() {
    }

    public Items(int ownerId, int id, int date, String text) {
        this.ownerId = ownerId;
        this.id = id;
        this.date = date;
        this.text = text;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Items{" +
                "ownerId=" + ownerId +
                ", id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
