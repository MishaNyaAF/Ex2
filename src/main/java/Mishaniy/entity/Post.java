package Mishaniy.entity;

public class Post {
    private String link;
    private String text;

    public Post(String link, String text) {
        this.link = link;
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "link='" + link + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
