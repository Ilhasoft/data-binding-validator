package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.view.View;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by john-mac on 5/14/16.
 */
public class LengthBindings extends ValidationBindings {

    @BindingAdapter({"validateMinLength"})
    public static void bindingMinLength(View view, int minLength) {
        setupValidation(view);
        view.setTag(R.id.validator_min_length, minLength);
    }

    @BindingAdapter({"bind:validateMaxLength"})
    public static void bindingMaxLength(View view, int maxLength) {
        setupValidation(view);
        view.setTag(R.id.validator_max_length, maxLength);
    }

}
