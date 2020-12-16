package first.test.a12161.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<p> extends AppCompatActivity {
    private p persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if(persenter==null){
            persenter=getPersenter();
        }
        initData();
        initView();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract p getPersenter();

    protected abstract int getLayoutID();
}
