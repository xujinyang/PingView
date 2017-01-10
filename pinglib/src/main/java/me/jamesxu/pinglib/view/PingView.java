package me.jamesxu.pinglib.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;

import me.jamesxu.pinglib.service.LDNetDiagnoListener;
import me.jamesxu.pinglib.service.LDNetDiagnoService;

/**
 * Created by mobilexu on 2017/1/9.
 */

public class PingView extends ScrollView implements LDNetDiagnoListener {
    private LDNetDiagnoService _netDiagnoService;
    private LDNetDiagnoListener listener;
    private TextView textView;
    private String showInfo = "";
    private String userId = "--";
    private String deviceId = "--";
    private String versionName = "0.0.0";

    public PingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        textView = new TextView(context);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(16);
        addView(textView);
    }

    public void pingHost(String host) {
        _netDiagnoService = new LDNetDiagnoService(getContext(), getContext().getPackageName()
                , versionName, userId,
                deviceId, host, this);
        _netDiagnoService.execute();
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void cancelPing() {
        _netDiagnoService.cancel(true);
        _netDiagnoService = null;
    }

    public String getPingLog() {
        return showInfo;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (_netDiagnoService != null) {
            _netDiagnoService.stopNetDialogsis();
        }
    }

    @Override
    public void OnNetDiagnoFinished(String log) {
        if (listener != null) {
            listener.OnNetDiagnoFinished(log);
        }
        setText(log);
        fullScroll(ScrollView.FOCUS_DOWN);
    }

    public void setLDNetDiagnoListener(LDNetDiagnoListener listener) {
        this.listener = listener;
    }

    private void setText(String log) {
        textView.setText(log);
    }

    @Override
    public void OnNetDiagnoUpdated(String log) {
        if (listener != null) {
            listener.OnNetDiagnoUpdated(log);
        }
        showInfo += log;
        setText(showInfo);
        fullScroll(ScrollView.FOCUS_DOWN);
    }
}
