package com.huishu.productcomplains.shiro;

import org.apache.shiro.subject.Subject;

import com.jagregory.shiro.freemarker.PermissionTag;

/**
 * 扩展标签，具有列出权限中的任意一个
 * @author gq
 */
public class HasAnyPermissionsTag extends PermissionTag {

	public HasAnyPermissionsTag() {

	}

	@Override
	protected boolean showTagBody(String permissions) {
		Subject subject = getSubject();
		if (subject != null) {
			for (String permission : permissions.split(",")) {
				if (subject.isPermitted(permission.trim())) {
					return true;
				}
			}
		}
		return false;
	}

}