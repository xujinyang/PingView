# PingView
基于LDNetDiagnoService_Android开发的一个网络诊断的View，主要是方便引用

# 效果

![](http://7o4zmy.com1.z0.glb.clouddn.com/QQ20170110-145111.png)


and

![](http://7o4zmy.com1.z0.glb.clouddn.com/QQ20170110-145129.png)

# Usage
### Step 1
##### Install with gradle
        dependencies {
            compile 'com.xujinyang.pingview:pinglib:1.0.3'
        }
### Step 2

     <me.jamesxu.pinglib.view.PingView
        android:id="@+id/ping_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/black" />
       

### Step 3
```
  PingView pingView = (PingView) findViewById(R.id.ping_view);
        pingView.setDeviceId("12312424423");
        pingView.setUserId("342");
        pingView.setVersionName("1.1.1");
        pingView.pingHost("www.baidu.com");

```
# Thanks

https://github.com/Lede-Inc/LDNetDiagnoService_Android

License
--------
PingView is opensource, contribution and feedback are welcomed

[Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

    Copyright 2015 Supercharge

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 
## About me
[CSDN](http://blog.csdn.net/mobilexu)

[weibo](http://weibo.com/3654795601/profile?topnav=1&wvr=6)
