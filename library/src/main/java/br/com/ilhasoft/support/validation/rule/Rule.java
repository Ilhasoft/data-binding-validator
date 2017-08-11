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

import android.view.View;

/**
 * Created by john-mac on 5/14/16.
 */
public abstract class Rule<ViewType extends View, ValueType> {

    protected ValueType value;
    protected ViewType view;
    protected String errorMessage;

    public Rule(ViewType view, ValueType value, String errorMessage) {
        this.view = view;
        this.value = value;
        this.errorMessage = errorMessage;
    }

    public final boolean validate() {
        final boolean valid = isValid(view);
        if (valid) {
            onValidationSucceeded(view);
        } else {
            onValidationFailed(view);
        }
        return valid;
    }

    protected abstract boolean isValid(ViewType view);

    protected void onValidationSucceeded(ViewType view) {}

    protected void onValidationFailed(ViewType view) {}

    public ViewType getView() {
        return view;
    }
}
