package com.saranya.appstroke;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Mainpage extends Activity {

	Button login;
	Button register;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
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
		login=(Button) findViewById(R.id.login);
		login.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0)
			{
				 
				Intent intent=new Intent(context,login.class);
				startActivity(intent);
			}	
		});
		register=(Button) findViewById(R.id.register);
		register.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0)
			{
				 
				Intent intent=new Intent(context,register.class);
				startActivity(intent);
			}	
		});
	}


    
}





