package edu.asu.appcamp.mclachlan.pong;

import edu.asu.appcamp.mclachlan.pong.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class ParachuteActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(new ParachuteSurfaceView(this, null));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pong, menu);
		return true;
	}


}
