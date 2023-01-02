package au.com.tgg.apps.foundation.util.impl;

import au.com.tgg.apps.foundation.util.TggExecutorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
public class TggExecutorServiceImpl implements TggExecutorService {

    private final Logger LOGGER = LogManager.getLogger(TggExecutorService.class);

    @Override
    public Boolean executeTasks(List<Callable<String>> tasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long startProcessingTime = System.currentTimeMillis();
        try {
            executorService.invokeAll(tasks)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get() + "; And Task done is " + future.isDone();
                        } catch (InterruptedException | ExecutionException e) {
                            //TODO
                            e.printStackTrace();
                            return "";
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        awaitTerminationAfterShutdown(executorService);
        return true;
    }

    private void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        LOGGER.debug("=== executorService shutdown ===");
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                LOGGER.debug("=== executorService shutdownNow ===");
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
