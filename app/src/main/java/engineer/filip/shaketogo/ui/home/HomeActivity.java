package engineer.filip.shaketogo.ui.home;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import engineer.filip.shaketogo.R;
import engineer.filip.shaketogo.BR;
import engineer.filip.shaketogo.base.BaseActivity;
import engineer.filip.shaketogo.databinding.HomeActivityBinding;
import javax.inject.Inject;

public class HomeActivity extends BaseActivity<HomeActivityBinding, HomeViewModel, HomeNavigator> implements
    HomeNavigator {

  @Inject
  ViewModelProvider.Factory viewModelFactory;
  private HomeViewModel homeViewModel;

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
    return R.layout.home_activity;
  }

  @Override
  public HomeViewModel getViewModel() {
    if (homeViewModel == null) {
      homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);
    }
    return homeViewModel;
  }

  @Override
  public HomeNavigator getNavigator() {
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
