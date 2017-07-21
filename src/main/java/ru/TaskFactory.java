package ru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Tkachenko
 *         20.07.17
 */
@Component
public class TaskFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskFactory.class);

    public Runnable getNotificationTask() {
        LOGGER.info("TaskFactory");
        final DoTask task = new DoTask();
        return task;
    }
}
