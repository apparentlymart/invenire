package uk.co.degeneration.invenire;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WordsMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_words_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.words_main, menu);
		return true;
	}

}
