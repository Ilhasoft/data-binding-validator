package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by john-mac on 5/14/16.
 */
public abstract class TypeRule extends Rule<TextView, TypeRule.FieldType> {

    public enum FieldType {
        Email(EmailTypeRule.class),
        Url(UrlTypeRule.class),
        None;

        Class<? extends TypeRule> mClass;

        FieldType(Class<? extends TypeRule> mClass) {
            this.mClass = mClass;
        }

        FieldType() {}

        public TypeRule instantiate(TextView view) throws NoSuchMethodException, IllegalAccessException
                , InvocationTargetException, InstantiationException {
            if(this != None) {
                return mClass.getConstructor(TextView.class).newInstance(view);
            }
            throw new IllegalStateException("It's not possible to bind a none value type");
        }
    }

    public TypeRule(TextView view, FieldType value) {
        super(view, value);
    }

}
