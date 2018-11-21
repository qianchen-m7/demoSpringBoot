package com.example.demoSpringBoot;

import com.qch.other.MyThread;
import com.qch.service.Task;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by BF100499 on 2018/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsnyTest {
    @Autowired
    private Task task;
    @Test
    @SneakyThrows
    public void test() {

        for (int i = 0; i < 4; i++) {
            task.doTaskOne();
            task.doTaskTwo();
            task.doTaskThree();

            if (i == 3) {
                System.exit(0);
            }
        }
    }

    @Test
    public void test1() {

        for (int i = 0; i < 4; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }

}
