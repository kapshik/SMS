package com.ksk.sms.service.common.impl;

import java.util.Collection;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ksk.sms.dao.entity.UserInfo;
import com.ksk.sms.dao.repository.UserInfoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoRepository.getUserInfo(userName);
		if (Objects.isNull(userInfo)) {
	        userInfo = new UserInfo();
	        userInfo.setUsername("Test");
	        userInfo.setPassword("PASS");
//			throw new UsernameNotFoundException("User Not Found...");
		}

    	Collection<GrantedAuthority> grantList = getAuthorityList(userInfo.getRole());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        SmsUserDetails smsUserDetails = new SmsUserDetails(userInfo.getUsername(), encoder.encode(userInfo.getPassword()), grantList);
        
        return (UserDetails)smsUserDetails;
    }

    private Collection<GrantedAuthority> getAuthorityList(String inRole) {
        if(inRole.equals("ROLE_ADMIN")){
            return AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
        } else {
            return AuthorityUtils.createAuthorityList("ROLE_USER");
        }
    }
}
