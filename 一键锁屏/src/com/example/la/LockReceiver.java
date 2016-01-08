package com.example.la;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

public class LockReceiver  extends DeviceAdminReceiver{

	@Override
	public void onDisabled(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onDisabled(context, intent);
		System.out.print("disable!!!");
	}

	@Override
	public void onEnabled(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onEnabled(context, intent);
		System.out.print("enable!!!");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		System.out.print("receive!!!");
	}
	

}
