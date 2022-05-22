package com.msstudy.hrwoker.repositories;

import com.msstudy.hrwoker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
