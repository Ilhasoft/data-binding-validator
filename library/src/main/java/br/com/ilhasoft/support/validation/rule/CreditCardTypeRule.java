package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.CreditCardValidator;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 6/16/16.
 */
public class CreditCardTypeRule extends TypeRule {

    public CreditCardTypeRule(TextView view) {
        super(view, FieldType.CreditCard);
    }

    @Override
    protected boolean isValid(TextView view) {
        CreditCardValidator creditCardValidator = new CreditCardValidator();
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
        EditTextHandler.setError(view, view.getContext().getString(R.string.error_message_credit_card_validation));
    }
}
