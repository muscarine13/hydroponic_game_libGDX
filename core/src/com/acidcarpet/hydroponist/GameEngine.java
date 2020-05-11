package com.acidcarpet.hydroponist;


import com.acidcarpet.hydroponist.box.Box;
import com.acidcarpet.hydroponist.screen.donat.DonatResources;
import com.acidcarpet.hydroponist.screen.plant.PlantResources;
import com.acidcarpet.hydroponist.screen.seedling.SeedlingResources;
import com.acidcarpet.hydroponist.screen.settings.SettingsResources;
import com.acidcarpet.hydroponist.screen.shop.ShopResources;

import com.acidcarpet.hydroponist.screen.box.BoxResources;
import com.acidcarpet.hydroponist.screen.box.BoxScreen;
import com.acidcarpet.hydroponist.screen.fan.FanResources;
import com.acidcarpet.hydroponist.screen.lamp.LampResources;

import com.acidcarpet.hydroponist.screen.pot.PotResources;

import com.badlogic.gdx.Game;


public class GameEngine extends Game {


	@Override
	public void create() {

		new	Thread() {
			@Override
			public void run () {
				while (true) {
					if (Box.getInstance().getPlant() != null) {
						Box.getInstance().second();
						BoxScreen.update();
						//Box.getInstance().test_info();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}.start();
		setScreen(new BoxScreen(this));

	}








	@Override
	public void render () {
		super.render();


	}
	
	@Override
	public void dispose () {

		ContentPack.dispose_all();

		BoxResources.dispose_all();
		FanResources.dispose_all();
		LampResources.dispose_all();
		PlantResources.dispose_all();
		PotResources.dispose_all();
		ShopResources.dispose_all();
		SeedlingResources.dispose_all();
		DonatResources.dispose_all();
		SettingsResources.dispose_all();

	}
}
