package edu.asu.appcamp.mclachlan.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player {
	private int ammo = 5;
	private boolean canFire = true;
	private int bullets = 0;
	private Paint paint = new Paint();
	//private ArrayList<Bullet> bulletSprites;

	public void fire(float x, float y) {
		Bullet bullet = new Bullet();
		bullet.<StartFunction>(x, y);
		bullets = bullets ++;
	}
	
	public void draw(Canvas canvas, float cx, float cy){
		paint.setColor(Color.BLACK);
		canvas.drawCircle(cx, cy, 10, paint);
	}
	
	

}
