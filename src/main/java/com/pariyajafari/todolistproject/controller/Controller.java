package com.pariyajafari.todolistproject.controller;

import com.pariyajafari.todolistproject.model.Task;
import com.pariyajafari.todolistproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class Controller {


    public Controller() {
    }

    @GetMapping
    public String getString() {
        return "Hello World";
    }

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/sortedtasks")
    public ResponseEntity <List<Task>> getSortedTasksByName() {
        List<Task> sortedTasksByName = taskService.getSortedTasksByName();
        return ResponseEntity.ok(sortedTasksByName);
    }

    @GetMapping("/task/name")
    public ResponseEntity <Optional<Task>> getSimilarTaskByName() {
        Optional<Task> similarTasksByName = taskService.getTasksByName();
        return ResponseEntity.ok(similarTasksByName);
    }

    @PutMapping("/task/update/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody Task updatedTask){
        return ResponseEntity.ok(taskService.updateTaskStatusById(id, updatedTask.getStatus()));
    }

    @PostMapping("/task/add")
    public ResponseEntity<Task> createTask(@RequestBody Task newTask){
        Task savedTask = taskService.addTask(newTask);
        return ResponseEntity.ok(savedTask);
    }
}
