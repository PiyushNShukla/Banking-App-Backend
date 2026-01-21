package com.tddbank.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tddbank.app.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserId(Long userId);
}

