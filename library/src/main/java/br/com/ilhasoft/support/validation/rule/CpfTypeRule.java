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
        return rawCpf.length() == 11
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
