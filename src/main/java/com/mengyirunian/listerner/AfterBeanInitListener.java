package com.mengyirunian.listerner;

import com.mengyirunian.entity.WeixinInfo;
import com.mengyirunian.entity.WeixinInfoCriteria;
import com.mengyirunian.mapper.WeixinInfoMapper;
import com.mengyirunian.weixin.WeixinTool;
import com.mengyirunian.weixin.WxConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

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
    @Autowired
    private WeixinInfoMapper weixinInfoMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        addModuleAndAction(event);// 添加模块与功能
    }

    private void addModuleAndAction(ContextRefreshedEvent event) {
        final WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        WeixinInfoCriteria weixinInfoCriteria = new WeixinInfoCriteria();
        weixinInfoCriteria.createCriteria();
        List<WeixinInfo> weixinInfos = weixinInfoMapper.selectByExample(weixinInfoCriteria);
        for(WeixinInfo weixinInfo : weixinInfos) {
            if("token".equals(weixinInfo.getKeyName())) {
                config.setToken(weixinInfo.getValueName().trim());
            }
            if("appid".equals(weixinInfo.getKeyName())) {
                config.setAppId(weixinInfo.getValueName().trim());
            }
            if("appsecret".equals(weixinInfo.getKeyName())) {
                config.setSecret(weixinInfo.getValueName().trim());
            }
            if("aesKey".equals(weixinInfo.getKeyName())) {
                config.setAesKey(weixinInfo.getValueName().trim());
            }
        }
        weixinTool.setWxMpConfigStorage(config);
    }

}
