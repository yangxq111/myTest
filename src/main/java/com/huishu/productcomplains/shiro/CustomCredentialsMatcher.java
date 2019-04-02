package com.huishu.productcomplains.shiro;

import java.security.interfaces.RSAPrivateKey;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义校验密码类
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object tokenCredentials = getUserPassword(token);
		Object accountCredentials = getCredentials(info);
		return equals(tokenCredentials, accountCredentials);
	}

	public String getUserPassword(UsernamePasswordToken token) {
//		String pass = String.valueOf(token.getPassword());
//		Subject currentUser = SecurityUtils.getSubject();
//		// 获取当前用户的私钥
//		Object priKey = currentUser.getSession().getAttribute("privateKey");
//
//		if (priKey == null) {
//			return null;
//		}
//
//		String descrypedPwd = null;
//		try {
//			String decode = RSAUtils.decryptByPrivateKey(pass, (RSAPrivateKey) priKey);
//			descrypedPwd = new StringBuilder(decode).reverse().toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//			//ignore
//			return null;
//		}
//
//		TSysManager admin = sysManagerService.selectByAccount(token.getUsername());
//		byte[] salt = Encodes.decodeHex(admin.getSalt());
//		byte[] hashPassword = Digests.sha1(descrypedPwd.getBytes(), salt,Encodes.HASH_INTERATIONS);
//		return Encodes.encodeHex(hashPassword);
		return null;
	}

}
