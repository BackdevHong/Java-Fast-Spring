package com.company.di;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder(new UrlEncoder());

        String result = encoder.encode("Hello world");

        System.out.println("result = " + result);
    }
}