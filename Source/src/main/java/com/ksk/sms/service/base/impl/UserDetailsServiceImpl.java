package com.ksk.sms.service.base.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ksk.sms.model.dao.entity.UserInfo;
import com.ksk.sms.model.dao.repository.UserInfoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoRepository.getUserInfo(userName);

		if (Objects.isNull(userInfo)) {
			throw new UsernameNotFoundException("User Not Found...");
		}

    	List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantList.add(authority);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails userDetails = 
    		(UserDetails)new User(userInfo.getUser(), encoder.encode(userInfo.getPassword()), grantList);

        return userDetails;
    }

}
