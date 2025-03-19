package com.marktech.taskmanager.service;

import com.marktech.taskmanager.dto.TaskRequest;
import com.marktech.taskmanager.dto.TaskResponse;
import com.marktech.taskmanager.entity.Task;
import com.marktech.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse createTask(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setPriority(request.priority());
        task.setStatus(Task.Status.PENDING);

        task = taskRepository.save(task);
        return mapToResponse(task);
    }

    public List<TaskResponse> getTasks(int page, int size, Task.Status status, Task.Priority priority) {
        Page<Task> tasksPage = taskRepository.findAllByStatusAndPriority(status, priority, PageRequest.of(page, size));
        return tasksPage.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private TaskResponse mapToResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getCreatedAt()
        );
    }
}