package com.example.discordtibiabot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class EventCordinator {


    public static void giveMessageReceivedEvent(MessageReceivedEvent event)
    {
        if(event.getMessage().getContentRaw().contains("moveAll"))
        {
            //podaj event do klasy obslugujacej MoveAll...
        }
        //else ta klasa to to

    }



}
