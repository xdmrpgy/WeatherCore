package com.landicorp.android.weathercore.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.widget.TextView;

import com.landicorp.android.library.base.BaseActivity;
import com.landicorp.android.weathercore.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by panguangyi on 2017-05-25.
 */

public class WelcomeActivity extends BaseActivity {
    private static final String TAG = "WelcomeActivity";
    public static final String DEFAULT_USERNAME = "11";
    public static final String DEFAULT_PASSWORD = "22";
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.et_username)
    TextInputEditText etUserName;
    @BindView(R.id.et_password)
    TextInputEditText etPassword;

    @BindView(R.id.btn_click)
    FloatingActionButton btnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_click)
    public void onClick() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(userName)){
            etUserName.setError("用户名不能为空！");
            return;
        }else if (TextUtils.isEmpty(password)){
            etPassword.setError("密码不能为空！");
            return;
        }else if (!userName.equals(DEFAULT_USERNAME) || !password.equals(DEFAULT_PASSWORD)){
            etUserName.setError("用户名或者密码错误！");
            etPassword.setError("用户名或者密码错误！");
            return;
        }else {
            Intent intent = new Intent(WelcomeActivity.this,ProvinceActivity.class);
            startActivity(intent);
        }
    }
}
