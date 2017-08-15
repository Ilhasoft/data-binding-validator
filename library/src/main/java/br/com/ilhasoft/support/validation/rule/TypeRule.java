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

import android.support.annotation.StringRes;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by john-mac on 5/14/16.
 */
public abstract class TypeRule extends Rule<TextView, TypeRule.FieldType> {

    public enum FieldType {
        Cpf(CpfTypeRule.class, R.string.error_message_cpf_validation),
        Username(UsernameRule.class, R.string.error_message_username_validation),
        Email(EmailTypeRule.class, R.string.error_message_email_validation),
        Url(UrlTypeRule.class, R.string.error_message_url_validation),
        CreditCard(CreditCardTypeRule.class, R.string.error_message_credit_card_validation),
        None;

        Class<? extends TypeRule> mClass;
        public @StringRes int errorMessageId;

        FieldType(Class<? extends TypeRule> mClass, @StringRes int errorMessageId) {
            this.mClass = mClass;
            this.errorMessageId = errorMessageId;
        }

        FieldType() {}

        public TypeRule instantiate(TextView view, String errorMessage) throws NoSuchMethodException, IllegalAccessException
                , InvocationTargetException, InstantiationException {
            if(this != None) {
                return mClass.getConstructor(TextView.class, String.class).newInstance(view, errorMessage);
            }
            throw new IllegalStateException("It's not possible to bind a none value type");
        }
    }

    public TypeRule(TextView view, FieldType value, String errorMessage) {
        super(view, value, errorMessage);
    }

}
