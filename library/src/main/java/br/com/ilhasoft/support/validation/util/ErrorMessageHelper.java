package br.com.ilhasoft.support.validation.util;

import android.support.annotation.StringRes;
import android.view.View;

/**
 * Created by john-mac on 3/24/17.
 */
public class ErrorMessageHelper {

    public static String getStringOrDefault(View view, String errorMessage,
                                            @StringRes int defaultMessage) {
        return errorMessage != null ? errorMessage : view.getContext().getString(defaultMessage);
    }

    public static String getStringOrDefault(View view, String errorMessage,
                                            @StringRes int defaultMessage, int value) {
        return errorMessage != null ? errorMessage : view.getContext().getString(defaultMessage, value);
    }

    public static String getStringOrDefault(View view, CharSequence errorMessage,
                                            @StringRes int defaultMessage) {
        return errorMessage != null ? errorMessage.toString() : view.getContext().getString(defaultMessage);
    }

    public static String getStringOrDefault(View view, CharSequence errorMessage,
                                            @StringRes int defaultMessage, int value) {
        return errorMessage != null ? errorMessage.toString() : view.getContext().getString(defaultMessage, value);
    }
}
