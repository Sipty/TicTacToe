package net.sipty.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen implements Screen, InputProcessor {
	
	// declarations
	public static Tx3 game;
	private OrthographicCamera camera;
	private Texture board;
	private int posX, posY;	// mouse coord info
				// coordinates for the box array (used in Mech.tick(), the drawing method)
	public static int	x1=145, x2=335, x3=530, y1=342, y2=180, y3=17;	
	//TODO: PLEASE, IN THE NAME OF EVERYTHING - MAKE THESE COORDS PRETTIER.
	// constructor
	public GameScreen(final Tx3 gam) {
		GameScreen.game = gam;
		
		//camera stuffs
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);
		
		// load textures
		board = new Texture(Gdx.files.internal("board.png"));
		
		new Mech();
		
		// box array coords
		x1 = 145;	y1 = 342; 
		x2 = 335;	y2 = 180;
		x3 = 530;	y3 = 17;
	}

	@Override
	public void render(float delta) {
		// gl and camera stuffs
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		// batch begin
			game.batch.begin();
			game.batch.draw(board, 0,0);
			// mouse coords info
			posX = Gdx.input.getX();
			posY = Gdx.input.getY();
			game.font.draw(game.batch,  Integer.toString(posX)+", ", 650, 470);
			game.font.draw(game.batch,  Integer.toString(posY), 680, 470);
			Mech.tick();
			if(!Mech.getNoWin()) {
				if(Mech.getWinnerIs()==1)
					game.font.draw(game.batch, "Winner is: ICE", 690, 25);
				else if(Mech.getWinnerIs()==2)
					game.font.draw(game.batch, "Winner is: FIRE", 690, 25);
				else
					game.font.draw(game.batch, "It's a DRAW!", 690, 25);
					
			}
		// batch end
		game.batch.end();
				
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
	// 1st row
		// 1
		if(screenX>120 && screenX<290 && screenY>0 && screenY<155)
			Mech.setBox(1, x1, y1);
		// 2
		if(screenX>290 && screenX<500 && screenY>0 && screenY<155)
			Mech.setBox(2, x2, y1);
		// 3
		if(screenX>500 && screenX<680 && screenY>0 && screenY<155)
			Mech.setBox(3, x3, y1);
		
	// 2nd row
		// 4
		if(screenX>120 && screenX<290 && screenY>155 && screenY<325)
			Mech.setBox(4, x1, y2);
		// 5
		if(screenX>290 && screenX<500 && screenY>155 && screenY<325)
			Mech.setBox(5, x2, y2);
		// 6
		if(screenX>500 && screenX<680 && screenY>155 && screenY<325)
			Mech.setBox(6, x3, y2);
		
	// 3d row
		// 7
		if(screenX>120 && screenX<290 && screenY>325 && screenY<480)
			Mech.setBox(7, x1, y3);
		// 8
		if(screenX>290 && screenX<500 && screenY>325 && screenY<480)
			Mech.setBox(8, x2, y3);
		// 9
		if(screenX>500 && screenX<680 && screenY>325 && screenY<480)
			Mech.setBox(9, x3, y3);
		
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
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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
