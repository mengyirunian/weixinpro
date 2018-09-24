package com.mengyirunian.service.interfaces;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage; /**
 * Created by Jiaxiayuan on 2018/4/14
 */
public interface WeixinService {

    String getMsg(WxMpXmlMessage message);

    String testName(String name);

}
