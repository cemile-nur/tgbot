package com.cemile.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@SpringBootApplication
public class TgbotApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(TgbotApplication.class, args);
		String botToken = "5904160373:AAGo7s9C1O7Gmx-BEXOrhci1-X53jD65oak";
		String chatId = "-1001959408146";
		String message = "Merhaba, ben telegram botuyum. ";
		String urlString = "https://api.telegram.org/bot" + botToken +
				"/sendMessage?chat_id=" + chatId + "&text=" + URLEncoder.encode(message, "UTF-8");
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String response = in.readLine();
		in.close();
		System.out.println("Mesaj gönderildi: " + message);
	}
}


