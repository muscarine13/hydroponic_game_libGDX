package com.acidcarpet.hydroponist;


import com.acidcarpet.hydroponist.box.Box;

import com.acidcarpet.hydroponist.screen.box.BoxScreen;

import com.badlogic.gdx.Game;


public class GameEngine extends Game {

	@Override
	public void create() {
		System.out.println("dfsdfsdfsdfsdf");

		Box.getInstance();


		if(Box.seconds==null){
			Box.seconds = new Thread() {
				@Override
				public void run() {
					while (true) {

						Box.getInstance().second();
						BoxScreen.update();
						System.err.println("second");

						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			};
			Box.seconds.start();
		}

		this.setScreen(new BoxScreen(this));


	}


	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

//		ContentPack.dispose_all();
//		BoxResources.dispose_all();
//		FanResources.dispose_all();
//		LampResources.dispose_all();
//		PlantResources.dispose_all();
//		PotResources.dispose_all();
//		ShopResources.dispose_all();
//		SeedlingResources.dispose_all();
//		DonatResources.dispose_all();
//		SettingsResources.dispose_all();

	}
}
