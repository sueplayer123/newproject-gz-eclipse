package com.example.bottommenu_vp_imgv_tv;

import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class PlatformUtil {
	public static final String PACKAGE_WECHAT = "com.tencent.mm";

	public static boolean isInstallApp(Context context, String app_package) {
		final PackageManager packageManager = context.getPackageManager();
		List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);
		if (pInfo != null) {
			for (int i = 0; i < pInfo.size(); i++) {
				String pn = pInfo.get(i).packageName;
				if (app_package.equals(pn)) {
					return true;
				}
			}
		}
		return false;
	}
}
