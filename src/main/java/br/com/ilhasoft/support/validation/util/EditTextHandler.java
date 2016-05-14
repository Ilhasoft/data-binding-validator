package br.com.ilhasoft.support.validation.util;

import android.support.design.widget.TextInputLayout;
import android.widget.TextView;

/**
 * Created by john-mac on 5/14/16.
 */
public class EditTextHandler {

    public static void setError(TextView textView) {
        setError(textView, null);
    }

    private static void setError(TextView textView, String errorMessage) {
        if(textView.getParent() instanceof TextInputLayout) {
            TextInputLayout textInputLayout = (TextInputLayout) textView.getParent();
            textInputLayout.setError(errorMessage);
        } else {
            textView.setError(errorMessage);
        }
    }

}
