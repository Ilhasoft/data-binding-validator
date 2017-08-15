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

package br.com.ilhasoft.support.validation.util;

import android.databinding.adapters.ListenerUtil;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewParent;
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
        TextInputLayout textInputLayout = getTextInputLayout(textView);
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(!TextUtils.isEmpty(errorMessage));
            textInputLayout.setError(errorMessage);
        } else {
            textView.setError(errorMessage);
        }
    }

    @Nullable
    private static TextInputLayout getTextInputLayout(TextView textView) {
        TextInputLayout textInputLayout = null;

        ViewParent parent = textView.getParent();
        while (parent instanceof View) {
            if (parent instanceof TextInputLayout) {
                textInputLayout = (TextInputLayout) parent;
                break;
            }
            parent = parent.getParent();
        }
        return textInputLayout;
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
