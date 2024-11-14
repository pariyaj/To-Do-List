package com.pariyajafari.todolistproject.service;

import com.pariyajafari.todolistproject.model.Status;
import com.pariyajafari.todolistproject.model.Task;
import com.pariyajafari.todolistproject.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTaskStatusById(Long id, Status newStatus){
        Task existingTask = getTaskById(id);
        existingTask.setStatus(newStatus);
        return taskRepository.save(existingTask);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }

    public List<Task> getSortedTasksByName(){
        return taskRepository.findAllTask(Sort.by("name"));
    }

}
