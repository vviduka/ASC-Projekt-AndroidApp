package com.thenewboston.vjeko;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener {

	Button chkCommand;
	ToggleButton passToggle;
	EditText input;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);

		initiate();

		passToggle.setOnClickListener(this);

		chkCommand.setOnClickListener(this);

	}

	private void initiate() {

		chkCommand = (Button) findViewById(R.id.bResult);
		passToggle = (ToggleButton) findViewById(R.id.tbPass);
		input = (EditText) findViewById(R.id.etCommand);
		display = (TextView) findViewById(R.id.tvResult);

	}

	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.bResult:

			String check = input.getText().toString();
			if (check.contentEquals("left")) {
				display.setGravity(Gravity.LEFT);

			} else if (check.contentEquals("right")) {
				display.setGravity(Gravity.RIGHT);

			} else if (check.contentEquals("center")) {
				display.setGravity(Gravity.CENTER);

			} else if (check.contentEquals("bottom")) {
				display.setGravity(Gravity.BOTTOM);
			} else if (check.contentEquals("blue")) {
				display.setTextColor(Color.BLUE);

			} else if (check.contentEquals("WTF")) {
				Random crazy = new Random();
				display.setText("WTF!!!");
				display.setTextSize(crazy.nextInt(75));
				display.setTextColor(Color.rgb(crazy.nextInt(255),
						crazy.nextInt(255), crazy.nextInt(255)));
				switch (crazy.nextInt(3)) {
				case 0:
					display.setGravity(Gravity.CENTER);
					display.setTextColor(Color.RED);
					break;
				case 1:
					display.setGravity(Gravity.RIGHT);
					display.setTextColor(Color.GREEN);
					break;
				case 2:
					display.setGravity(Gravity.LEFT);
					display.setTextColor(Color.YELLOW);
					break;

				default:
					break;
				}
			} else {
				display.setText("invalid");
				display.setGravity(Gravity.CENTER);
			}

			break;

		case R.id.tbPass:
			if (passToggle.isChecked()) {
				input.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);

			} else {
				input.setInputType(InputType.TYPE_CLASS_TEXT);
			}

		default:
			break;
		}

	}

}
