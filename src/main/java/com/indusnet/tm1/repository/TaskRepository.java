package com.indusnet.tm1.repository;

import com.indusnet.tm1.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface TaskRepository extends JpaRepository<Tasks,Integer> {
}
