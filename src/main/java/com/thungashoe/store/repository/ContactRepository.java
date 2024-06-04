package com.thungashoe.store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thungashoe.store.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> findByOrderByCreatedAtDesc(Pageable pageable);
    Page<Contact> findByOrderByCreatedAtAsc(Pageable pageable);
}
