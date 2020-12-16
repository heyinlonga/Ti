package first.test.a12161.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import first.test.a12161.R;

public class LoginActivity extends AppCompatActivity {
    private EditText mEt_name;
    private EditText mEt_pwd;
    private Button mBtn_login;
    private SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEt_name =findViewById(R.id.et_name);
        mEt_pwd =findViewById(R.id.et_pwd);

        SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);
        boolean flag = name.getBoolean("flag", false);
        edit = name.edit();
        if(flag){
            startActivity(new Intent(LoginActivity.this,Homectivity.class));
        }
        mBtn_login =findViewById(R.id.btn_login);
        mBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }
    private void login() {
        String s = mEt_name.getText().toString();
        String s1 = mEt_pwd.getText().toString();
        if(s.equals("2003")&& s1.equals("2003")){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,Homectivity.class));
            edit.putBoolean("flag",true);
            edit.commit();
        }else{
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}