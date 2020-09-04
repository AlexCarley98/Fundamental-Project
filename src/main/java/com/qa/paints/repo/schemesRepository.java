package com.qa.paints.repo;

import com.qa.paints.domain.schemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface schemesRepository extends JpaRepository<schemes, Long> {
}
