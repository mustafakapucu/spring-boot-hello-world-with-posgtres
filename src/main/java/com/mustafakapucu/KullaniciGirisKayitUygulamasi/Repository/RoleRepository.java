package com.mustafakapucu.KullaniciGirisKayitUygulamasi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mustafakapucu.KullaniciGirisKayitUygulamasi.Models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);
}
