package com.marktech.taskmanager.util;

import com.marktech.taskmanager.entity.Task;

import java.util.PriorityQueue;

public class TaskScheduler {

    private final PriorityQueue<Task> taskQueue;

    public TaskScheduler() {
        this.taskQueue = new PriorityQueue<>((t1, t2) -> {
            if (t1.getPriority() == t2.getPriority()) {
                return t1.getCreatedAt().compareTo(t2.getCreatedAt());
            }
            return t1.getPriority().compareTo(t2.getPriority());
        });
    }

    public void addTask(Task task) {
        taskQueue.add(task);
    }

    public Task getNextTask() {
        return taskQueue.poll();
    }
}