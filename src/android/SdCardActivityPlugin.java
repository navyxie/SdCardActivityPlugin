package com.kalengo.weathermeida.plugins;

import java.io.File;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.Environment;

import com.kalengo.weathermeida.util.UrlUtil;

public class SdCardActivityPlugin  extends CordovaPlugin {
	public static String GetPath = "get";
	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {
		UrlUtil.info("navy", "getSdcardPath---" + action);
		if (GetPath.equals(action)) {			
			if(getSDCardPath() == null){ 				
				//todo
				callbackContext.success("");		
			}else{
				//Environment.getExternalStorageDirectory().getAbsolutePath());getExternalStorageDirectory获取外部存储设备的路径 
				callbackContext.success(getSDCardPath());
				//todo
			}
			
			return true;
		}
		return false;
	}
	/**
	 * 
	 * 获取SDCard的目录路径功能
	 */
	private String getSDCardPath() {
		File sdcardDir = null;
		// 判断SDCard是否存在
		boolean sdcardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
		if (sdcardExist) {
			sdcardDir = Environment.getExternalStorageDirectory();
			return sdcardDir.toString();
		} else {
			return null;
		}

	}
}
