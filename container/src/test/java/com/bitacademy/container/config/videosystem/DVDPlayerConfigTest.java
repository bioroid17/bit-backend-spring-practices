package com.bitacademy.container.config.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.videosystem.DVDPlayer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={DVDPlayerConfig.class})
public class DVDPlayerConfigTest {

	@Autowired
	@Qualifier
	private DVDPlayer dvdPlayer01;

	@Autowired
	@Qualifier
	private DVDPlayer dvdPlayer02;

	@Autowired
	@Qualifier
	private DVDPlayer dvdPlayer03;
	
	@Test
	public void testDVDPlayer01NotNull() {
		assertNotNull(dvdPlayer01);
	}
	
	@Test
	public void testDVDPlayer02NotNull() {
		assertNotNull(dvdPlayer02);
	}
	
	@Test
	public void testDVDPlayer03NotNull() {
		assertNotNull(dvdPlayer03);
	}
	
	@Test
	public void testPlay01() {
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer01.play());
	}
	
	@Test
	public void testPlay02() {
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer02.play());
	}
	
	@Test
	public void testPlay03() {
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer03.play());
	}
}
