package ru.shcheglov.spring.second.component;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.shcheglov.spring.second.model.Task;
import ru.shcheglov.spring.second.service.TaskService;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    private Task actualTask;

    @Before
    public void initTest() {
        actualTask = new Task("First task");
        taskService.merge(actualTask);
    }

    @After
    public void deinitTest() {
        taskService.removeOne(actualTask);
    }

    @Test
    public void whenCreatePersonThenNotNull() {
        Assert.assertNotNull(actualTask);
    }

    @Test
    public void whenReadPersonThenExists() {
        final String actualId = actualTask.getId();
        final Task expectedPerson = taskService.findOneById(actualId);
        expectedPerson.setPerson(null);
        boolean equals = expectedPerson.equals(actualTask);
        Assert.assertEquals(actualTask, expectedPerson);
    }

    @Test
    public void whenUpdatePersonThenEquals() {
        final String actualId = actualTask.getId();
        final Task expectedPerson = taskService.findOneById(actualId);
        expectedPerson.setName("Second task");
        taskService.merge(expectedPerson);
        final Task updatedPerson = taskService.findOneById(actualId);
        Assert.assertEquals(updatedPerson, actualTask);
    }

    @Test
    public void whenDeletePersonThenNull() {
        final String actualId = actualTask.getId();
        taskService.removeOne(actualTask);
        final Task expectedPerson = taskService.findOneById(actualId);
        Assert.assertNull(expectedPerson);
    }

}
