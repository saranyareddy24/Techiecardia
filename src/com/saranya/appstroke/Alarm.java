package com.saranya.appstroke;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import java.io.IOException;
 
public class Alarm extends Activity {
    private MediaPlayer player;
    final Context context=this;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stop);
        play(this, getAlarmSound());
        Button stop = (Button) findViewById(R.id.alarm);
        stop.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                System.exit(0);
                return false;
            }
        });
 
        
    }
 
    private void play(Context context, Uri alert) {
        player = new MediaPlayer();
        try {
            player.setDataSource(context, alert);
            final AudioManager audio = (AudioManager) context
                    .getSystemService(Context.AUDIO_SERVICE);
            if (audio.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
                player.setAudioStreamType(AudioManager.STREAM_ALARM);
                player.prepare();
                player.start();
            }
        } catch (IOException e) {
            Log.e("Error....","Check code...");
        }
    }
 
    private Uri getAlarmSound() {
        Uri alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alertSound == null) {
            alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            if (alertSound == null) {
                alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            }
        }
        return alertSound;
    }
}
 
