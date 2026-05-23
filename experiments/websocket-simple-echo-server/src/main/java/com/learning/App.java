package com.learning;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create().start(7070);

        app.get("/", ctx -> ctx.result("Server is Up!") );

        System.out.println("Hello JAVALIN BITCH");

        app.ws("/echo", ws -> {
           ws.onConnect(ctx -> {
            System.out.println("Client Connected Yay!");
           }); //I need to implement constant listening here
           //Update These are event handlers, constant listening is already being
           //done under the hood

           ws.onMessage(ctx -> {
            String message = ctx.message();
            System.out.println("Message Received");
            ctx.send("Returning Message " + message);
           }); //Return the same message


           ws.onClose(ctx -> System.out.println("Closed!")); //Well Stop the constant listening simply
        });
    }
}
