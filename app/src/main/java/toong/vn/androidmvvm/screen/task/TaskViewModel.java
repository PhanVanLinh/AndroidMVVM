package toong.vn.androidmvvm.screen.task;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import java.util.List;
import toong.vn.androidmvvm.BR;
import toong.vn.androidmvvm.data.model.Task;
import toong.vn.androidmvvm.data.source.TaskDataSource;
import toong.vn.androidmvvm.data.source.TaskRepository;

/**
 * Created by PhanVanLinh on 18/03/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class TaskViewModel extends BaseObservable {
    private final Context context;
    private final TaskRepository tasksRepository;
    private int numberOfTask;

    TaskViewModel(Context context, TaskRepository taskRepository) {
        this.context = context;
        this.tasksRepository = taskRepository;
    }

    public void onResume() {
        tasksRepository.getTasks(new TaskDataSource.LoadTasksCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                setNumberOfTask(tasks.size());
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Bindable
    public int getNumberOfTask() {
        return numberOfTask;
    }

    private void setNumberOfTask(int numberOfTask) {
        this.numberOfTask = numberOfTask;
        notifyPropertyChanged(BR.numberOfTask);
    }
}
