package com.bitacademy.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.container.videosystem.Avengers;
import com.bitacademy.container.videosystem.DVDPlayer;
import com.bitacademy.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	// 주입하기 1
	// Bean 생성 메서드를 직접 호출하는 방법
	// 생성자 주입
	@Bean
	public DVDPlayer dvdPlayer() {
		return new DVDPlayer(avengers());
	}
}
