package com.zjw.sy.common.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Description SY系统监听
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:41:00
 */
public class Listener implements ServletContextListener {

    private static final Log log = LogFactory.getLog(Listener.class);

    private Timer timer;

    /**
     * 初始化
     */
    public void contextInitialized(ServletContextEvent event) {
        log.info("系统启动初始化工作开始...");

        //清除系统缓存定时器
        timer = new Timer(true);
        //设置启动开始执行，每一周执行一次
//		timer.schedule(new ClearCacheTimerTask(), 0, 7*24*60*60*1000);

        log.info("系统启动初始化工作完成...");
    }

    /**
     * 销毁
     */
    public void contextDestroyed(ServletContextEvent event) {
        timer.cancel();
    }

}