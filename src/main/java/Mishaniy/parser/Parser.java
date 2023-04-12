package Mishaniy.parser;

import Mishaniy.entity.Items;
import Mishaniy.entity.Post;
import Mishaniy.entity.Raw;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class Parser {
    public static ArrayList<Post> Parse(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Raw raw = objectMapper.readValue(new URL(url), Raw.class);

        if (raw.getErrorU() != null) {
            System.out.println("Профиль закрыт");
            return null;
        }
        if (raw.getResponse() == null){
            return null;
        }
        if (raw.getResponse().getCount() == 0){
            System.out.println("Профиля не существует, либо нет постов");
            return null;
        }
        var resParse = new ArrayList<Post>();

        long now = Calendar.getInstance().getTime().getTime() / 1000;
        long interval = 3600 * 24 * 7;
        long timeIntervalBoundary = now - interval;
        int quantity = 0;
        for (Items item : raw.getResponse().getItems()) {
            if (item.getDate() > timeIntervalBoundary) {
                quantity++;
            }
        }

        for (int i = 0; i < quantity; i++) {
            String link = "https://vk.com/wall" + raw.getResponse().getItems().get(i).getOwnerId() + "_" + raw.getResponse().getItems().get(i).getId();
            var postInfo = new Post(link, raw.getResponse().getItems().get(i).getText());
            resParse.add(postInfo);
        }
        return resParse;
    }
}
