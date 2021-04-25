package com.xingyun.library.utils;

import android.util.Log;

public class EvenLog {
	private static final String TAG = "EvenLog";

	public static void d(String message) {
		d(TAG, message);
	}

	public static void d(String tag, String message) {
		Log.d(tag, message);
	}

}
