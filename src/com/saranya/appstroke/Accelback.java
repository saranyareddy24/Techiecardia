package com.saranya.appstroke;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Accelback extends Activity implements SensorEventListener {

	private final Context context = this;

	private float lastX, lastY, lastZ;

	private SensorManager sensorManager;
	private Sensor accelerometer;
     Button b;
   


	private float deltaXMax = 0;
	private float deltaYMax = 0;
	private float deltaZMax = 0;

	private float deltaX = 0;
	private float deltaY = 0;
	private float deltaZ = 0;

	private float vibrateThreshold = 0;

	

	public Vibrator v;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loginpage);
		//initializeViews();
//      addListenerOnButton();
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		vibrateThreshold = accelerometer.getMaximumRange() / 2;
		//initialize vibration
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

	
	}

	/*public void addListenerOnButton() {
		// TODO Auto-generated method stub
		final Context context =this;
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0)
			{
				 
				Intent intent=new Intent(context,Gyroscope.class);
				startActivity(intent);
			}	
		});
		
	}

	public void initializeViews() {
		currentX = (TextView) findViewById(R.id.currentX);
		currentY = (TextView) findViewById(R.id.currentY);
		currentZ = (TextView) findViewById(R.id.currentZ);
		
		
		maxX = (TextView) findViewById(R.id.maxX);
		maxY = (TextView) findViewById(R.id.maxY);
		maxZ = (TextView) findViewById(R.id.maxZ);
	}
*/
	//onResume() register the accelerometer for listening the events
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	//onPause() unregister the accelerometer for stop listening the events
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

       	

		// get the change of the x,y,z values of the accelerometer
		deltaX = Math.abs(lastX - event.values[0]);
		deltaY = Math.abs(lastY - event.values[1]);
		deltaZ = Math.abs(lastZ - event.values[2]);

		// if the change is below 2, it is just plain noise
		if (deltaX < 2)
			deltaX = 0;
		if (deltaY < 2)
			deltaY = 0;
		if ((deltaX>  vibrateThreshold) || (deltaY > vibrateThreshold) || (deltaZ > vibrateThreshold)) {
			v.vibrate(50);
		
		if (deltaX > deltaXMax) {
			deltaXMax = deltaX;
			
		}
		if (deltaY > deltaYMax) {
			deltaYMax = deltaY;
					}
		if (deltaZ > deltaZMax) {
			deltaZMax = deltaZ;
			
		}
		if(deltaX>17 || deltaY>17 || deltaZ>17)
		{
			Intent intent=new Intent(context,Alarm.class);
			startActivity(intent);
			
		
		}
	}

	}
}