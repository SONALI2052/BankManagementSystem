package com.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.main.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

