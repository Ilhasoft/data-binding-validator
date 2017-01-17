package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 5/14/16.
 */
public class ConfirmPasswordRule extends Rule<TextView, TextView> {

    public ConfirmPasswordRule(TextView view, TextView value) {
        super(view, value);
    }

    @Override
    public boolean isValid(TextView view) {
        if (value == null) return false;

        final String value1 = view.getText().toString();
        final String value2 = value.getText().toString();
        return value1.trim().equals(value2.trim());
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        EditTextHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        final String message = view.getContext().getString(R.string.error_message_not_equal_password);
        EditTextHandler.setError(view, message);
    }
}
