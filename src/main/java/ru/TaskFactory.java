package ru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Tkachenko
 *         20.07.17
 */
@Component
public class TaskFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskScheduler.class);

    @Autowired
    private AutowiredAnnotationBeanPostProcessorImpl autowiredAnnotationBeanPostProcessor;

    public Runnable getNotificationTask() {
        LOGGER.info("TaskFactory");
        final DoTask task = new DoTask();
        autowiredAnnotationBeanPostProcessor.processInjection(task);
        return task;
    }
}
