package fi.yle.sibkompassi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlaySongActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 Log.i("PlaySongActivity", "PlaySongActivity — onCreate");
		super.onCreate(savedInstanceState);
		  // Get the message from the intent
	    Intent intent = getIntent();
	    String songNr = intent.getStringExtra(MainActivity.EXTRA_SONG);
	    Uri video = Uri.parse("android.resource://fi.yle.sibkompassi/raw/sibbe_"+ songNr);
	    VideoView videoPlayer = new VideoView(this);
	    videoPlayer.setVideoURI(video);
	    videoPlayer.setMediaController(new MediaController(this));
	    videoPlayer.start();
	    videoPlayer.requestFocus();
	    
	    setContentView(videoPlayer);
	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}