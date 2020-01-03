/*
 * Copyright (c) 2020-present ConteDevel, DT.
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

import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by Denis Sologub on 1/3/20.
 */
public class PhoneNumberTypeRule extends TypeRule {

    public PhoneNumberTypeRule(TextView view, String errorMessage, boolean allowEmpty) {
        super(view, FieldType.PhoneNumber, errorMessage, allowEmpty);
    }

    @Override
    protected boolean isValid(TextView view) {
        String phone = view.getText().toString();
        return (allowEmpty && phone.length() == 0) || Patterns.PHONE.matcher(phone).matches();
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

