package br.com.ilhasoft.support.validation.rule;

import android.support.annotation.Nullable;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 5/14/16.
 */
public class ConfirmPasswordRule extends Rule<TextView, TextView> {

    private String customMessage;

    public ConfirmPasswordRule(TextView view, TextView value, @Nullable String customMessage) {
        super(view, value);
        this.customMessage = customMessage;
    }

    @Override
    public boolean isValid(TextView view) {
        final String value1 = view.getText().toString();
        final String value2 = value.getText().toString();
        return value1.equals(value2);
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        EditTextHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        final String message;
        if (customMessage == null){
            message = view.getContext().getString(R.string.error_message_not_equal_password);
        }else {
            message = customMessage;
        }

        EditTextHandler.setError(view, message);
    }
}
