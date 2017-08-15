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

import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 5/14/16.
 */
public class CpfTypeRule extends TypeRule {

    public CpfTypeRule(TextView view, String errorMessage) {
        super(view, FieldType.Cpf, errorMessage);
    }

    @Override
    protected boolean isValid(TextView view) {
        final String rawCpf = view.getText().toString().trim().replaceAll("[^\\d]", "");
        return rawCpf.length() == 11 && !onBlackList(rawCpf)
                && (cpfDv(rawCpf, 1) == Character.getNumericValue(rawCpf.charAt(9))
                && cpfDv(rawCpf, 2) == Character.getNumericValue(rawCpf.charAt(10)));
    }

    /**
     *
     * @param rawCpf raw CPF with length equal to 11.
     * @param step 1 or 2.
     * @return verification sum.
     */
    private int cpfDv(final String rawCpf, final int step) {
        final int dv = 11 - cpfSum(rawCpf, step) % 11;
        return (dv == 10 || dv == 11) ? 0 : dv;
    }

    private int cpfSum(final String rawCPF, final int step) {
        int sum = 0;
        final int count = 8 + step;
        final int baseMultiplier = 9 + step;
        for (int i = 0; i < count; ++i) {
            sum += ((baseMultiplier - i) * Character.getNumericValue(rawCPF.charAt(i)));
        }
        return sum;
    }

    // Reference: https://github.com/concretesolutions/canarinho/blob/master/canarinho/src/main/java/br/com/concretesolutions/canarinho/validator/ValidadorCPF.java
    private boolean onBlackList(String rawCpf) {
        boolean equal = true;
        for (int i = 1; i < 11 && equal; i++) {
            if (rawCpf.charAt(i) != rawCpf.charAt(0)) {
                equal = false;
            }
        }
        return equal || rawCpf.equals("12345678909");
    }

    @Override
    protected void onValidationSucceeded(TextView view) {
        super.onValidationSucceeded(view);
        EditTextHandler.removeError(view);
    }

    @Override
    protected void onValidationFailed(TextView view) {
        super.onValidationFailed(view);
        EditTextHandler.setError(view, errorMessage);
    }
}
