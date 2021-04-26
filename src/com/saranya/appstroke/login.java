package com.saranya.appstroke;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class login extends Activity {

Button login;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        addListenerOnButton();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginpage, menu);
        return true;
    }
    public void addListenerOnButton() {
		// TODO Auto-generated method stub
		
    	final Context context =this;
		login=(Button) findViewById(R.id.logintoapp);
		login.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0)
			{
				 
				Intent intent=new Intent(context,Accelerometer.class);
				startActivity(intent);
			}	
		});
		
	
		}
}

    