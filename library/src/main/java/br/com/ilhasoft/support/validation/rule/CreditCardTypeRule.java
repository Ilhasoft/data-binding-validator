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

import android.widget.TextView;

import org.apache.commons.validator.routines.CreditCardValidator;

import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 6/16/16.
 */
public class CreditCardTypeRule extends TypeRule {

    private final CreditCardValidator creditCardValidator;

    public CreditCardTypeRule(TextView view, String errorMessage) {
        super(view, FieldType.CreditCard, errorMessage);
        creditCardValidator = new CreditCardValidator();
    }

    @Override
    protected boolean isValid(TextView view) {
        return creditCardValidator.isValid(view.getText().toString().replaceAll("\\s", ""));
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
