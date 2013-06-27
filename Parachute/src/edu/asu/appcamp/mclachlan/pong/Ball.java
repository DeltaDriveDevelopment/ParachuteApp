package edu.asu.appcamp.mclachlan.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Ball {
	private RectF rect = new RectF();
	private float radius = 5;
	private Paint paint = new Paint();
	private float velocityX = 0;
	private float velocityY = 0;
	
	public void setFillColor(int c){
		paint.setColor(c);
	}
	
	public void setRect(RectF rect){
		this.rect = rect;
	}

	public RectF getRect() {
		return rect;
	}

	public void draw(Canvas canvas) {
		canvas.drawCircle(getX(), getY(), getRadius(), paint);
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
		rect.left = rect.centerX() - radius;
		rect.right = rect.left + 2 * radius;
		rect.top = rect.centerY() - radius;
		rect.bottom = rect.top + 2 * radius;
	}
	
	public float getX(){
		return rect.centerX();
	}
	
	public float getY(){
		return rect.centerY();
	}
	
	public void setX(float value){
		rect.left = value - radius;
		rect.right = value + radius;
	}
	
	public void setY(float value){
		rect.top = value - radius;
		rect.bottom = value + radius;
	}

	public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}
}
