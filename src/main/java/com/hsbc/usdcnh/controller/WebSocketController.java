package com.hsbc.usdcnh.controller;

import com.hsbc.usdcnh.scheduler.RateGenerationScheduler;
import com.hsbc.usdcnh.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class WebSocketController {

    @Autowired
    RateGenerationScheduler rateGenerationScheduler;

    /**
     * This function fetches the current rate every second and sends it to the client side
     */
    @Scheduled(fixedRate = 1000)
    public void sendToClient() {
        WebSocketServer.sendMessage(rateGenerationScheduler.getUSDRate());
    }
}
