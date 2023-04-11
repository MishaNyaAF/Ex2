package Mishaniy.entity;

import java.util.List;

public class Response {

    private List<Items> items;

    public Response() {
    }

    public Response(List<Items> items) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Response{" +
                "items=" + items +
                '}';
    }
}
