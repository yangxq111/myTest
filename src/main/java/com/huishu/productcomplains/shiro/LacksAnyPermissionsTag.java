package com.huishu.productcomplains.shiro;

import org.apache.shiro.subject.Subject;

import com.jagregory.shiro.freemarker.PermissionTag;

/**
 * 扩展标签，不包含所有的权限
 * @author gq
 *
 */
public class LacksAnyPermissionsTag extends PermissionTag{

	@Override
	protected boolean showTagBody(String permissions) {
		Subject subject = getSubject();
		if (subject != null) {
			for (String permission : permissions.split(",")) {
				if (subject.isPermitted(permission.trim())) {
					return false;
				}
			}
		}
		return true;
	}

}
