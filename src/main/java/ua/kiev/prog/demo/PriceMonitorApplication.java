package ua.kiev.prog.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PriceMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceMonitorApplication.class, args);
    }

    @Bean
    public SchedulingTasks task() {
        return new SchedulingTasks();
    }

}
