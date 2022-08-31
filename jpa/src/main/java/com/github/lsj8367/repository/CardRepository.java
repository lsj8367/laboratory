package com.github.lsj8367.repository;

import com.github.lsj8367.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long>, CardRepositorySupport {

}
