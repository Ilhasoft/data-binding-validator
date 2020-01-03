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

package br.com.ilhasoft.support.validation.binding;

import androidx.databinding.BindingAdapter;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.RegexRule;
import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.ErrorMessageHelper;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by john-mac on 3/24/17.
 */
public class RegexBindings {

    @BindingAdapter(value = {
            "validateRegex",
            "validateRegexMessage",
            "validateRegexAutoDismiss"
    }, requireAll = false)
    public static void bindingRegex(TextView view, String pattern, String errorMessage,
                                    boolean autoDismiss) {
        if (autoDismiss) {
            EditTextHandler.disableErrorOnChanged(view);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_regex_validation);
        ViewTagHelper.appendValue(R.id.validator_rule, view,
                new RegexRule(view, pattern, handledErrorMessage));
    }

}
