package tradingbooch12.peppaclient;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import tradingbooch12.peppaclient.modules.Modules;
import tradingbooch12.peppaclient.modules.gui.Fps;
import tradingbooch12.peppaclient.modules.gui.Peppa;
import tradingbooch12.peppaclient.modules.gui.Player;
import tradingbooch12.peppaclient.modules.render.Bright;

public class Client {
	
	private static Minecraft mc;
	
	public static final String NAME = "Peppa Client";
	public static final String VERSION = "v0.0.2";
	
	private static List<Modules> modules;
	
	public static boolean chat = false;
	
	private static int nameY;
	
	public static void start() {
		mc = Minecraft.getInstance();
		
		modules = new ArrayList<>();
		
		register(new Bright());
		register(new Fps());
		register(new Player());
		register(new Peppa());
		
	}

	private static void register(Modules module) {
		modules.add(module);
	}
	
	public static void keyPressed(int keyCode) {
		if (keyCode == 116 || keyCode == 47) chat = true;
		
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
		
		nameY = mc.getMainWindow().getScaledHeight() - 15;
		
		mc.fontRenderer.drawString(stack, Client.NAME + " " + Client.VERSION, 10, nameY, 0xffffff);
	}
	
}
