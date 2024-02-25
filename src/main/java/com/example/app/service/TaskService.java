package com.example.app.service;

import com.example.app.domain.Task;
import com.example.app.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class TaskService {

    TaskRepository repository;

    public Task save(@NonNull Task task) {
       log.info("Сохранение задачи...");
       Task saved = this.repository.save(task);
       log.info("Задача созранена с id '{}'", saved.getId());
       return saved;
    }

    public List<Task> getAll() {
        log.info("Поиск задач...");
        List<Task> all = this.repository.findAll();
        log.info("Задачи найдены в количестве: {}", all.size());
        return all;
    }

    public Task getByID(@NonNull Long id) {
        log.debug("Получение задания с id '{}'", id);
        return this.repository.getReferenceById(id);
    }

    public void delete(@NonNull Long id) {
        log.info("Удаление задания с ид '{}'", id);
        this.repository.deleteById(id);
        log.info("Задание удалено");
    }


}
