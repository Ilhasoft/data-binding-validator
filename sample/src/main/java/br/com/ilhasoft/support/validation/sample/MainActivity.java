package br.com.ilhasoft.support.validation.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

import br.com.ilhasoft.support.validation.Validator;
import br.com.ilhasoft.support.validation.sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private Validator validator;

    @Override
    public void onValidationSuccess() {
        saveToDatabase();
    }

    @Override
    public void onValidationError() {
        Toast.makeText(MainActivity.this, "Dados inválidos!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.validateName.setOnClickListener(onValidateNameClickListener);
        binding.validateMultiple.setOnClickListener(onValidateMultipleClickListener);
        binding.validate.setOnClickListener(onValidateAllClickListener);
        binding.toValidate.setOnClickListener(onValidateAllWithListenerClickListener);

        binding.password.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override public void afterTextChanged(Editable s) {
                validator.validate(binding.password);
            }
        });

        validator = new Validator(binding);
        validator.setValidationListener(this);
        validator.enableFormValidationMode();
    }

    private View.OnClickListener onValidateNameClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validator.validate(binding.name);
        }
    };

    private View.OnClickListener onValidateMultipleClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validator.validate(Arrays.asList(binding.username, binding.email));
        }
    };

    private View.OnClickListener onValidateAllClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validator.validate()) {
                saveToDatabase();
            } else {
                Toast.makeText(MainActivity.this, "Dados inválidos!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener onValidateAllWithListenerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validator.toValidate();
        }
    };

    private void saveToDatabase() {
        Log.i(TAG, "Salvar os dados no banco de dados");
    }

    /**
     * Validate the password has a number an upper case character and a lower case character.
     *
     * Note: This is called through the following tag in activity_main:
     * app:validateCustom='@{"br.com.ilhasoft.support.validation.sample.MainActivity.validatePassword"}'
     * @param password the string under test
     * @return true if it's valid
     */
    public static boolean validatePassword(String password){
        return password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*");
    }

}
