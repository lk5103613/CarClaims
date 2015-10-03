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
	private Button  mNextStep;
	private ImageButton mServiceDelete;
	private ImageButton mPartDelete;
	private Button mSaveBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainactivity02);

		mTurnBack = (ImageButton) findViewById(R.id.TurnBack);
		mNextStep = (Button) findViewById(R.id.nextStep);
		mServiceDelete = (ImageButton) findViewById(R.id.serviceDelete);
		mPartDelete = (ImageButton) findViewById(R.id.partDelete);
		mSaveBtn = (Button) findViewById(R.id.saveBTn);

		mTurnBack.setOnClickListener(this);
		mNextStep.setOnClickListener(this);
		mServiceDelete.setOnClickListener(this);
		mPartDelete.setOnClickListener(this);
		mSaveBtn.setOnClickListener(this);


	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.TurnBack:

			Toast.makeText(this, "你现在点击的是返回按钮", Toast.LENGTH_LONG).show();
			break;
		case R.id.nextStep:

			Toast.makeText(this, "你现在点击的是下一步按钮", Toast.LENGTH_LONG).show();
			break;
		case R.id.serviceDelete:

			Toast.makeText(this, "你现在点击的是服务项目区域的删除按钮", Toast.LENGTH_LONG).show();
			break;
		case R.id.partDelete:

			Toast.makeText(this, "你现在点击的是项目材料区域的删除按钮", Toast.LENGTH_LONG).show();
			break;
		case R.id.saveBTn:

			Toast.makeText(this, "你现在点击的是保存按钮", Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}
	}



}
