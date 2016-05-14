package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by john-mac on 5/14/16.
 */
public class MaxLengthRule extends Rule<TextView, Integer> {

    public MaxLengthRule() {
        super(R.id.validator_max_length);
    }

    @Override
    public boolean isValid(TextView view) {
        return view.length() <= value;
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        view.setError(null);
    }

    @Override
    public void onValidationFailed(TextView view) {
        view.setError(view.getContext().getString(R.string.error_message_max_length, value));
    }
}
