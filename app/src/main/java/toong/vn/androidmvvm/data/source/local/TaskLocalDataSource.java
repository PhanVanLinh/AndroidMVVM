package toong.vn.androidmvvm.data.source.local;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import toong.vn.androidmvvm.data.model.Task;
import toong.vn.androidmvvm.data.source.TaskDataSource;
import toong.vn.androidmvvm.data.source.local.api.dao.TaskDao;

/**
 * Created by PhanVanLinh on 18/03/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class TaskLocalDataSource implements TaskDataSource {
    private static volatile TaskLocalDataSource INSTANCE = null;
    private TaskDao taskDao;

    public TaskLocalDataSource(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public static TaskLocalDataSource getInstance(@NonNull TaskDao tasksDao) {
        if (INSTANCE == null) {
            synchronized (TaskLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskLocalDataSource(tasksDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void getTasks(@NonNull LoadTasksCallback callback) {
        callback.onTasksLoaded(fakeTaskResponse());
    }

    private List<Task> fakeTaskResponse() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        return tasks;
    }

    @Override
    public void saveTask(@NonNull Task task) {

    }
}
