package com.marktech.taskmanager.controller;

import com.marktech.taskmanager.dto.TaskRequest;
import com.marktech.taskmanager.dto.TaskResponse;
import com.marktech.taskmanager.entity.Task;
import com.marktech.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponse> getTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Task.Status status,
            @RequestParam(required = false) Task.Priority priority) {
        return taskService.getTasks(page, size, status, priority);
    }
}