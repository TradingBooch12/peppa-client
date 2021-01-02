package tradingbooch12.peppaclient.modules.render;

import tradingbooch12.peppaclient.modules.Modules;

public class Bright extends Modules {
	
	private double defaultGamma;
	
	public Bright() {
		super("Bright", 120);
	}

	@Override
	public void onEnable() {
		defaultGamma = 1;
	}

	@Override
	public void onDisable() {
		mc.gameSettings.gamma = defaultGamma;
	}

	@Override
	public void update() {
		if (!this.isToggle()) return;
		
		mc.gameSettings.gamma = 10;
	}

}
