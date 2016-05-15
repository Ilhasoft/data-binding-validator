package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.TypeRule;

/**
 * Created by john-mac on 5/14/16.
 */
public class TypeBindings extends ValidationBindings {

    @BindingAdapter({"validateType"})
    public static void bindingTypeValidation(View view, String fieldTypeText) {
        setupValidation(view);

        TypeRule.FieldType fieldType = getFieldTypeByText(fieldTypeText);
        if(fieldType != TypeRule.FieldType.None) {
            view.setTag(R.id.validator_type, fieldType);
        }
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
