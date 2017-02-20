package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.ConfirmPasswordRule;
import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by felipe on 22/12/16.
 */
public class PasswordBindings {

    @BindingAdapter("validatePassword")
    public static void bindingPassword(TextView view, TextView comparableView) {
        EditTextHandler.disableErrorOnChanged(view);
        ViewTagHelper.appendValue(R.id.validator_rule, view,
                new ConfirmPasswordRule(view, comparableView));
    }

}
