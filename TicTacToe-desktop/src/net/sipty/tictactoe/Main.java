package net.sipty.tictactoe;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Tic Tac Toe -- alpha";
		cfg.width = 800;
		cfg.height = 480;
		
		new LwjglApplication(new Tx3(), cfg);
	}
}

// contrast
// electronic superjoy + OST
// towerfall
// tengami
// speedrunner
// deadshot
// titanfall