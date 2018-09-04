package engineer.filip.shaketogo.base;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel>
    extends Fragment {

  private View rootView;
  private T viewDataBinding;
  private V viewModel;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    injectDependencies();
    super.onCreate(savedInstanceState);
    viewModel = getViewModel();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    bindView();
  }

  private void bindView() {
    viewDataBinding.setVariable(getBindingVariable(), viewModel);
    viewDataBinding.executePendingBindings();
  }

  public abstract int getBindingVariable();

  @LayoutRes
  public abstract int getLayoutId();

  public abstract V getViewModel();

  public T getViewDataBinding() {
    return viewDataBinding;
  }

  private void injectDependencies() {
    AndroidSupportInjection.inject(this);
  }

}
