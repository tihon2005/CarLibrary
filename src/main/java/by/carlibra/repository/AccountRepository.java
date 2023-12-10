package by.carlibra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.carlibra.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findById(long id);
	Account findByMail(String mail);
}
