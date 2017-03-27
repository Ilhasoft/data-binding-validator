package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.DateRule;
import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.ErrorMessageHelper;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by john-mac on 6/16/16.
 */
public class DateBindings {

    @BindingAdapter(value = {"validateDate", "validateDateMessage", "validateDateAutoDismiss"}, requireAll = false)
    public static void bindingDate(TextView view, String pattern, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            EditTextHandler.disableErrorOnChanged(view);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_date_validation);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new DateRule(view, pattern, handledErrorMessage));
    }

}
