package com.txt.eshopperboot.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.txt.eshopperboot.dto.User;
import com.txt.eshopperboot.repositories.UserRepository;
import com.txt.eshopperboot.util.MyUserDetail;

@Service
public class MyUserDetailService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			logger.error("User not found");
			throw new UsernameNotFoundException("User not found");
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));

		MyUserDetail myUserDetail = new MyUserDetail(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		BeanUtils.copyProperties(user, myUserDetail);
		
//		System.out.println("AA:"+myUserDetail.getUsername());
//		System.out.println("AA:"+myUserDetail.getPassword());
//		System.out.println("AA:"+myUserDetail.getId());
//		System.out.println("AA:"+myUserDetail.getEmail());
//		System.out.println("AA:"+myUserDetail.getPhone());
//		System.out.println("AA:"+user.getPhone());

		return myUserDetail;
	}

}
