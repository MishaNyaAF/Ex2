package Mishaniy.entity;

import java.util.ArrayList;

public class Response {

    private ArrayList<Items> items;
    private int count;

    public Response() {
    }

    public Response(ArrayList<Items> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Response{" +
                "items=" + items +
                '}';
    }
}
