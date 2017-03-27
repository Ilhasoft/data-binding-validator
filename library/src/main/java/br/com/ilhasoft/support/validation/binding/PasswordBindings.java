package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.ConfirmPasswordRule;
import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.ErrorMessageHelper;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by felipe on 22/12/16.
 */
public class PasswordBindings {

    @BindingAdapter(value = {"validatePassword", "validatePasswordMessage", "validatePasswordAutoDismiss"}, requireAll = false)
    public static void bindingPassword(TextView view, TextView comparableView, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            EditTextHandler.disableErrorOnChanged(view);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_not_equal_password);
        ViewTagHelper.appendValue(R.id.validator_rule, view,
                new ConfirmPasswordRule(view, comparableView, handledErrorMessage));
    }

}
