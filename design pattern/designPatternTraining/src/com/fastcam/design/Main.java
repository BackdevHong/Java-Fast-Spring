package com.fastcam.design;

import com.fastcam.design.singleton.AClass;
import com.fastcam.design.singleton.BClass;
import com.fastcam.design.singleton.SocketClient;

public class Main {
    public static void main(String[] args) {
        // singleton pattern

        AClass aClass = new AClass();
        BClass bClass = new BClass();

        SocketClient aClient = aClass.getSocketClient();
        SocketClient bClient = bClass.getSocketClient();

        System.out.println("두개의 객채가 동일할까요?");
        System.out.println(aClient.equals(bClient));
    }
}