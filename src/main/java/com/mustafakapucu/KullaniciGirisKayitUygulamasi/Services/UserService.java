package com.mustafakapucu.KullaniciGirisKayitUygulamasi.Services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Models.User;
import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Repository.RoleRepository;
import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public void saveUser(User user) {
		user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
		user.setEnabled(true);
		userRepository.save(user);
	}

}
