package br.com.ilhasoft.support.validation.sample;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

import br.com.ilhasoft.support.validation.Validator;
import br.com.ilhasoft.support.validation.sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.validateName.setOnClickListener(onValidateNameClickListener);
        binding.validateMultiple.setOnClickListener(onValidateMultipleClickListener);
        binding.validate.setOnClickListener(onValidateAllClickListener);

        validator = new Validator(binding);
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

    private void saveToDatabase() {
        Log.i(TAG, "Salvar os dados no banco de dados");
    }

}
