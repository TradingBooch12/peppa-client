package tradingbooch12.peppaclient.modules.gui;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import tradingbooch12.peppaclient.modules.Modules;

public class Fps extends Modules {

	public Fps() {
		super("Fps", 104);
		
		this.setToggle(true);
	}

	@Override
	public void renderGui(MatrixStack stack) {
		if (!this.isToggle()) return;
		
		mc.fontRenderer.drawString(stack, "Fps: " + Minecraft.debugFPS, 10, 10, 0xffffff);
	}

}
