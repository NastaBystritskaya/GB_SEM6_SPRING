package com.example.app.controller;

import com.example.app.domain.Task;
import com.example.app.service.TaskService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {

    TaskService service;


    @PostMapping
    public Task create(@RequestBody Task newTask) {
        return this.service.save(newTask);
    }

    @GetMapping
    public List<Task> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Task getByID(@PathVariable("id") Long id) {
        return this.service.getByID(id);
    }

    @PutMapping("/{id}")
    public Task update(@RequestBody Task task, @PathVariable("id") Long id) {
        task.setId(id);
        return this.service.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);
    }

}
