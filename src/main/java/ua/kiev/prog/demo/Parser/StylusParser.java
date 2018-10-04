package ua.kiev.prog.demo.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class StylusParser implements Parser {
    private String url = "https://stylus.ua/iphone-xs-256gb-space-gray-p397913c170.html";
    @Override
    public String getPrice() {
        try {
            Document page = Jsoup.parse(new URL(url), 8000);
            Elements elements = page.select("div[class=regular-price]");
            String price = elements.first().text();
            return price;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
