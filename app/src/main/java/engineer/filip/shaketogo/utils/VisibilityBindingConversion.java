package engineer.filip.shaketogo.utils;

import android.view.View;
import androidx.databinding.BindingConversion;

public class VisibilityBindingConversion {

  @BindingConversion
  public static int convertBooleanToVisibility(boolean isVisible) {
    return isVisible ? View.VISIBLE : View.GONE;
  }

}
