package br.com.ilhasoft.support.validation;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ilhasoft.support.validation.rule.MaxLengthRule;
import br.com.ilhasoft.support.validation.rule.MinLengthRule;
import br.com.ilhasoft.support.validation.rule.Rule;

/**
 * Created by john-mac on 5/14/16.
 */
public class Validator {

    private ViewDataBinding target;
    private final List<Rule> rules;

    public Validator(ViewDataBinding target) {
        this.target = target;
        this.rules = new ArrayList<>();
        setupRules();
    }

    private void setupRules() {
        this.rules.add(new MinLengthRule());
        this.rules.add(new MaxLengthRule());
    }

    public boolean validate() {
        boolean valid = true;

        List<View> viewWithValidations = getViewsWithValidation();
        for (View viewWithValidation : viewWithValidations) {
            for (Rule rule : rules) {
                valid = valid && rule.validate(viewWithValidation);
            }
        }

        return valid;
    }

    private List<View> getViewsWithValidation() {
        if(target.getRoot() instanceof ViewGroup) {
            return getViewsByTag((ViewGroup) target.getRoot(), R.id.hasValidation);
        }
        return Collections.singletonList(target.getRoot());
    }

    private static List<View> getViewsByTag(ViewGroup root, int tagId) {
        List<View> views = new ArrayList<>();
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tagId));
            }

            final Object hasValidation = child.getTag(tagId);
            if (hasValidation != null && (Boolean)hasValidation) {
                views.add(child);
            }

        }
        return views;
    }
}
