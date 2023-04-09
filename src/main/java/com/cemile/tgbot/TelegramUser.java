package com.cemile.tgbot;

public class TelegramUser {
    private String chatId;
    private String step;
    private String msg;
    private String fullName;

    public TelegramUser() {
    }

    public String toString() {
        return "TelegramUser{chatId='" + this.chatId + "', step='" + this.step + "', msg='" + this.msg + "', fullName='" + this.fullName + "'}";
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getStep() {
        return this.step;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setChatId(final String chatId) {
        this.chatId = chatId;
    }

    public void setStep(final String step) {
        this.step = step;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }
}
