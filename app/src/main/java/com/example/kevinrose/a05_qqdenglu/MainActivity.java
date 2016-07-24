package com.example.kevinrose.a05_qqdenglu;

import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed_qqnumber;
    private EditText ed_qqpassword;
    private Button  button;
    private CheckBox remember_name,remember_pass;
    public String qqnumber,qqpassword;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_qqnumber=(EditText) findViewById(R.id.Edit1);
        ed_qqpassword=(EditText)findViewById(R.id.Edit2);
        button=(Button)findViewById(R.id.button);
        remember_name=(CheckBox)findViewById(R.id.checkBox);
        remember_pass=(CheckBox)findViewById(R.id.checkBox1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Click login button");
                qqnumber=ed_qqnumber.getText().toString();
                qqpassword=ed_qqnumber.getText().toString();
                boolean namerem=remember_name.isChecked();
                boolean passrem=remember_pass.isChecked();
                if(namerem&&passrem)
                {
                    System.out.println("都勾选了");
                    //context:上下文
                    //text:要给用户提示的消息
                    //duration:消息持续的时间
                    Toast.makeText(MainActivity.this,"全部记住",Toast.LENGTH_SHORT).show();
                }
                else if(namerem&&!passrem)
                {
                    System.out.println("记住用户名，没有记住密码");
                    Toast.makeText(MainActivity.this,"记住了用户名",Toast.LENGTH_SHORT).show();
                }
                else if(!namerem&&passrem)
                {
                    System.out.println("记住了密码，没有记住用户名");
                    Toast.makeText(MainActivity.this,"记住了密码",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    System.out.println("都没有记住");
                    Toast.makeText(MainActivity.this,"未记住",Toast.LENGTH_SHORT).show();
                }
                //判断是否勾选了checkbox，如果是就讲QQ号和密码保存起来
            }
        });
    }

}
