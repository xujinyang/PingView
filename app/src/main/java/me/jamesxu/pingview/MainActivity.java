package me.jamesxu.pingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.jamesxu.pinglib.view.PingView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PingView pingView = (PingView) findViewById(R.id.ping_view);
        pingView.setDeviceId("12312424423");
        pingView.setUserId("342");
        pingView.setVersionName("1.1.1");
        pingView.pingHost("www.baidu.com");
    }
}
