package br.com.ilhasoft.support.validation.rule;

import android.text.TextUtils;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 5/14/16.
 */
public class EmptyRule extends Rule<TextView, Boolean> {

    public EmptyRule(TextView view, Boolean value, String errorMessage) {
        super(view, value, errorMessage);
    }

    @Override
    public boolean isValid(TextView view) {
        return !value || !TextUtils.isEmpty(view.getText());
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
