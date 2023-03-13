package com.fastcam.design;

import com.fastcam.design.adapter.*;
import com.fastcam.design.decorator.*;
import com.fastcam.design.facade.Ftp;
import com.fastcam.design.facade.Reader;
import com.fastcam.design.facade.SftpClient;
import com.fastcam.design.facade.Writer;
import com.fastcam.design.observer.Button;
import com.fastcam.design.observer.IButtonListener;
import com.fastcam.design.proxy.Browser;
import com.fastcam.design.proxy.BrowserProxy;
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

        System.out.println();

        // Proxy
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        System.out.println(" ");
        BrowserProxy browserProxy = new BrowserProxy("www.daum.net");
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();

        System.out.println();
        // Decorator
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

        System.out.println();

        // observer
        Button button = new Button("버튼");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메시지 전달 : click1");
        button.click("메시지 전달 : click2");
        button.click("메시지 전달 : click3");
        button.click("메시지 전달 : click4");

        System.out.println();
        // Facade

        // facade 미적용
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        System.out.println();
        // facade 적용
        SftpClient sftpClient = new SftpClient("www.bar.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}