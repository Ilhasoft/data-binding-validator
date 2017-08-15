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

package br.com.ilhasoft.support.validation;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.ilhasoft.support.validation.rule.Rule;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by john-mac on 5/14/16.
 */
public class Validator {

    private static final int FIELD_VALIDATION_MODE = 0;
    private static final int FORM_VALIDATION_MODE = 1;

    private ViewDataBinding target;
    private ValidationListener validationListener;

    private int mode = FIELD_VALIDATION_MODE;
    private final Set<View> disabledViews;

    public Validator(ViewDataBinding target) {
        this.target = target;
        this.disabledViews = new HashSet<>();
    }

    public void setValidationListener(ValidationListener validationListener) {
        this.validationListener = validationListener;
    }

    public void toValidate() {
        if (validationListener == null) throw new IllegalArgumentException("Validation listener should not be null.");

        if (validate()) {
            validationListener.onValidationSuccess();
        } else {
            validationListener.onValidationError();
        }
    }

    public boolean validate() {
        List<View> viewWithValidations = getViewsWithValidation();
        return isAllViewsValid(viewWithValidations);
    }

    public boolean validate(View view) {
        List<View> viewWithValidations = getViewsWithValidation(view);
        return isAllViewsValid(viewWithValidations);
    }

    public <ViewType extends View> boolean validate(List<ViewType> views) {
        List<View> viewWithValidations = getViewsWithValidation(views);
        return isAllViewsValid(viewWithValidations);
    }

    private boolean isAllViewsValid(List<View> viewWithValidations) {
        boolean allViewsValid = true;
        for (View viewWithValidation : viewWithValidations) {
            boolean viewValid = true;
            List<Rule> rules = (List) viewWithValidation.getTag(R.id.validator_rule);
            for (Rule rule : rules) {
                viewValid = viewValid && isRuleValid(rule);
                allViewsValid = allViewsValid && viewValid;
            }

            if(mode == FIELD_VALIDATION_MODE && !viewValid) {
                break;
            }
        }
        return allViewsValid;
    }

    private boolean isRuleValid(Rule rule) {
        return disabledViews.contains(rule.getView()) || rule.validate();
    }

    public void disableValidation(View view) {
        disabledViews.add(view);
    }

    public void enableValidation(View view) {
        disabledViews.remove(view);
    }

    public void enableFormValidationMode() {
        this.mode = FORM_VALIDATION_MODE;
    }

    public void enableFieldValidationMode() {
        this.mode = FIELD_VALIDATION_MODE;
    }

    private List<View> getViewsWithValidation() {
        if(target.getRoot() instanceof ViewGroup) {
            return ViewTagHelper.getViewsByTag((ViewGroup) target.getRoot(), R.id.validator_rule);
        }
        return Collections.singletonList(target.getRoot());
    }

    private <ViewType extends View> List<View> getViewsWithValidation(List<ViewType> views) {
        return ViewTagHelper.filterViewsWithTag(R.id.validator_rule, views);
    }

    private List<View> getViewsWithValidation(View view) {
        return ViewTagHelper.filterViewWithTag(R.id.validator_rule, view);
    }

    public interface ValidationListener {

        void onValidationSuccess();

        void onValidationError();
    }
}
