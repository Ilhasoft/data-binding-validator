package br.com.ilhasoft.support.validation.util;

import android.databinding.adapters.ListenerUtil;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by john-mac on 5/14/16.
 */
public class EditTextHandler {

    public static void removeError(TextView textView) {
        EditTextHandler.setError(textView, null);
    }

    public static void setError(TextView textView, String errorMessage) {
        if (textView.getParent() instanceof TextInputLayout) {
            TextInputLayout textInputLayout = (TextInputLayout) textView.getParent();
            textInputLayout.setErrorEnabled(!TextUtils.isEmpty(errorMessage));
            textInputLayout.setError(errorMessage);
        } else {
            textView.setError(errorMessage);
        }
    }

    public static void disableErrorOnChanged(final TextView textView) {
        if (ListenerUtil.<TextWatcher>getListener(textView, R.id.text_watcher_clear_error) != null) {
            return;
        }

        final TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditTextHandler.setError(textView, null);
            }
            @Override
            public void afterTextChanged(Editable s) { }
        };
        textView.addTextChangedListener(textWatcher);
        ListenerUtil.trackListener(textView, textView, R.id.text_watcher_clear_error);
    }

}
