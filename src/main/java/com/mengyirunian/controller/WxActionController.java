package com.mengyirunian.controller;

import com.mengyirunian.service.interfaces.WeixinService;
import com.mengyirunian.weixin.WeixinTool;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Jiaxiayuan on 2018/4/14
 */
@RestController
@Api(description = "wxAction")
@Slf4j
@RequestMapping(value = "/wxaction")
public class WxActionController {

    @Autowired
    private WeixinTool weixinTool;
    @Autowired
    private WeixinService weixinService;

    @RequestMapping(value = "/accesswx", method = RequestMethod.GET)
    public void accessWxGet(HttpServletRequest request, HttpServletResponse response) {
        //微信服务器get传递的参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        log.info("signature:" + signature);
        log.info("timestamp:" + timestamp);
        log.info("nonce:" + nonce);
        log.info("echostr:" + echostr);
        boolean flag = weixinTool.checkSignature(timestamp, nonce, signature);
        log.info("checkSignature:" + flag);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (flag) {
                out.print(echostr);
            }
        } catch (Exception e) {
            log.info("微信接入发生异常", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @RequestMapping(value = "/accesswx", method = RequestMethod.POST)
    public void accessWxPost(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        WxMpXmlOutTextMessage text = null;
        try {
            WxMpXmlMessage message = WxMpXmlMessage.fromXml(request.getInputStream());
            String msg = weixinService.getMsg(message);
            text = WxMpXmlOutTextMessage
                    .TEXT()
                    .toUser(message.getFromUserName())
                    .fromUser(message.getToUserName())
                    .content(msg)
                    .build();
            out = response.getWriter();
            out.print(text.toXml());
        } catch (Exception e) {
            log.info("接收消息异常", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
