package com.example.discordtibiabot.events;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveAll extends ListenerAdapter {

    private VoiceChannel docelowy;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String regex = "bot\\.moveAll\\(([^)]+)\\)";

        String content = event.getMessage().getContentRaw();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);


        //po wywolaniu komendy: bot.moveAll(kanal)
        if(content.matches(regex))
        {
            if(matcher.find())
            {
                String extractedText = matcher.group(1);

                //lista wszystkich kanalow na dc
                List<VoiceChannel> voiceChannelList =  event.getGuild().getVoiceChannels();


                //przydzielanie kanalu docelowego
                for (VoiceChannel voice: voiceChannelList) {
                    if(voice.getName().equals(extractedText))
                    {
                        this.docelowy = voice;
                    }
                }

                //przeszukiwanie kanalow
                for (VoiceChannel voiceChannel: voiceChannelList) {

                    //przeszukuj tylko te kanaly ale nie docelowy
                    if(!voiceChannel.getName().equals(extractedText))
                    {

                        //na kazdym kanale mamy liste uzytkownikow
                        List<Member> memberList = voiceChannel.getMembers();
                        for (Member member : memberList) {

                            //kazdego uzytkownika przerzuc na kanal docelowy
                            event.getGuild().moveVoiceMember(member,docelowy).queue();
                        }



                    }

                }
                
            }
            else
            {
                System.out.println("Nie ma takiego kanalu");
            }
        }




    }
}
