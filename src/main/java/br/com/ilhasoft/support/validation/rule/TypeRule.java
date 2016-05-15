package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by john-mac on 5/14/16.
 */
public abstract class TypeRule extends Rule<TextView, TypeRule.FieldType> {

    private static final String TAG = "TypeRule";

    private final FieldType type;

    public enum FieldType {
        Email,
        Url,
        Credit_card,
        None
    }

    public TypeRule(FieldType type) {
        super(R.id.validator_type);
        this.type = type;
    }

    @Override
    protected boolean applyRule(TextView view) {
        return super.applyRule(view) && value == type;
    }
}
