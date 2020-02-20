package com.acidcarpet.hydroponist;

import com.acidcarpet.hydroponist.screen.BoxScreen;
import com.acidcarpet.hydroponist.screen.LampScreen;
import com.badlogic.gdx.Game;


public class GameEngine extends Game {
	
	@Override
	public void create () {
	setScreen(new LampScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
