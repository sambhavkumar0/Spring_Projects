package com.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bean.Account;
public interface AccountRepository extends JpaRepository<Account, Integer> {
	public List<Account> findByAtmCardCardType(String cardType);
}