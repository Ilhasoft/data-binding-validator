package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import org.apache.commons.validator.routines.DateValidator;

import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 6/16/16.
 */
public class RegexRule extends Rule<TextView, String> {

    public RegexRule(TextView view, String value, String errorMessage) {
        super(view, value, errorMessage);
    }

    @Override
    public boolean isValid(TextView view) {
        return view.getText().toString().matches(value);
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
