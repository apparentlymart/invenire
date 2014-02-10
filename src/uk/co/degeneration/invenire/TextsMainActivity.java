package uk.co.degeneration.invenire;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ListView;

public class TextsMainActivity extends Activity {
	DrawerLayout drawerLayout;

	abstract class NavigationItem {
		public abstract View getView(ViewGroup parent);
	}
	
	public class NavigationOption extends NavigationItem {
		String caption;
		
		public NavigationOption(String caption) {
			this.caption = caption;
		}
		
		public String getCaption() {
			return this.caption;
		}
		
		@Override
		public View getView(ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) TextsMainActivity.this.getSystemService(
			    Context.LAYOUT_INFLATER_SERVICE
			);
			View view = inflater.inflate(R.layout.navigation_option, parent, false);
			TextView captionView = (TextView) view.findViewById(R.id.caption);
			captionView.setText(this.getCaption());
			return view;	
		}
	}
	
	public class NavigationHeading extends NavigationItem {
		String caption;
		
		public NavigationHeading(String caption) {
			this.caption = caption;
		}

		public String getCaption() {
			return this.caption;
		}
		
		@Override
		public View getView(ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) TextsMainActivity.this.getSystemService(
			    Context.LAYOUT_INFLATER_SERVICE
			);
			View view = inflater.inflate(R.layout.navigation_heading, parent, false);
			TextView captionView = (TextView) view.findViewById(R.id.caption);
			captionView.setText(this.getCaption());
			return view;	
		}
	}
	
	public class NavigationArrayAdapter extends android.widget.ArrayAdapter<NavigationItem> {

		public NavigationArrayAdapter(NavigationItem[] options) {
			super(TextsMainActivity.this, android.R.layout.simple_list_item_1, options);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			NavigationItem item = this.getItem(position);
			return item.getView(parent);
		}
		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texts_main);
        
        ListView navDrawerList = (ListView) findViewById(R.id.nav_drawer);
        NavigationItem[] navDrawerItems = new NavigationItem[8];
        navDrawerItems[0] = new NavigationOption(getString(R.string.nav_favorites));
        navDrawerItems[1] = new NavigationOption(getString(R.string.nav_authors));
        navDrawerItems[2] = new NavigationOption(getString(R.string.nav_works));
        navDrawerItems[3] = new NavigationHeading(getString(R.string.nav_categories));
        navDrawerItems[4] = new NavigationOption(getString(R.string.category_prose));
        navDrawerItems[5] = new NavigationOption(getString(R.string.category_drama));
        navDrawerItems[6] = new NavigationOption(getString(R.string.category_poetry));
        navDrawerItems[7] = new NavigationOption(getString(R.string.category_medical));
        navDrawerList.setAdapter(
        	new NavigationArrayAdapter(navDrawerItems)
        );
        
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(android.view.Gravity.LEFT);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.text_actions, menu);
        return true;
    }
    
}
