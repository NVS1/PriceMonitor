package ua.kiev.prog.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.demo.Parser.Parser;

@Repository
public class PriceRepository {
    @Autowired
    @Qualifier("stylusParser")
    private Parser stylusParser;

    @Autowired
    @Qualifier("royalServiceStoreParser")
    private Parser royalServiceStoreParser;

    @Autowired
    @Qualifier("EStoreParser")
    private Parser eStoreParser;

    public Integer getPriceStylusStore(){
        String price = stylusParser.getPrice();
        price = price.substring(0, price.indexOf('г'));
        String result = price.replaceAll("\\s", "");
        return Integer.parseInt(result);
    }
    public Integer getPriceRoyalStore(){
        String price = royalServiceStoreParser.getPrice();
        price = price.substring(0, price.indexOf('г'));
        String result = price.replaceAll("\\s", "");
        return Integer.parseInt(result);
    }
    public Integer getPriceEStore(){
        String price = eStoreParser.getPrice();
        price = price.substring(0, price.indexOf('г'));
        String result = price.replaceAll("[\\s|\\u00A0]+", "");
        return Integer.parseInt(result);
    }

}
