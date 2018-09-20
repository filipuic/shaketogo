package engineer.filip.shaketogo.ui.home;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import engineer.filip.shaketogo.R;
import engineer.filip.shaketogo.BR;
import engineer.filip.shaketogo.base.BaseActivity;
import engineer.filip.shaketogo.databinding.MainActivityBinding;
import javax.inject.Inject;

public class MainActivity extends
    BaseActivity<MainActivityBinding, MainViewModel, MainNavigator> implements
    MainNavigator {

  @Inject
  ViewModelProvider.Factory viewModelFactory;
  private MainViewModel mainViewModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public int getBindingVariable() {
    return BR.viewModel;
  }

  @Override
  public int getLayoutId() {
    return R.layout.main_activity;
  }

  @Override
  public MainViewModel getViewModel() {
    if (mainViewModel == null) {
      mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
    }
    return mainViewModel;
  }

  @Override
  public MainNavigator getNavigator() {
    return this;
  }

  @Override
  public void openVenue() {
    Toast.makeText(this, "Open Venue", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void handleError(Throwable throwable) {

  }
}
