package com.github.lsj8367.repository;

import com.github.lsj8367.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
