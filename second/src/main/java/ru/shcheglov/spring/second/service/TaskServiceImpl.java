package ru.shcheglov.spring.second.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shcheglov.spring.second.model.Task;
import ru.shcheglov.spring.second.repository.TaskRepository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @author Alexey Shcheglov
 * @version dated 18.01.2019
 */

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void saveOne(@Nullable Task entity) {
        taskRepository.saveOne(entity);
    }

    @Override
    public void saveAll(@Nullable Collection<Task> entities) {
        taskRepository.saveAll(entities);
    }

    @Override
    public Collection<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findOneById(@Nullable String id) {
        return taskRepository.findOneById(id);
    }

    @Override
    public Collection<Task> findAllByIds(@Nullable Collection<String> ids) {
        return taskRepository.findAllByIds(ids);
    }

    @Override
    public Task merge(@Nullable Task entity) {
        return taskRepository.merge(entity);
    }

    @Override
    public Collection<Task> merge(@Nullable Collection<Task> entities) {
        return taskRepository.merge(entities);
    }

    @Override
    public void removeAll() {
        taskRepository.removeAll();
    }

    @Override
    public void remove(@Nullable Collection<Task> entities) {
        taskRepository.remove(entities);
    }

    @Override
    public void removeById(@Nullable String id) {
        taskRepository.removeById(id);
    }

    @Override
    public void removeByIds(@Nullable Collection<String> ids) {
        taskRepository.removeByIds(ids);
    }

    @Override
    public void removeOne(@Nullable Task entity) {
        taskRepository.removeOne(entity);
    }

}
