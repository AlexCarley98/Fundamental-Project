package com.qa.paints.repo;

import com.qa.paints.domain.paints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paintsRepository extends JpaRepository<paints, Long> {
}
