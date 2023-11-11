package com.example.discordtibiabot;

import com.example.discordtibiabot.events.MoveAll;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordTibiaBotApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DiscordTibiaBotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		JDA jda = JDABuilder.createDefault("MTEwODU0MTU3NzQwMTQ3NTExMg.Gg72pW.np8wT2tmec6dySLFda_IsyeyRjNUGs-4-yIRnc")
				.addEventListeners(new MoveAll())
				.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_WEBHOOKS)
				.build();


	}
}
