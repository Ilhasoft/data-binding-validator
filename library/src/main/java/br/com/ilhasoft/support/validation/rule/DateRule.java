package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 6/16/16.
 */
public class DateRule extends Rule<TextView, String> {

    public DateRule(TextView view, String value) {
        super(view, value);
    }

    @Override
    public boolean isValid(TextView view) {
        try {
            return new SimpleDateFormat(value, Locale.getDefault()).parse(view.getText().toString()) != null;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        EditTextHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        EditTextHandler.setError(view, view.getContext().getString(R.string.error_message_date_validation));
    }
}
