package edu.asu.appcamp.mclachlan.pong;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread {
	private ParachuteSurfaceView surface;
	private Boolean running;

	public synchronized Boolean getRunning() {
		return running;
	}

	public synchronized void setRunning(Boolean running) {
		this.running = running;
	}

	public GameLoop(ParachuteSurfaceView surface) {
		this.surface = surface;
	}

	@Override
	public void run() {
		setRunning(true);
		while (true) {
			long previousTime = System.nanoTime();
			long currentTime = previousTime;

			SurfaceHolder holder = surface.getHolder();

			while (getRunning()) {

				long delta = currentTime - previousTime;
				surface.update(delta);
				Canvas canvas = holder.lockCanvas();
				if (canvas != null) {
					surface.render(canvas);
					holder.unlockCanvasAndPost(canvas);
				}
				previousTime = currentTime;
				currentTime = System.nanoTime();

				try {
					sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

}
