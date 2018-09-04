package engineer.filip.shaketogo.base;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import dagger.android.AndroidInjection;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel, N extends BaseNavigator> extends
    AppCompatActivity {

  private T viewDataBinding;
  private V viewModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    injectDependencies();
    super.onCreate(savedInstanceState);
    viewModel = getViewModel();
    setNavigator();
    bindView();

  }

  public abstract int getBindingVariable();

  @LayoutRes
  public abstract int getLayoutId();

  public abstract V getViewModel();

  public abstract N getNavigator();

  public T getViewDataBinding() {
    return viewDataBinding;
  }

  private void bindView() {
    viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    viewDataBinding.setVariable(getBindingVariable(), viewModel);
    viewDataBinding.executePendingBindings();
  }

  private void injectDependencies() {
    AndroidInjection.inject(this);
  }

  private void setNavigator() {
    viewModel.setNavigator(getNavigator());
  }

}
