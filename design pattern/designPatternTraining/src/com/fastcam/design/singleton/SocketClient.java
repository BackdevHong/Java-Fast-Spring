package com.fastcam.design.singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient() {

    } // 싱글톤 방식 1번 - 기본 생성자를 private로 막아라.

    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    } // 싱글톤 방식 2, 3번 - GetInstance() 메서드를 static으로 제공하라.

    public void connect() {
        System.out.println("connected");
    }

}
