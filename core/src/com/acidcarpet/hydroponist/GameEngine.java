package com.acidcarpet.hydroponist;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.screen.BoxScreen;
import com.acidcarpet.hydroponist.screen.LampScreen;
import com.badlogic.gdx.Game;


public class GameEngine extends Game {



	
	@Override
	public void create () {
	setScreen(new BoxScreen(this));
	new Thread(){
		@Override
		public void run() {
			while (true){
				if(Box.getInstance().getPlant()!=null) {
					Box.getInstance().getPlant().second();
				}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

		}
	}.start();
	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {

	}
}
