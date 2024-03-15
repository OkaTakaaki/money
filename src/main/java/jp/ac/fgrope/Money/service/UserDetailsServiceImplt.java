package jp.ac.fgrope.Money.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.ac.fgrope.Money.model.UserBook;
import jp.ac.fgrope.Money.repository.UserBookRepository;

@Service

public class UserDetailsServiceImplt implements UserDetailsService {

	@Autowired

	private UserBookRepository userBookRepository; // ユーザモデルのRepository

	/**

	 * ユーザの検索を行う

	 */

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("serach name : " + username);

		UserBook user = this.userBookRepository.findByUsernameEquals(username); // emailで検索するので「EmailEquals」としている

		System.out.println(user.toString());

		return user;

	}

}