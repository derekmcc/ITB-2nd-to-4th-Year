package com.example.derek.lab2part2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText txtName, txtPassword, txtEmail, txtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSubmitOC(View view) {
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        txtName = (EditText) findViewById(R.id.editTextName);
        txtPassword = (EditText)findViewById(R.id.editTextPassword);
        txtNumber = (EditText)findViewById(R.id.editTextNumber);
        txtEmail = (EditText)findViewById(R.id.editTextEmail);

        if (txtName.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(), "Name is a required Field", Toast.LENGTH_SHORT).show();
            txtName.requestFocus();
        }else if (txtPassword.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(), "Password is a required Field", Toast.LENGTH_SHORT).show();
            txtPassword.requestFocus();
        }else if (txtNumber.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(), "Phone number is a required Field", Toast.LENGTH_SHORT).show();
            txtNumber.requestFocus();
        }else if (txtEmail.getText().toString().matches("") || !validate(txtEmail.getText().toString())){
            Toast.makeText(getApplicationContext(), "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            txtEmail.requestFocus();
        }else {
           // Toast.makeText(getApplicationContext(), "Thank you, your request is being processed", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL,new String[] {txtEmail.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, txtName.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, "Message for the body of the email!!!!");
            intent.setType("text/plain");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }//end if
        }//end else


    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}
