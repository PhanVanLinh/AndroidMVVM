package toong.vn.androidmvvm;

import toong.vn.androidmvvm.data.source.TaskRepository;
import toong.vn.androidmvvm.data.source.local.TaskLocalDataSource;
import toong.vn.androidmvvm.data.source.local.api.dao.TaskDao;
import toong.vn.androidmvvm.data.source.remote.TaskRemoteDataSource;

/**
 * Created by PhanVanLinh on 20/03/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class Injection {
    public static TaskRepository provideTaskRepository() {
        return TaskRepository.getInstance(TaskRemoteDataSource.getInstance(),
                TaskLocalDataSource.getInstance(new TaskDao()));
    }
}
