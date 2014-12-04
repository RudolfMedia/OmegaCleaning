package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Application;

import com.parse.Parse;
import com.parse.PushService;

/**
 * Created by danRudolf on 12/3/14.
 */
public class OmegaCleaningApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		Parse.initialize(this, "d7ERHwPLPOpiKL04t4XsJ79hD1exMPJJwoQKMLFi", "40tP4wf2lD24BLHJSn1RQM2noweA8eN3Kx1vxLEy");
		PushService.setDefaultPushCallback(this, MainActivity.class);
	}
}
