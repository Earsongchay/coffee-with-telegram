package org.example.coffeewithtelegram.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyTelegramBot {
    @Value(value = "${telegram.token}")
    private String token;
    @Value(value = "${chat_id}")
    private long chat_id;

    private TelegramBot bot;

    public SendResponse sendResponse(String msg) {
        if (bot == null) {
            bot = new TelegramBot(token);
        }
        SendResponse send = bot.execute(new SendMessage(chat_id, msg));
        return send;
    }
}
