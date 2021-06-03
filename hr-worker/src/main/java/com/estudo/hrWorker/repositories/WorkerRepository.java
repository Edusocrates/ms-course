package com.estudo.hrWorker.repositories;

import com.estudo.hrWorker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
