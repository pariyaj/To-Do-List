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

    public void addTask(Task newTask){
        taskRepository.save(newTask);
    }

    public void updateTaskStatusById(Long id, Task updatedTask){
        Task existingTask = getTaskById(id);
        existingTask.setStatus(updatedTask.getStatus());
        taskRepository.save(existingTask);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }

}
