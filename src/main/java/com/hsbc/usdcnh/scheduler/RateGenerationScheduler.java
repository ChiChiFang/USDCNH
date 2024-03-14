package com.hsbc.usdcnh.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@EnableScheduling
@Service
public class RateGenerationScheduler {
    double USDRate = 7.8;

    /**
     * This function generates a new rate in the range from 7.8 to 7.9 every second
     */
    @Scheduled(fixedRate = 1000)
    public void generateRate() {
        USDRate = 7.8;
        Random random = new Random();
        USDRate += random.nextDouble() / 10;
    }

    /**
     * This function returns a formatted double of the rate
     * @return a formatted double of the rate
     */
    public String getUSDRate(){
        DecimalFormat rateFormat = new DecimalFormat("#0.0000");
        return rateFormat.format(USDRate);
    }


}
