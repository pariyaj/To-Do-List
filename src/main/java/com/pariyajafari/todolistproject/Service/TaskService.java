package com.pariyajafari.todolistproject.Service;

import com.pariyajafari.todolistproject.Model.Task;
import com.pariyajafari.todolistproject.Repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task newTask){
        return taskRepository.save(newTask);
    }

    public Task updateTaskStatusById(Long id, Task updatedTask){
        Task existingTask = getTaskById(id);
        existingTask.setStatus(updatedTask.getStatus());
        return taskRepository.save(existingTask);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }

}
