package com.mustafakapucu.KullaniciGirisKayitUygulamasi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

	User findByEmail(String email);
}
