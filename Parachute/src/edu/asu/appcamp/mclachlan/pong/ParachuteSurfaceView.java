package edu.asu.appcamp.mclachlan.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ParachuteSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	
	private GameLoop gameLoop;
	private Paint paint = new Paint();
	private int score = 0;
	private int gameOver = 0;
	private Player player = new Player();
	
	Ball ball = new Ball();

	public ParachuteSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);

		getHolder().addCallback(this);
		
		ball.setX(100);
		ball.setY(100);
		ball.setFillColor(Color.GREEN);
		ball.setVelocityY((float) (Math.random()*50+100));
		ball.setVelocityX((float) (Math.random()*50+50));

		gameLoop = new GameLoop(this);
	}
	
	public void update(long delta){
		final long DELTAS_PER_SEC = 1000000000;
		ball.setX(ball.getX() + (delta * ball.getVelocityX())/DELTAS_PER_SEC);
		ball.setY(ball.getY() + (delta * ball.getVelocityY())/DELTAS_PER_SEC);
		if(ball.getX() > this.getWidth() || ball.getX() < 0){
			ball.setVelocityX(ball.getVelocityX() * (-1));
		}
		if(ball.getY() < 0){
			ball.setVelocityY(ball.getVelocityY() * (-1));
		}
		if(ball.getY() > this.getHeight()){
			gameOver = 1;	
		}
	}

	

	public void render(Canvas canvas) {
		paint.setColor(Color.BLACK);
		canvas.drawPaint(paint);
		ball.draw(canvas);
		if(gameOver == 1){
			gameOver(canvas);
		}
	}
	
	private void gameOver(Canvas canvas) {
		String text = "GAME OVER";
		gameLoop.setRunning(false);
		paint.setColor(Color.BLACK);
		canvas.drawPaint(paint);
		paint.setColor(Color.GREEN);
		canvas.drawText(text, this.getWidth()/2, this.getHeight()/2, paint);
		canvas.drawText("Your score: "+score, this.getWidth()/2, this.getHeight()/2 + 15, paint);
		ball.setX(this.getWidth()/2);
		ball.setY(ball.getRadius()*2);
		ball.setFillColor(Color.GREEN);
		ball.setVelocityY((float) (0));
		ball.setVelocityX((float) (0));
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		player.fire(event.getX(), event.getY());
		
		if(gameOver == 1 && event.getActionMasked() == MotionEvent.ACTION_DOWN){
			gameOver = 0;
			score = 0;
			ball.setVelocityY((float) (Math.random()*50+100));
			ball.setVelocityX((float) (Math.random()*50+50));
			gameLoop.setRunning(true);
		}
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		gameLoop.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		gameLoop.setRunning(false);
		
	}
	
	
	
	
	

}
