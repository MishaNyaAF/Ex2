package Mishaniy;

import Mishaniy.entity.Post;
import Mishaniy.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static ArrayList<Post> MainM(String inputLink) throws IOException {
        final String token = ""; // Вставить свой access-token VK
        if (!inputLink.matches("^vk.com/[A-Za-z0-9_.]+$") && !inputLink.matches("^https://vk.com/[A-Za-z0-9_.]+$")) {
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
                "&access_token=" + token + "&count=100&v=5.131";
        if (Parser.Parse(parseUrl) == null) {
            return null;
        }
        int offset = 100;
        var res = new ArrayList<>(Objects.requireNonNull(Parser.Parse(parseUrl)));
        while (res.size() == offset) {
            parseUrl = "https://api.vk.com/method/wall.get?domain=" + domain +
                    "&access_token=" + token + "&count=100&offset=" + offset + "&v=5.131";
            res.addAll(Objects.requireNonNull(Parser.Parse(parseUrl)));
            offset += 100;
        }
        System.out.println("Профиль: https://vk.com/" + domain + "\nПостов за последнюю неделю: " + res.size() + "\nСсылки на посты за последнюю неделю:");
        for (Post post : res){
            System.out.println(post.getLink());
            System.out.println(post.getText());
        }
        return res;
    }
}
