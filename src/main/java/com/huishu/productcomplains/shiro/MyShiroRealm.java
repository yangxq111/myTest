package com.huishu.productcomplains.shiro;

import java.io.Serializable;
import java.util.Objects;

import com.huishu.productcomplains.model.TSysManager;
import com.huishu.productcomplains.service.SysManagerService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gq
 */

public class MyShiroRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SysManagerService sysManagerService;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		logger.info("doGetAuthenticationInfo +" + authenticationToken.toString());

		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String userName = token.getUsername();
		TSysManager admin = sysManagerService.selectByAccount(userName);
		if (admin != null) {
			ShiroUser shiroUser = new ShiroUser(
					admin.getId().longValue(),
					admin.getAdminAccount(),
					admin.getAdminRealname());
			AuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser, admin.getPassword(), getName());
			return info;
	}
		throw new AuthenticationException("用户名或密码错误！");

	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
	
	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		private Long id;
		private String adminAccount;
		private String adminRealname;
		
		public ShiroUser(Long id, String adminAccount, String adminRealname) {
			this.id = id;
			this.adminAccount = adminAccount;
			this.adminRealname = adminRealname;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getAdminAccount() {
			return adminAccount;
		}

		public void setAdminAccount(String adminAccount) {
			this.adminAccount = adminAccount;
		}

		public String getAdminRealname() {
			return adminRealname;
		}

		public void setAdminRealname(String adminRealname) {
			this.adminRealname = adminRealname;
		}
		
		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return adminAccount;
		}

		/**
		 * 重载hashCode,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(adminAccount);
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ShiroUser other = (ShiroUser) obj;
			if (adminAccount == null) {
				if (other.adminAccount != null) {
					return false;
				}
			} else if (!adminAccount.equals(other.adminAccount)) {
				return false;
			}
			return true;
		}	
	}

}
