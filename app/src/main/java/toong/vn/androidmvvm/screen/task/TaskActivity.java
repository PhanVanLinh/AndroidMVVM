package toong.vn.androidmvvm.screen.task;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import toong.vn.androidmvvm.Injection;
import toong.vn.androidmvvm.R;
import toong.vn.androidmvvm.databinding.ActivityTaskBinding;

public class TaskActivity extends AppCompatActivity {
    private TaskViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTaskBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_task);
        binding.setViewModel(getViewModel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    public TaskViewModel getViewModel() {
        return new TaskViewModel(getApplicationContext(), Injection.provideTaskRepository());
    }
}
