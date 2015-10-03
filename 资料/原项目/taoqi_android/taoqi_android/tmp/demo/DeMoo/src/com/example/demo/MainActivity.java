package com.example.demo;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
public class MainActivity extends Activity implements OnClickListener {



	private ImageButton mTurnBack;
	private Button  mFinish;
	private Button mSaveBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainactivity02);

		mTurnBack = (ImageButton) findViewById(R.id.TurnBack);
		mFinish = (Button) findViewById(R.id.finish);
		mSaveBtn = (Button) findViewById(R.id.saveBTn);

		mTurnBack.setOnClickListener(this);
		mFinish.setOnClickListener(this);
		mSaveBtn.setOnClickListener(this);


	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.compensatiopn:

			Toast.makeText(this, "你现在点击的是理赔按钮", Toast.LENGTH_LONG).show();
			break;
		case R.id.finish:

			Toast.makeText(this, "你现在点击的是完成按钮", Toast.LENGTH_LONG).show();
			break;
		case R.id.saveBTn:

			Toast.makeText(this, "你现在点击的是保存按钮", Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}
	}



}
