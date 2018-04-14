package com.mengyirunian.listerner;

import com.mengyirunian.weixin.WeixinTool;
import com.mengyirunian.weixin.WxConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Jiaxiayuan on 2018/1/12
 */
@Slf4j
@Component
public class AfterBeanInitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private WeixinTool weixinTool;
    @Autowired
    private WxConfig wxConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        addModuleAndAction(event);// 添加模块与功能
    }

    private void addModuleAndAction(ContextRefreshedEvent event) {
        final WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(wxConfig.getAppid());
        config.setToken(wxConfig.getToken());
        config.setSecret(wxConfig.getAppsecret());
        weixinTool.setWxMpConfigStorage(config);
    }

}
