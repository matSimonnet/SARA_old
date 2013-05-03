package orion.brest.sara;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends Activity {

	private double max = 20.0;
	private double min = 0.0;
	private double value = 1.0;
	private double step = 0.1;
	
	private EditText editText = null;
	
	private Button upButton = null; 
	private Button downButton = null;
	
	private Button speedAutoCheckBox = null;
	private CheckBox bearingAutoCheckBox = null;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
	    //CheckBox
		speedAutoCheckBox = (Button) findViewById(R.id.speedAutoCheckBox);
		
		
		speedAutoCheckBox.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.w("SPEED", "CHECKED");
				Intent intent = new Intent();
				intent.putExtra(MainActivity.AUTO_TRESHOLD_RESULT, "Coucou");
				setResult(RESULT_OK,intent);
				//finish();
				
			}
		});

		
		
		upButton = (Button)findViewById(R.id.upButton);
		downButton = (Button)findViewById(R.id.downButton);
		editText = (EditText)findViewById(R.id.numberEditText);
		upButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				downButton.setBackgroundResource(R.drawable.timepicker_down_normal);
				upButton.setBackgroundResource(R.drawable.timepicker_up_pressed);
				if (value>=min && value<=max) value = value+step;
				if (value>=max) value = min;
				editText.setText(""+ (Math.floor(value*10))/10);		
			}
		});
		
		downButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				downButton.setBackgroundResource(R.drawable.timepicker_down_pressed);
				upButton.setBackgroundResource(R.drawable.timepicker_up_normal);
				if (value>=min && value<=max) value = value-step;
				if (value<=min) value = max;
				editText.setText(""+ (Math.floor(value*10))/10);		
			}
		});
		
	}
	
	  @Override
	  protected void onResume() {
	    super.onResume();
	    Log.w("SettingsActivity", "onResume");
	  }

	  @Override
	  protected void onPause() {
	    super.onPause();
	    Log.w("SettingsActivity", "onPause");
	  }
	  
	  @Override
	  protected void onStop() {
	    super.onStop();
	    Log.w("SettingsActivity", "onStop");
	  }
	  
		@Override
		protected void onDestroy() {
			super.onDestroy();
			Log.w("SettingsActivity", "onDestroy");
		}
	
	
}
