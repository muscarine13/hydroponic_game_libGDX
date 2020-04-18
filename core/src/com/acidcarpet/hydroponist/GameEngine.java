package com.acidcarpet.hydroponist;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.screen.donat.DonatResources;
import com.acidcarpet.hydroponist.screen.seedling.SeedlingResources;
import com.acidcarpet.hydroponist.screen.settings.SettingsResources;
import com.acidcarpet.hydroponist.screen.shop.ShopResources;
import com.acidcarpet.hydroponist.storage.TestPack;
import com.acidcarpet.hydroponist.screen.box.BoxResources;
import com.acidcarpet.hydroponist.screen.box.BoxScreen;
import com.acidcarpet.hydroponist.screen.fan.FanResources;
import com.acidcarpet.hydroponist.screen.lamp.LampResources;
import com.acidcarpet.hydroponist.screen.plant.PlantResources;
import com.acidcarpet.hydroponist.screen.pot.PotResources;
import com.acidcarpet.hydroponist.screen.pump.PumpResources;
import com.badlogic.gdx.Game;


public class GameEngine extends Game {


	@Override
	public void create () {

		TestPack.getInstance().set_atlas();

		BoxResources.set_all();
		FanResources.set_all();
		LampResources.set_all();
		PlantResources.set_all();
		PotResources.set_all();
		PumpResources.set_all();
		ShopResources.set_all();
		SeedlingResources.set_all();
		DonatResources.set_all();
		SettingsResources.set_all();


		new Thread(){
			@Override
			public void run() {
				while (true){
					if(Box.getInstance().getPlant()!=null) {
						Box.getInstance().second();
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

		TestPack.getInstance().dispose_atlas();

		BoxResources.dispose_all();
		FanResources.dispose_all();
		LampResources.dispose_all();
		PlantResources.dispose_all();
		PotResources.dispose_all();
		PumpResources.dispose_all();
		ShopResources.dispose_all();
		SeedlingResources.dispose_all();
		DonatResources.dispose_all();
		SettingsResources.dispose_all();

	}
}
