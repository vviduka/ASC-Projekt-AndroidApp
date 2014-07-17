package com.thenewboston.vjeko;

import javax.crypto.NullCipher;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "startingPoint", "TextPlay", "Email", "example3",
			"example4", "example5", "example6" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_expandable_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		String ourPosition = classes[position];
		Class ourClass = null;
		super.onListItemClick(l, v, position, id);

		try {
			ourClass = Class.forName("com.thenewboston.vjeko." + ourPosition);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Intent ourIntent = new Intent(Menu.this, ourClass);
		startActivity(ourIntent);

	}
}