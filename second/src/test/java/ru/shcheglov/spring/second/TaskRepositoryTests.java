package ru.shcheglov.spring.second;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.shcheglov.spring.second.model.Task;
import ru.shcheglov.spring.second.repository.TaskRepository;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTests {

    @Autowired
    private TaskRepository taskRepository;

    private Task actualTask;

    @Before
    public void init() {
        this.actualTask = new Task("Test task");
    }

    @Test
    public void whenCreateReadTaskThenExists() {
        taskRepository.merge(actualTask);
        final Task expectedTask = taskRepository.findOneById(actualTask.getId());
        Assert.assertEquals(expectedTask, actualTask);
    }

    @Test
    public void whenUpdateTaskThenEquals() {
        final String actualId = actualTask.getId();
        taskRepository.merge(actualTask);
        final Task expectedTask = taskRepository.findOneById(actualId);
        expectedTask.setName("Modified task");
        taskRepository.merge(expectedTask);
        final Task updatedTask = taskRepository.findOneById(actualId);
        Assert.assertEquals(updatedTask, actualTask);
    }

    @Test
    public void whenDeleteTaskThenNull() {
        final String actualId = actualTask.getId();
        taskRepository.removeById(actualId);
        final Task expectedTask = taskRepository.findOneById(actualId);
        Assert.assertNull(expectedTask);
    }

    @After
    public void deinit() {
        this.actualTask = null;
    }

}
