package ua.kiev.prog.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.kiev.prog.demo.Service.PriceService;

@Component
@EnableScheduling
public class SchedulingTasks {
    @Autowired
    private PriceService priceService;

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;
    private final long HOUR = MINUTE*60;

    @Scheduled(fixedDelay = HOUR)
    public void priceMonitor(){
        if (priceService.isStatus()){
            priceService.enableMonitoringOfPrice();
        }
    }
}
