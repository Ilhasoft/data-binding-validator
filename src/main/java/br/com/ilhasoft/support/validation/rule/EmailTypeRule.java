package br.com.ilhasoft.support.validation.rule;

import android.util.Patterns;
import android.widget.TextView;

import java.util.regex.Pattern;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 5/14/16.
 */
public class EmailTypeRule extends TypeRule {

    public EmailTypeRule() {
        super(FieldType.Email);
    }

    @Override
    protected boolean isValid(TextView view) {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
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
        EditTextHandler.setError(view, view.getContext().getString(R.string.error_message_email_validation));
    }
}
