package com.example.trainapp.login;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainapp.R;
import com.example.trainapp.service.UserService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class RegisterActivity extends AppCompatActivity {

    EditText username;
    Button register;
    Button btnCancel;


    private TextInputLayout passwordLayoutRegister;
    private TextInputEditText password;
    private TextInputLayout rePasswordLayoutRegister;
    private TextInputEditText repassword;
    private TextInputLayout ageLayoutRegister;
    private TextInputEditText age;




    RegexUtils regexUtils;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);
        findViews();

        RegexUtils regexUtils = new RegexUtils();

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String repass= repassword.getText().toString().trim();
                String agestr=age.getText().toString().trim();

                /*   注册验证    */
                if(!regexUtils.checkPassword(pass)){
                        passwordLayoutRegister.setError("密码只能且必须包含数字和字母,且在6-18位之间！");
//                    Toast.makeText(RegisterActivity.this, "密码只能且必须包含数字和字母,且在6-18位之间！", Toast.LENGTH_LONG).show();
                }else {
                    passwordLayoutRegister.setErrorEnabled(false);
                }
                if(!repass.equals(pass)){
                    rePasswordLayoutRegister.setError("两次密码不一致!");
                }else {
                    rePasswordLayoutRegister.setErrorEnabled(false);
                }
                if(!regexUtils.check_positive_int(agestr)){
                    ageLayoutRegister.setError("岁数不能小于0，且必须是整数!");
//                    Toast.makeText(RegisterActivity.this, "岁数不能小于0，且必须是整数!", Toast.LENGTH_LONG).show();
                }else {
                    ageLayoutRegister.setErrorEnabled(false);
                }
                if(regexUtils.checkPassword(pass) && repass.equals(pass) && regexUtils.check_positive_int(agestr)){

                    Log.i("TAG",name+"_"+pass+"_"+agestr+"_");
                    UserService uService=new UserService(RegisterActivity.this);
                    User user=new User();
                    user.setUsername(name);
                    user.setPassword(pass);
                    user.setAge(Integer.parseInt(agestr));

                    uService.register(user);

                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    private void findViews() {
        username=(EditText) findViewById(R.id.usernameRegister);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        register=(Button) findViewById(R.id.Register);
        passwordLayoutRegister = (TextInputLayout) findViewById(R.id.passwordLayoutRegister);
        password = (TextInputEditText) findViewById(R.id.passwordRegister);
        rePasswordLayoutRegister = (TextInputLayout) findViewById(R.id.re_passwordLayoutRegister);
        repassword= (TextInputEditText) findViewById(R.id.re_passwordRegister);
        ageLayoutRegister = (TextInputLayout) findViewById(R.id.ageLayoutRegister);
        age = (TextInputEditText) findViewById(R.id.ageRegister);
    }

}
