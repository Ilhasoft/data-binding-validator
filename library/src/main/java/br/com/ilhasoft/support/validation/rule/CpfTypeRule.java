package br.com.ilhasoft.support.validation.rule;

import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.util.EditTextHandler;

/**
 * Created by john-mac on 5/14/16.
 */
public class CpfTypeRule extends TypeRule {

    public CpfTypeRule(TextView view) {
        super(view, FieldType.Cpf);
    }

    @Override
    protected boolean isValid(TextView view) {
        if (view.getText().toString().trim().replaceAll("[^\\d]", "").length() < 11)
            return false;

        String rawCPF = view.getText().toString().trim().replaceAll("[^\\d]", "");

        int stepOne = (cpfSum(rawCPF, 1) * 10) % 11;
        int stepTwo = (cpfSum(rawCPF, 2) * 10) % 11;

        return  (stepOne == Character.getNumericValue(rawCPF.charAt(9))
                && stepTwo == Character.getNumericValue(rawCPF.charAt(10)));
    }

    /**
     *
     * @param rawCPF raw CPF with length equal to 11.
     * @param step 1 or 2.
     * @return verification sum.
     */
    private int cpfSum(String rawCPF, int step) {
        int sum = 0, count = 8 + step, baseMultiplier = 9 + step;
        for (int i = 0; i < count; ++i) {
            sum += ((baseMultiplier - i) * Character.getNumericValue(rawCPF.charAt(i)));
        }
        return sum;
    }

    @Override
    protected void onValidationSucceeded(TextView view) {
        super.onValidationSucceeded(view);
        EditTextHandler.removeError(view);
    }

    @Override
    protected void onValidationFailed(TextView view) {
        super.onValidationFailed(view);
        EditTextHandler.setError(view, view.getContext().getString(R.string.error_message_cpf_validation));
    }
}
