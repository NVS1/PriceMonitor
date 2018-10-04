package ua.kiev.prog.demo.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class RoyalServiceStoreParser implements Parser {
    String url = "https://royal-service.store/iphone/iphone-xs/apple-iphone-xs-256gb-space-gray-xs256spacegray/";
    @Override
    public String getPrice() {
        try {
            Document page = Jsoup.parse(new URL(url), 8000);
            Elements elements = page.select("div[class=productCard-price]");
            String price = elements.text();
            return price;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
