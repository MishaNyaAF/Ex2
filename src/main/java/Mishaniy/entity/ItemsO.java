package Mishaniy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsO {
    @JsonProperty("title")
    private String postLink;
    private String text;

    public ItemsO() {
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ItemsO(String postLink, String text) {
        this.postLink = postLink;
        this.text = text;
    }

    @Override
    public String toString() {
        return "ItemsO{" +
                "postLink='" + postLink + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
