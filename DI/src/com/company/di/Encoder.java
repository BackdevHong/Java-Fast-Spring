package com.company.di;

public class Encoder {
    IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }
}
