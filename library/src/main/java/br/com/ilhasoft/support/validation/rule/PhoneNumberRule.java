package br.com.ilhasoft.support.validation.rule;

import java.util.regex.Pattern;

import android.util.Patterns;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.EditTextHandler;

public class PhoneNumberRule extends TypeRule {

    public PhoneNumberRule(TextView view, String errorMessage) {
        super(view, FieldType.Phone, errorMessage);
    }

    @Override
    protected boolean isValid(TextView view) {
        Pattern emailPattern = Patterns.PHONE;
        return emailPattern.matcher(view.getText()).matches();
    }

    @Override
    protected void onValidationSucceeded(TextView view) {
        super.onValidationSucceeded(view);
        EditTextHandler.removeError(view);
    }

    @Override
    protected void onValidationFailed(TextView view) {
        super.onValidationFailed(view);
        EditTextHandler.setError(view, errorMessage);
    }
}