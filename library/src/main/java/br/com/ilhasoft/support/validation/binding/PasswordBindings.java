package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.ConfirmPasswordRule;
import br.com.ilhasoft.support.validation.rule.DateRule;
import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by john-mac on 6/16/16.
 */
public class PasswordBindings {

    @BindingAdapter(value = {"validatePassword", "errorMessage"}, requireAll = false)
    public static void bindingDate(TextView view, TextView comparableView, String errorMessage) {
        EditTextHandler.disableErrorOnChanged(view);
        ViewTagHelper.appendValue(R.id.validator_rule, view,
                new ConfirmPasswordRule(view, comparableView, errorMessage));
    }

}
