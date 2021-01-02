package tradingbooch12.peppaclient.modules;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;

public class Modules {
	
	protected Minecraft mc;
	
	private String name;
	private int keyCode;
	
	private boolean toggle = false;
	
	public Modules(String name, int keyCode) {
		this.name = name;
		this.keyCode = keyCode;
		
		mc = Minecraft.getInstance();
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void update() {
		
	}
	
	public void renderGui(MatrixStack stack) {
		
	}
	
	public void toggle() {
		toggle = !toggle;
		
		if (toggle) onEnable();
		else onDisable();
	}

	public String getName() {
		return name;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public boolean isToggle() {
		return toggle;
	}

	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}
	
}
