package me.byaz.launcher.telegram;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class TelegramBot extends TelegramLongPollingBot {

    /* This method is run every time the bot receives something */

    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().getFrom().getId().equals(209363200)){
            return;
        }
    }

    /* This is the getter of the bot name */

    @Override
    public String getBotUsername() {
        return "Argus";
    }

    /* This is the getter of the bot token */

    @Override
    public String getBotToken() {
        return "779385958:AAFekl0z1mbhOWw9S-t7eLTDIEtyY2PiEqk";
    }
}
