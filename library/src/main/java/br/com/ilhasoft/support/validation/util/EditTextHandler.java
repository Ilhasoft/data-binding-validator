package br.com.ilhasoft.support.validation.util;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/**
 * Created by john-mac on 5/14/16.
 */
public class EditTextHandler {

    public static void removeError(TextView textView) {
        setError(textView, null);
    }

    public static void setError(TextView textView, String errorMessage) {
        if(textView.getParent() instanceof TextInputLayout) {
            TextInputLayout textInputLayout = (TextInputLayout) textView.getParent();
            textInputLayout.setError(errorMessage);
        } else {
            textView.setError(errorMessage);
        }
    }

    public static void disableErrorOnChanged(final TextView view) {
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setError(view, null);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

}
