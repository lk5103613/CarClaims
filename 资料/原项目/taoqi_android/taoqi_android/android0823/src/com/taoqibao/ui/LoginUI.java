package com.taoqibao.ui;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.taoqibao.dao.UserDao;
import com.taoqibao.po.UserPO;
import com.taoqibao.tools.CONSTANTS;

public class LoginUI extends Activity {

	private String uid;
	JSONObject jo;

	protected void onResume() {
		if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}
		super.onResume();
	}

	private float density = 0;
	private TextView loginBtn = null;// 登录
	private TextView regBtn = null; // 注册
	private TextView forgetPasswordTextView = null;// 忘记密码
	private EditText mpTv = null;// 账号
	private EditText pwdTv = null;// 密码

	private EditText codeTv;

	private UserPO user;

	TextView registerBtn = null;
	String code;
	String u;
	String p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login);

		// 手机界面标题设置
		TextView textViewTitle = (TextView) findViewById(R.id.tvHeaderTitle);

		codeTv = (EditText) findViewById(R.id.codeTv);

		mpTv = (EditText) findViewById(R.id.mpTv);
		// mpTv.setInputType(InputType.TYPE_CLASS_NUMBER);

		pwdTv = (EditText) findViewById(R.id.pwdTv);
		loginBtn = (TextView) findViewById(R.id.loginBtn);

		// forgetPasswordTextView = (TextView)
		// findViewById(R.id.forget_password);
		loginBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// 隐藏软键盘
				InputMethodManager imManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
				IBinder mBinder = getCurrentFocus().getWindowToken();
				imManager.hideSoftInputFromWindow(mBinder,
						InputMethodManager.HIDE_NOT_ALWAYS);
				if (mpTv.getText().toString() == null
						|| "".equals(mpTv.getText().toString())) {
					Toast toast = Toast.makeText(LoginUI.this, "Email不能为空",
							Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
					return;
				} else if (pwdTv.getText().toString() == null
						|| "".equals(pwdTv.getText().toString())) {
					Toast toast = Toast.makeText(LoginUI.this, "密码不能为空",
							Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
					return;
				}

				new Thread() {
					public void run() {
						try {
							UserDao userDao = new UserDao();
							u = mpTv.getText().toString();
							p = pwdTv.getText().toString();

							code = codeTv.getText().toString();

							jo = userDao.login(code, u, p);// code, String
															// username,String
															// password

							if (jo != null) {
								String  status=jo.getString("status");
								uid = jo.getString("pkId");
								String  idOwnOrg=jo.getString("idOwnOrg");
								loginHandler.sendEmptyMessage(1);
							} else {
								loginHandler.sendEmptyMessage(2);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}.start();

			}
		});

		TaoQiBaoApplication.getInstance().addActivity(this);
		LinearLayout back_btn = (LinearLayout) this
				.findViewById(R.id.setting_title_btn);
		back_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				LoginUI.this.finish();

			}
		});
		ImageView backBtn = (ImageView) this.findViewById(R.id.back_btn);
		backBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				LoginUI.this.finish();

			}
		});

	}

	Handler uploadCart2ServerHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int what = msg.what;

			if (what == 1) {
				LoginUI.this.finish();
			}
		}
	};

	Handler loginHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int what = msg.what;

			if (what == 1) {

				try {

					loginHandler.removeMessages(1);
					SharedPreferences preferences = getSharedPreferences(
							CONSTANTS.USER_INFO, Activity.MODE_PRIVATE);
					SharedPreferences.Editor editor = preferences.edit();
					editor.putString("u", u);

					editor.putString("uid", uid);
					String nickname = jo.getString("nickname");
					if (nickname == null || nickname.length() == 0
							|| "null".equals(nickname)) {
						nickname = u;
					}

					editor.putString("nickname", nickname);

					editor.commit(); // 一定要记得提交

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {

				Toast toast = Toast.makeText(getApplicationContext(),
						"用户名或密码错误", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}

		};
	};

	/**
	 * 获取屏幕的密度
	 */
	private void getDensity() {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		density = metrics.density;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) { // 在指派Touch事件时拦截，由于安卓的Touch事件是自顶而下的，所以Activity是第一响应者
		if (ev.getAction() == MotionEvent.ACTION_DOWN) { // 类型为Down才处理，还有Move/Up之类的
			if (this.getCurrentFocus() != null) { // 获取当前焦点
				CloseSoftInput(getCurrentFocus());
			}
		}
		return super.dispatchTouchEvent(ev); // 继续指派Touch事件，如果这里不执行基类的dispatchTouchEvent，事件将不会继续往下传递
	}

	protected void CloseSoftInput(View view) { // 关闭软键盘
		if (view != null) {
			if (view.getWindowToken() != null) {
				InputMethodManager imm;
				imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(this.getCurrentFocus()
						.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}

}
