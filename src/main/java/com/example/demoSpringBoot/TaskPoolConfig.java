package com.example.demoSpringBoot;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
/**
 * Created by BF100499 on 2018/11/13.
 */
@EnableAsync
@Configuration
public class TaskPoolConfig {

        @Bean("taskExecutor")
        public ThreadPoolTaskScheduler taskExecutor() {
            ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
            executor.setPoolSize(20);
            executor.setThreadNamePrefix("taskExecutor-");

            executor.setWaitForTasksToCompleteOnShutdown(true);
            executor.setAwaitTerminationSeconds(60);
            return executor;
        }

    }
