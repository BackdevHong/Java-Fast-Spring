package com.fastcam.design;

import com.fastcam.design.adapter.*;
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

        System.out.println();



        // adapter pattern
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V adapter2 = new SocketAdapter(airConditioner);
        connect(adapter2);
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}