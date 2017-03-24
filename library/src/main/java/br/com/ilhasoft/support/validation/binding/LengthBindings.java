package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.EmailTypeRule;
import br.com.ilhasoft.support.validation.rule.EmptyRule;
import br.com.ilhasoft.support.validation.rule.MaxLengthRule;
import br.com.ilhasoft.support.validation.rule.MinLengthRule;
import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.ErrorMessageHelper;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by john-mac on 5/14/16.
 */
public class LengthBindings {

    @BindingAdapter(value = {"validateMinLength", "validateMinLengthMessage", "validateMinLengthAutoDismiss"}, requireAll = false)
    public static void bindingMinLength(TextView view, int minLength, String errorMessage, Boolean autoDismiss) {
        if (autoDismiss == null || autoDismiss) {
            EditTextHandler.disableErrorOnChanged(view);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_min_length, minLength);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new MinLengthRule(view, minLength, handledErrorMessage));
    }

    @BindingAdapter(value = {"validateMaxLength", "validateMaxLengthMessage", "validateMaxLengthAutoDismiss"}, requireAll = false)
    public static void bindingMaxLength(TextView view, int maxLength, String errorMessage, Boolean autoDismiss) {
        if (autoDismiss == null || autoDismiss) {
            EditTextHandler.disableErrorOnChanged(view);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_max_length, maxLength);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new MaxLengthRule(view, maxLength, handledErrorMessage));
    }

    @BindingAdapter(value = {"validateEmpty", "validateEmptyMessage", "validateEmptyAutoDismiss"}, requireAll = false)
    public static void bindingEmpty(TextView view, boolean empty, String errorMessage, Boolean autoDismiss) {
        if (autoDismiss == null || autoDismiss) {
            EditTextHandler.disableErrorOnChanged(view);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_empty_validation);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new EmptyRule(view, empty, handledErrorMessage));
    }

}
