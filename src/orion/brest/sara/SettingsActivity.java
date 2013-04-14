package orion.brest.sara;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class SettingsActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
	}
	
	
}
