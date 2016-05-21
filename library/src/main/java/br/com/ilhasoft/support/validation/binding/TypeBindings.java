package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.EmailTypeRule;
import br.com.ilhasoft.support.validation.rule.TypeRule;
import br.com.ilhasoft.support.validation.rule.UrlTypeRule;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by john-mac on 5/14/16.
 */
public class TypeBindings {

    @BindingAdapter({"validateType"})
    public static void bindingTypeValidation(TextView view, String fieldTypeText) {
        TypeRule.FieldType fieldType = getFieldTypeByText(fieldTypeText);
        try {
            ViewTagHelper.appendValue(R.id.validator_rule, view, fieldType.instantiate(view));
        } catch (Exception ignored) {}
    }

    @NonNull
    private static TypeRule.FieldType getFieldTypeByText(String fieldTypeText) {
        TypeRule.FieldType fieldType = TypeRule.FieldType.None;
        for (TypeRule.FieldType type : TypeRule.FieldType.values()) {
            if (type.toString().equalsIgnoreCase(fieldTypeText)) {
                fieldType = type;
                break;
            }
        }
        return fieldType;
    }

}
