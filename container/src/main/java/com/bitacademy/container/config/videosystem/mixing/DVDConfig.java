package com.bitacademy.container.config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.container.config.videosystem.BlankDisc;
import com.bitacademy.container.videosystem.Avengers;
import com.bitacademy.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDConfig {
	
	@Bean
	public DigitalVideoDisc avenger() {
		return new Avengers();
	}
	
	@Bean
	public DigitalVideoDisc avengerInfinityWar() {
		BlankDisc dvd = new BlankDisc();
		dvd.setTitle("Avengers Infinity War");
		dvd.setStudio("MARVEL");
		return dvd;
	}
}
