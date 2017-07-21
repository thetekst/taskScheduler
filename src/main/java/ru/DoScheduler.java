package ru;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

/**
 * @author Dmitry Tkachenko
 *         20.07.17
 */
@Service
public class DoScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoScheduler.class);

    @Autowired
    private TaskFactory taskFactory;

    @Autowired
    private TaskScheduler taskScheduler;

    private final Map<Long, ScheduledFuture<?>> scheduledUpload = Maps.newHashMap();

    private boolean isTrue = true;

    @Scheduled(cron = "${cron.upload.scheduler.template}")
    public void initSchedules() {
        if (isTrue) {
            LOGGER.info("DoScheduler 1: {}", new Date());
            final Set<Long> toCancelList = Sets.newHashSet(scheduledUpload.keySet());
            scheduleTemporalActivated(toCancelList);
            toCancelList.forEach(this::cancelTask);
        }
    }

    private void scheduleTemporalActivated(final Set<Long> toCancelList) {
        final Runnable task = taskFactory.getNotificationTask();
        final Calendar calendar = Calendar.getInstance();

        if (true) {
//            taskScheduler.schedule(task, calendar.getTime());
            LOGGER.info("DoScheduler 2");
        } else {
//            task.cancelWithComment(statusDate);
        }
    }

    private void cancelTask(final Long scheduledId) {
        final ScheduledFuture<?> scheduledFuture = scheduledUpload.get(scheduledId);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
