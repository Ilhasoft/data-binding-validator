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
