package com.example.discordtibiabot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventReceived extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {


        String contentEvent = event.getMessage().getContentRaw();
        //tutaj jeszcze rola bedzie jesli osoba nie ma roli to tez nie wykonuj
        if(contentEvent.contains("bot"))
        {
            EventCordinator.giveMessageReceivedEvent(event);
        }
    }
}
