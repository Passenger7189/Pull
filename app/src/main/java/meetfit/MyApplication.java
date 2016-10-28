package meetfit;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.xutils.x;

import java.sql.Timestamp;

import entity.User;

/**
 * Created by asus on 2016/10/26.
 */
public class MyApplication extends Application {
    //    User user= new User(1);
    User user = new User(1, "周杰伦", "12345678", new Timestamp(System.currentTimeMillis()), "中国", "13045648413",
            "男", "/userHead/head1.jpg", "13045648413", "sDnjCiNyLXVrRnl/vENfId+eXwjCHc4EZ8qatDdYx6GsSdstSfZC69JujggjvWEXgZy0EzZDwnzz7hfo6H/Czw==");

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        Fresco.initialize(this);
//        RongIM.init(this);
    }
}
