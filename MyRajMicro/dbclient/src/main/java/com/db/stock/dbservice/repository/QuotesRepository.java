package com.db.stock.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.stock.dbservice.model.Quote;

import java.util.List;
@Repository
public interface QuotesRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findByUserName(String username);
}
