package toong.vn.androidmvvm.data.source.remote;

import android.support.annotation.NonNull;
import toong.vn.androidmvvm.data.model.Task;
import toong.vn.androidmvvm.data.source.TaskDataSource;

/**
 * Created by PhanVanLinh on 18/03/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class TaskRemoteDataSource implements TaskDataSource {
    private static TaskRemoteDataSource INSTANCE;

    public static TaskRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getTasks(@NonNull LoadTasksCallback callback) {

    }

    @Override
    public void saveTask(@NonNull Task task) {

    }
}
