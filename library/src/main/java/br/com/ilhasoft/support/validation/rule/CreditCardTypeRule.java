package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import org.apache.commons.validator.routines.CreditCardValidator;

import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 6/16/16.
 */
public class CreditCardTypeRule extends TypeRule {

    private final CreditCardValidator creditCardValidator;

    public CreditCardTypeRule(TextView view, String errorMessage) {
        super(view, FieldType.CreditCard, errorMessage);
        creditCardValidator = new CreditCardValidator();
    }

    @Override
    protected boolean isValid(TextView view) {
        return creditCardValidator.isValid(view.getText().toString().replaceAll("\\s", ""));
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
