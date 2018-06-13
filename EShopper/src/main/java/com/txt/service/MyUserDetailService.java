package com.txt.service;

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

import com.txt.dao.UserDAO;
import com.txt.dto.User;
import com.txt.util.MyUserDetail;

public class MyUserDetailService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("LOGIN");
		if (userDAO != null) {
			System.out.println("userDAO is other null");
		} else {
			System.out.println("userDAO is null");
		}
		User user = userDAO.getUserByUserName(username);
		if (user == null) {
			System.out.println("User not found 2222");
			logger.error("User not found");
			throw new UsernameNotFoundException("User not found");
		} else {
			System.out.println("Exist user 2222");
		}

		System.out.println("USER:" + user.getUsername() + " PASS:" + user.getPassword());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));

		MyUserDetail myUserDetail = new MyUserDetail(user.getUsername(), user.getPassword(), true, true, true, true,
				authorities);
		BeanUtils.copyProperties(user, myUserDetail);
		System.out.println(myUserDetail.getUsername());
		System.out.println(myUserDetail.getPassword());
		System.out.println(myUserDetail.getId());
		System.out.println(myUserDetail.getEmail());

		return myUserDetail;
	}

}
