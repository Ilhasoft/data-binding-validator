package br.com.ilhasoft.support.validation.binding;

import android.view.View;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by john-mac on 5/14/16.
 */
public class ValidationBindings {

    public static void setupValidation(View view) {
        view.setTag(R.id.hasValidation, true);
    }

}
