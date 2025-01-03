package com.pariyajafari.todolistproject.service;

import com.pariyajafari.todolistproject.model.Enum.Status;
import com.pariyajafari.todolistproject.model.Task;
import com.pariyajafari.todolistproject.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public TaskService(TaskRepository taskRepository, KafkaTemplate<String, Long> kafkaTemplate){
        this.taskRepository = taskRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Task addTask(Task task){
        kafkaTemplate.send("taskCreated", task.getName());
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

    public Optional<Task> getTasksByName(){
        return taskRepository.findTaskByName();
    }

    @KafkaListener( id= "mantraGroup", topics = "taskCreated")
    public String kafkaListener(Task task){
        kafkaTemplate.send("taskCreated", task.getName());
        return task.getName();
    }
}
