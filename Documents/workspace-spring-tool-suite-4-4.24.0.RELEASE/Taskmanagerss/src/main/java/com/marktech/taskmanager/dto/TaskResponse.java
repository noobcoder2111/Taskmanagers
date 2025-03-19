package com.marktech.taskmanager.dto;

import com.marktech.taskmanager.entity.Task;

import java.time.LocalDateTime;

public record TaskResponse(Long id, String title, String description, Task.Status status, Task.Priority priority, LocalDateTime createdAt) {}