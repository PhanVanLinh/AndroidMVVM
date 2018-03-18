package toong.vn.androidmvvm.data.source;

import android.support.annotation.NonNull;
import java.util.List;
import toong.vn.androidmvvm.data.model.Task;

/**
 * Created by PhanVanLinh on 18/03/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class TaskRepository implements TaskDataSource {
    private static TaskRepository INSTANCE = null;
    private TaskDataSource taskLocalDataSource;
    private TaskDataSource taskRemoteDataSource;

    private TaskRepository(@NonNull TaskDataSource taskRemoteDataSource,
            @NonNull TaskDataSource taskLocalDataSource) {
        this.taskRemoteDataSource = taskRemoteDataSource;
        this.taskLocalDataSource = taskLocalDataSource;
    }

    public static TaskRepository getInstance(TaskDataSource TaskRemoteDataSource,
            TaskDataSource TaskLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new TaskRepository(TaskRemoteDataSource, TaskLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Get tasks from local first, if it don't has -> get remote
     */
    @Override
    public void getTasks(@NonNull final LoadTasksCallback callback) {
        taskLocalDataSource.getTasks(new LoadTasksCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                callback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                taskRemoteDataSource.getTasks(callback);
            }
        });
    }

    @Override
    public void saveTask(@NonNull Task task) {

    }
}
