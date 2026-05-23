package com.learning;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create().start(7070);

        app.get("/", ctx -> ctx.result("Server is Up!") );

        System.out.println("Hello JAVALIN BITCH");
    }
}
