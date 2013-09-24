package net.sipty.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;


public class SetupScreen implements Screen, InputProcessor {

	// declarations
	private final Tx3 game;
	private OrthographicCamera camera;
	private Texture bgImage;
	private int posX, posY;
	
	// constructor
	public SetupScreen(final Tx3 gam) {
		game = gam;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		// load the background image
		bgImage = new Texture(Gdx.files.internal("setup.png"));
		
		new Mech();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		// batch begin
		game.batch.begin();
			// background
			game.batch.draw(bgImage, 0,0);
			// text
			game.font.draw(game.batch, "", 300, 350);
			game.font.draw(game.batch, "Pick a side to start", 340, 470);
			game.font.draw(game.batch, "ICE", 120, 450);
			game.font.draw(game.batch, "FIRE", 680, 450);
			game.font.draw(game.batch, "Difficulty:", 360, 430);
			game.font.draw(game.batch, "Kittens are cute", 360, 410);
			game.font.draw(game.batch, "I hate my parents", 360, 390);
			game.font.draw(game.batch, "I have friends", 360, 370);
				// difficulty selected
				switch(Mech.getAi()) {
					case 0:
						game.font.draw(game.batch, "+", 350, 370);
						break;
					case 1:
						game.font.draw(game.batch, "+", 350, 410);
						break;
					case 2:
						game.font.draw(game.batch, "+", 350, 390);
						break;
				}
			// mouse coords info
			posX = Gdx.input.getX();
			posY = Gdx.input.getY();
			game.font.draw(game.batch,  Integer.toString(posX)+", ", 650, 470);
			game.font.draw(game.batch,  Integer.toString(posY), 680, 470);
		// batch end
		game.batch.end();
	}

	// user input
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		// Difficulties:
		// easy
		if(screenX>360 && screenX<425 && screenY>70 && screenY<86) { 
			Mech.setAi(1);
		}
		// hard
		if(screenX>360 && screenX<425 && screenY>90 && screenY<107) { 
			Mech.setAi(2);
		}
		// local
		if(screenX>360 && screenX<425 && screenY>108 && screenY<129) { 
			Mech.setAi(0);
		}
		
		
		// Sides:
		// ice
		if(screenX>20 && screenX<300 && screenY>10 && screenY<470) { 
			Mech.setSide(1);
			game.setScreen(new GameScreen(game));
		}
		// fire
		if(screenX>520 && screenX<800 && screenY>10 && screenY<470) {
			Mech.setSide(2);
			game.setScreen(new GameScreen(game));
		}
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}
	
	@Override
	public void show() {      
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void hide() {
        Gdx.input.setInputProcessor(null);		
	}

	@Override
	public void dispose() {
        Gdx.input.setInputProcessor(null);		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	
	// input processor stuffs
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
