package com.pbn.kevin.test;

import com.pbn.kevin.util.ConfigUtil;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LWS
 * @Date: 2020/12/24 10:44
 */
public class DelayedElement implements Delayed {

    //延迟时间
    private final long delay;
    //到期时间
    private final long expire;
    //数据
    private final String msg;
    //创建时间
    private final long now;

    public DelayedElement(long delay, String msg) {
        this.delay = delay;
        this.msg = msg;
        //到期时间 = 当前时间+延迟时间
        expire = System.currentTimeMillis() + delay;
        now = System.currentTimeMillis();
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
    }


    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) -o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DelayedElement{");
        sb.append("delay=").append(delay);
        sb.append(", expire=").append(ConfigUtil.formatDate24(new Date(expire)));
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", now=").append(ConfigUtil.formatDate24(new Date(now)));
        sb.append('}');
        return sb.toString();
    }
}
