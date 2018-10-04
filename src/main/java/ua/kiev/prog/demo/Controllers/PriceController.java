package ua.kiev.prog.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kiev.prog.demo.Service.PriceService;

@Controller
public class PriceController {
    @Autowired
    private PriceService priceService;

    @RequestMapping("/")
    public String getPage (Model model){
        model.addAttribute("stylusPrice", priceService.get("StylusStore"));
        model.addAttribute("royalServiceStorePrice", priceService.get("RoyalStore"));
        model.addAttribute("eStorePrice", priceService.get("EStore"));
        model.addAttribute("recipientMail", priceService.getMail());
        return "page";
    }
    @PostMapping("/alert")
    public String enableAlert (@RequestParam boolean enable, @RequestParam String recipientMail){
        priceService.update();
        priceService.setStatus(enable);
        priceService.setMail(recipientMail);
        priceService.enableMonitoringOfPrice();
//        priceService.alertUser(); //test
        return "redirect:/";
    }
    @GetMapping("/view")
    public String viewPrices (){
        priceService.update();
        return "redirect:/";
    }
}
