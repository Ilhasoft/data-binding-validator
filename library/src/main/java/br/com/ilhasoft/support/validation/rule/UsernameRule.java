package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 3/24/17.
 */
public class UsernameRule extends TypeRule {

    public UsernameRule(TextView view, String errorMessage) {
        super(view, FieldType.Username, errorMessage);
    }

    @Override
    protected boolean isValid(TextView view) {
        String username = view.getText().toString();
        return username.matches("[a-zA-Z0-9-._]+");
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
