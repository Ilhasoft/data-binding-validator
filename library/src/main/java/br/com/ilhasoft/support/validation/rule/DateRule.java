package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import org.apache.commons.validator.routines.DateValidator;

import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 6/16/16.
 */
public class DateRule extends Rule<TextView, String> {

    private final DateValidator dateValidator;

    public DateRule(TextView view, String value, String errorMessage) {
        super(view, value, errorMessage);
        dateValidator = new DateValidator();
    }

    @Override
    public boolean isValid(TextView view) {
        return dateValidator.isValid(view.getText().toString(), value);
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        EditTextHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        EditTextHandler.setError(view, errorMessage);
    }
}
