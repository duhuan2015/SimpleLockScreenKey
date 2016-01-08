package com.example.la;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	private DevicePolicyManager policyManager;
	private ComponentName componentName;
	private static final int MY_REQUEST_CODE = 9999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		policyManager =(DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		componentName = new ComponentName(this, LockReceiver.class);
		if(policyManager.isAdminActive(componentName)){
			policyManager.lockNow();
			finish();
		}else{
			activeManager();
		}	
		setContentView(R.layout.activity_main);
	}
	public void Bind(View v){
		if(componentName != null){
			policyManager.removeActiveAdmin(componentName);
			activeManager();
		}
	}	
	public void onResume(){
		if(policyManager != null && policyManager.isAdminActive(componentName)){
			policyManager.lockNow();
			android.os.Process.killProcess(android.os.Process.myPid());
		}
		super.onResume();
	}
	public void activeManager(){
		Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,componentName);
		intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Ò»¼üËøÆÁ");
		startActivity(intent);	
	}

}
