package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;

/**
 * Bindings for properties which configure validation behaviour 
 * 
 * 
 * Created by molexx on 12/11/2017.
 */
public class ConfigBindings {
    
    @BindingAdapter(value = {"showErrorMessage"}, requireAll = false)
    public static void bindingShowErrorMessage(TextView view, boolean showErrorMessage) {
        if (showErrorMessage == false) {
            view.setTag(R.id.show_error_message, Boolean.FALSE);
        } else {
            view.setTag(R.id.show_error_message, null);
        }
    }
    
}
