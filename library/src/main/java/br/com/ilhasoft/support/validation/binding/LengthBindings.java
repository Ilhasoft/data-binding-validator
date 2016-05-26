package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.MaxLengthRule;
import br.com.ilhasoft.support.validation.rule.MinLengthRule;
import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by john-mac on 5/14/16.
 */
public class LengthBindings {

    @BindingAdapter({"validateMinLength"})
    public static void bindingMinLength(TextView view, int minLength) {
        EditTextHandler.disableErrorOnChanged(view);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new MinLengthRule(view, minLength));
    }

    @BindingAdapter({"validateMaxLength"})
    public static void bindingMaxLength(TextView view, int maxLength) {
        EditTextHandler.disableErrorOnChanged(view);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new MaxLengthRule(view, maxLength));
    }

}
