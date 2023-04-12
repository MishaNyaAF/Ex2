package Mishaniy;

import Mishaniy.entity.Items;
import Mishaniy.entity.ItemsO;
import Mishaniy.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static ArrayList<Items> MainM(String inputLink) throws IOException {
        final String token = "vk1.a.D13L2RLvJnL1mXV1pKI8oYODXWu3h-s2Du5Sa0ecn35P2nnFIBo-G-MjdbIr2sLIDO4HBXK8DmJRnD9w5fc-pvyqWkDdSCeb6qgj-inOnqtkOsLm0mVVBQtwi6h2kuhERMlzcogiGyXnP5sspnl-i2c_-nHIAPaPx75-unecw4da0osBmSDBQu5IwS4KO_QOUf5F5aHkVrOGIQVD5vkd8w";
        if (!inputLink.matches("vk.com/[A-Za-z0-9_.]+$") && !inputLink.matches("https://vk.com/[A-Za-z0-9_.]+$")) {
            System.out.println("Некорректный формат ссылки");
            return null;
        }
        Pattern pattern = Pattern.compile("[A-Za-z0-9_.]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputLink);
        String domain = "";
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            domain = inputLink.substring(start, end);
        }
        String parseUrl = "https://api.vk.com/method/wall.get?domain=" + domain +
                "&access_token=" + token + "&v=5.131";
        if (Parser.Parse(parseUrl) == null){
            return null;
        }
        var res = new ArrayList<>(Objects.requireNonNull(Parser.Parse(parseUrl)));
        return res;
    }
}