package com.tinkoff.edu.repository;

import com.tinkoff.edu.domain.JobHistory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the JobHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Long>, JpaSpecificationExecutor<JobHistory> {}
