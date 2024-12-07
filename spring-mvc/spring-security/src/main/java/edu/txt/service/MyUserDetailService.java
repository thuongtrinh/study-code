package edu.txt.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.txt.entity.RoleEntity;
import edu.txt.entity.UserEntity;
import edu.txt.repository.UserRepository;
import edu.txt.utils.MyUserDetail;

@Service
public class MyUserDetailService implements UserDetailsService { // UserDetailsService của spring security

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findOneByUserName(username);
        if (user == null) {
            logger.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (RoleEntity role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        MyUserDetail myUserDetail = new MyUserDetail(username, user.getPassword(), true, true, true, true, authorities);
        BeanUtils.copyProperties(user, myUserDetail);

        return myUserDetail;
    }

}
