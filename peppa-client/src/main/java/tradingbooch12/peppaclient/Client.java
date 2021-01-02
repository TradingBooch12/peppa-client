package tradingbooch12.peppaclient;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import tradingbooch12.peppaclient.modules.Modules;
import tradingbooch12.peppaclient.modules.gui.Fps;
import tradingbooch12.peppaclient.modules.render.Bright;

public class Client {
	
	private static Minecraft mc;
	
	public static final String NAME = "Peppa Client";
	public static final String VERSION = "v0.0.1a";
	
	private static List<Modules> modules;
	
	public static boolean chat = false;
	
	public static void start() {
		mc = Minecraft.getInstance();
		
		modules = new ArrayList<>();
		
		register(new Bright());
		register(new Fps());
	}

	public static void register(Modules module) {
		modules.add(module);
	}
	
	public static void keyPressed(int keyCode) {
		if (keyCode == 116) chat = true;
		
		if (!chat) {
			for (Modules m : modules) {
				if (m.getKeyCode() == keyCode) {
					m.toggle();
				}
			}
		}
	}
	
	public static void update() {
		for (Modules m : modules) {
			m.update();
		}
	}
	
	public static void renderGui(MatrixStack stack) {
		for (Modules m : modules) {
			m.renderGui(stack);
		} 
		
		mc.fontRenderer.drawString(stack, Client.NAME + " " + Client.VERSION, 10, mc.getMainWindow().getScaledHeight() - 15, 0xffffff);
	}
	
}
