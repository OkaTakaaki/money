package jp.ac.fgrope.Money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.fgrope.Money.model.UserBook;

@Repository

public interface UserBookRepository extends JpaRepository<UserBook, Long> {

	UserBook findByUsernameEquals(String username);

}