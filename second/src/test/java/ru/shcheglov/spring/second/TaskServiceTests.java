package ru.shcheglov.spring.second;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.shcheglov.spring.second.model.Task;
import ru.shcheglov.spring.second.service.TaskService;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    private static Task actualTask;

    @BeforeClass
    public static void initClass() {
        actualTask = new Task("First task");
    }

    @Before
    public void initTest() {
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
