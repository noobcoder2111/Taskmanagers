package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.TaskRequest;
import com.example.taskmanagement.dto.TaskResponse;
import java.util.List;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);
    TaskResponse updateTask(Long id, TaskRequest request);
    void deleteTask(Long id);
    TaskResponse getTaskById(Long id);
    List<TaskResponse> getAllTasks(String status, String priority, int page, int size);
}
