package com.marktech.taskmanager.repository;

import com.marktech.taskmanager.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Derived query method
    Page<Task> findAllByStatusAndPriority(
            Task.Status status,
            Task.Priority priority,
            Pageable pageable
    );
}