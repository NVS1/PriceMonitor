package ua.kiev.prog.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private MailSender mailSender;
    private String mail;
    private boolean status;
    private HashMap<String, Integer> prices = new HashMap<>();

    public Integer get (String name){
        return prices.get(name);
    }
    public void update(){
       prices.put("StylusStore", priceRepository.getPriceStylusStore());
       prices.put("RoyalStore", priceRepository.getPriceRoyalStore());
       prices.put("EStore", priceRepository.getPriceEStore());
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void enableMonitoringOfPrice (){
        System.out.println("Work price Monitor");
        if (priceRepository.getPriceStylusStore()<prices.get("StylusStore")
                || priceRepository.getPriceEStore()<prices.get("EStore")
                || priceRepository.getPriceRoyalStore()<prices.get("RoyalStore")){
            if  (mail!=null)
            alertUser();
            update();
            System.out.println("Sending message");
        }
    }
    public void alertUser (){
        String message = String.format(
                "Hello, Iphone XS became cheaper!!"
        );
        mailSender.sendMail(mail, "buy Iphone XS))", message);
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
