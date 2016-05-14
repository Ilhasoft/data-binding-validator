package br.com.ilhasoft.support.validation.rule;

import android.view.View;

/**
 * Created by john-mac on 5/14/16.
 */
public abstract class Rule<ViewType extends View, ValueType> {

    protected final int ruleId;
    protected ValueType value;

    public Rule(int ruleId) {
        this.ruleId = ruleId;
    }

    public final boolean validate(ViewType view) {
        this.value = getRuleValue(view);
        if(value == null)
            return true;

        boolean valid = isValid(view);
        if(valid) {
            onValidationSucceeded(view);
        } else {
            onValidationFailed(view);
        }
        return valid;
    }

    protected abstract boolean isValid(ViewType view);

    protected void onValidationSucceeded(ViewType view) {}

    protected void onValidationFailed(ViewType view) {}

    private ValueType getRuleValue(ViewType view) {
        return (ValueType) view.getTag(ruleId);
    }


}
