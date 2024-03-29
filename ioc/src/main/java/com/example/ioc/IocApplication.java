package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocApplication.class, args);
		ApplicationContext context = ApplicationContextProvider.getContext();

		Encoder encoder = context.getBean("urlEncode", Encoder.class);
		String url = "www.naver.com/user/1";
		String result = encoder.encode(url);
		System.out.println("result = " + result);
	}

}

@Configuration(enforceUniqueMethods = false)
class AppConfig {

	@Bean("base64Encode")
	public Encoder encoder(Base64Encoder base64Encoder) {
		return new Encoder(base64Encoder);
	}

	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder) {
		return new Encoder(urlEncoder);
	}
}
