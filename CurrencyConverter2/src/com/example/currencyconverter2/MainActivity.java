package com.example.currencyconverter2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends Activity {

	private EditText text;
	private TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (EditText) findViewById(R.id.editText1);
		result = (TextView) findViewById(R.id.textView2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void calculate(View view) {
		RadioButton usdButton = (RadioButton) findViewById(R.id.radioButton1);
		RadioButton btcButton = (RadioButton) findViewById(R.id.radioButton2);
		RadioButton dgcButton = (RadioButton) findViewById(R.id.radioButton3);
		RadioButton tUSDButton = (RadioButton) findViewById(R.id.radioButton4);
		RadioButton tBTCButton = (RadioButton) findViewById(R.id.radioButton5);
		RadioButton tDGCButton = (RadioButton) findViewById(R.id.radioButton6);

		
		if (text.getText().length() == 0) {
			Toast.makeText(this, "please enter a valid number", Toast.LENGTH_LONG).show();
		} else {
			double inputVal = Double.parseDouble(text.getText().toString());
			if (usdButton.isChecked() && tUSDButton.isChecked()) {
				result.setText(String.valueOf(inputVal));
				
				
			}
			if (btcButton.isChecked() && tBTCButton.isChecked()) {
				result.setText(String.valueOf(inputVal));
			}
			if (dgcButton.isChecked() && tDGCButton.isChecked()) {
				result.setText(String.valueOf(inputVal));
			}
			
			if (usdButton.isChecked() && tBTCButton.isChecked()) {
				result.setText(String.valueOf(usdToBTC(inputVal)));
				usdButton.setChecked(false);
				tBTCButton.setChecked(false);
			}
			if (usdButton.isChecked() && tDGCButton.isChecked()) {
				result.setText(String.valueOf(usdToDGC(inputVal)));
				usdButton.setChecked(false);
				tDGCButton.setChecked(false);
			}
			if (btcButton.isChecked() && tUSDButton.isChecked()) {
				result.setText(String.valueOf(BTCToUSD(inputVal)));
				btcButton.setChecked(false);
				tUSDButton.setChecked(false);
			}
			if (btcButton.isChecked() && tDGCButton.isChecked()) {
				result.setText(String.valueOf(BTCToDGC(inputVal)));
				tDGCButton.setChecked(false);
				btcButton.setChecked(false);
			}
			if (dgcButton.isChecked() && tUSDButton.isChecked()) {
				result.setText(String.valueOf(DGCToUSD(inputVal)));
				dgcButton.setChecked(false);
				tUSDButton.setChecked(false);
			}
			if (dgcButton.isChecked() && tBTCButton.isChecked()) {
				result.setText(String.valueOf(DGCToBTC(inputVal)));
				dgcButton.setChecked(false);
				tBTCButton.setChecked(false);
			}
		}
	}
	
	private double usdToBTC(double inputVal) {
		return (inputVal/852.45);
	}
	private double usdToDGC(double inputVal) {
		return (inputVal*626.74);
	}
	private double BTCToDGC(double inputVal) {
		return (inputVal*534259.62);
	}
	private double BTCToUSD(double inputVal) {
		return (inputVal*852.45);
	}
	private double DGCToBTC(double inputVal) {
		return (inputVal/534259.62);
	}
	private double DGCToUSD(double inputVal) {
		return (inputVal*0.0016);
	}

}
