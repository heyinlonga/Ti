package first.test.a12161;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import first.test.a12161.view.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tv_text;
    int sum=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what==1){
                tv_text.setText("倒计时"+sum);
                sum--;
                if(sum==0){
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }else{
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text =findViewById(R.id.tv_text);
        handler.sendEmptyMessageDelayed(1,1000);
    }
}