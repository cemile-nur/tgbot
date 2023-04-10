package com.cemile.tgbot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelegramUser {
    private String chatId;
    private String step;
    private String msg;
    private String fullName;

    public String toString() {
        return "TelegramUser{chatId='" + this.chatId + "', step='" + this.step + "', msg='" + this.msg + "', fullName='" + this.fullName + "'}";
    }


}
