package com.hsbc.usdcnh.server;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Logger
@Service
@ServerEndpoint("/get-rate")
public class WebSocketServer {

    private static Session session;

    /**
     * This function creates a new session when the socket is initialized
     * @param newSession a Session object
     */
    @OnOpen
    public void onOpen(Session newSession) {
        session = newSession;
    }

    /**
     * This function prints a message when the socket is closed
     */
    @OnClose
    public void onClose() {
        System.out.println("Socket closed");
        try {
            session.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This function sends a String to the client side for users to view
     * @param message A string that is sent to the client side
     */
    public static void sendMessage(String message) {
        try{
            session.getBasicRemote().sendText(message);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
