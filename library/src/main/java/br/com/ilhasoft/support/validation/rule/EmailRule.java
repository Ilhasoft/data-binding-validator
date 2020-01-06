/*
 * Copyright (c) 2017-present Ilhasoft.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.ilhasoft.support.validation.rule;

import android.util.Patterns;
import android.widget.TextView;

import java.util.regex.Pattern;

import br.com.ilhasoft.support.validation.util.EditTextHandler;

public class EmailRule extends Rule<TextView, Boolean> {

    private static final int USERNAME_LENGTH =  64;

    public EmailRule(TextView view, String errorMessage) {
        super(view, null,  errorMessage);
    }

    @Override
    public boolean isValid(TextView view) {
        String emailValue = view.getText().toString();
        String username = emailValue.split("@")[0];
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        return username.length() <= USERNAME_LENGTH && emailPattern.matcher(view.getText()).matches();
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
