package com.zviproject.testtask.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zviproject.testtask.component.entitys.UserEntity;
import com.zviproject.testtask.component.interfaces.IUser;
import com.zviproject.testtask.security.entitys.SpringSecurityUser;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUser iUser;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = this.iUser.findByName(username);

		if (userEntity == null) {
			throw new UsernameNotFoundException("Illegal username");
		} else {
			return new SpringSecurityUser(userEntity.getId(), userEntity.getName(), userEntity.getPassword(), null,
					AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
		}
	}

}
