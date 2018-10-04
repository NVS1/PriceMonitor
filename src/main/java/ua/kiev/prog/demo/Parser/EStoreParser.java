package ua.kiev.prog.demo.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class EStoreParser implements Parser {
    private String url = "https://estore.ua/iphone-xs-256gb-space-gray/";
    @Override
    public String getPrice() {
        try {
            Document page = Jsoup.parse(new URL(url), 8000);
            Elements elements = page.select("span[class=price]");
            String price = elements.first().text();
            return price;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
