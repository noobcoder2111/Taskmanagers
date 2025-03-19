package com.marktech.taskmanager.dto;

import com.marktech.taskmanager.entity.Task;

public record TaskRequest(String title, String description, Task.Priority priority) {}