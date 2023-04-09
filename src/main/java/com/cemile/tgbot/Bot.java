package com.cemile.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot  extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        }



    public String getBotUsername() {
        return "CNKtelegramBot";
    }

    public String getBotToken() {
        return "5904160373:AAGo7s9C1O7Gmx-BEXOrhci1-X53jD65oak";
    }


}
