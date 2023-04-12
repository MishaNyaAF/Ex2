package Mishaniy.parser;

import Mishaniy.entity.Items;
import Mishaniy.entity.ItemsO;
import Mishaniy.entity.Raw;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Parser {
    public static ArrayList<Items> Parse(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Raw raw = objectMapper.readValue(new URL(url), Raw.class);
        if (raw.getErrorU() != null) {
            System.out.println("Профиль закрыт");
            return null;
        }
        if (raw.getResponse().getCount() == 0){
            System.out.println("Профиля не существует, либо нет постов");
            return null;
        }
        for (int i = 0; i < raw.getResponse().getItems().size(); i++) {
            String link = "https://vk.com/wall" + raw.getResponse().getItems().get(i).getOwnerId() + "_" + raw.getResponse().getItems().get(i).getId();
            System.out.println(link);
        }
        return raw.getResponse().getItems();
    }

    public static int TimeCheck(String url) throws IOException {
        long now = Calendar.getInstance().getTime().getTime() / 1000;
        long interval = 3600 * 24 * 7;
        long timeIntervalBoundary = now - interval;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Raw raw = objectMapper.readValue(new URL(url), Raw.class);
        int quantity = 0;
        for (Items item : raw.getResponse().getItems()) {
            if (item.getDate() > timeIntervalBoundary) {
                quantity++;
            }
        }
        return quantity;
    }

}
