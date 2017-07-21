package ru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Dmitry Tkachenko
 *         20.07.17
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class DoTask implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoTask.class);

    @Override
    public void run() {
        LOGGER.info("run DoTask+++++++++");
    }
}
