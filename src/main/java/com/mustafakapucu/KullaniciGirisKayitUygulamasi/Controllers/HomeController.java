package com.mustafakapucu.KullaniciGirisKayitUygulamasi.Controllers;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Dtos.ServiceResult;
import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Dtos.UserDto;
import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Forms.UserFormModel;
import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Models.User;
import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Services.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register")
	public ServiceResult register(@RequestBody UserFormModel model) {

		User user = new User();
		user.setEmail(model.getEmail());
		user.setEnabled(model.isEnabled());
		user.setFirstName(model.getFirstName());
		user.setLastName(model.getLastName());
		user.setPassword(model.getPassword());
		user.setUsername(model.getUsername());

		userService.saveUser(user);

		User savedUser = userService.findByUsername(user.getUsername());

		UserDto result = new UserDto();
		result.setSuccess(true);
		result.setMessage("başarılı");
		result.setUsername(savedUser.getUsername());

		return result;
	}

}
