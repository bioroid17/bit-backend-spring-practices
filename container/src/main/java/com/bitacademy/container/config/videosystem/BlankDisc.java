package com.bitacademy.container.config.videosystem;

import com.bitacademy.container.videosystem.DigitalVideoDisc;

public class BlankDisc implements DigitalVideoDisc {
	private String title;
	private String studio;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	@Override
	public String play() {
		return "Playing Movie "+studio+"'s "+title;
	}

}
