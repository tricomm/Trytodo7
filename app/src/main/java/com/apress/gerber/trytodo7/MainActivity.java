package com.apress.gerber.trytodo7;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bn = (Button) findViewById(R.id.button); //find button
        bn.setOnClickListener(new View.OnClickListener() {  //匿名类继承自View.OnClickListener()
            @Override//登陆键
            public void onClick(final View view) {                //重载onclick
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                //定义一个 alert dialog 在this activity内
                final View view1=getLayoutInflater().inflate(R.layout.diybox,null);
                //定义一个 inflater
                builder.setView(view1)
                        .setTitle("Login")  //标题
                        .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                TextView tv_name = view1.findViewById(R.id.editTextname);
                                TextView tv_password = view1.findViewById(R.id.editTextpassword);
                                if(tv_name.getText().toString().equals("abc") && tv_password.getText().toString().equals("123"))
                                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(MainActivity.this,"登陆失败，密码或用户名错误",Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });

    }
}
