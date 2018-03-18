package toong.vn.androidmvvm.data.source;

import android.support.annotation.NonNull;
import java.util.List;
import toong.vn.androidmvvm.data.model.Task;

/**
 * Created by PhanVanLinh on 18/03/2018.
 * phanvanlinh.94vn@gmail.com
 */

public interface TaskDataSource {

    interface LoadTasksCallback {

        void onTasksLoaded(List<Task> tasks);

        void onDataNotAvailable();
    }

    void getTasks(@NonNull LoadTasksCallback callback);

    void saveTask(@NonNull Task task);
}
