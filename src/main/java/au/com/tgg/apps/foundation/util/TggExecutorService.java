package au.com.tgg.apps.foundation.util;

import java.util.List;
import java.util.concurrent.Callable;

public interface TggExecutorService {

    Boolean executeTasks(List<Callable<String>> tasks);
}
