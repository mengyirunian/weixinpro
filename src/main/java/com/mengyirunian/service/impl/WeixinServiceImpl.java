package com.mengyirunian.service.impl;

import com.google.common.collect.Maps;
import com.mengyirunian.dao.WeixinDao;
import com.mengyirunian.entity.*;
import com.mengyirunian.enums.BizTypeEnums;
import com.mengyirunian.service.interfaces.WeixinService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiaxiayuan on 2018/4/14
 */
@Slf4j
@Service
public class WeixinServiceImpl implements WeixinService {

    private static final String EVENT_STR = "event";
    private static final String SUBSCRIBE_STR = "subscribe";
    private static final String TEXT_STR = "text";
    private static final String HELP_STR_1 = "帮助";
    private static final String HELP_STR_2 = "help";
    private static final String BIND_STR = "@绑定";
    private static final String INFO_STR = "@查查看";
    private static final String A_STR = "@";
    private static final String TIP_STR = "1.在操作之前请先绑定：姓名@7位EHR号@绑定。\n" +
            "2.查询信息请发送：姓名@查查看。\n" +
            "3.标签释义请发送：标签名称。\n"+
            "4.如需帮助请发送：帮助或者help。";
    private static final String DEFAULT_STR = "请输入正确的内容";
    private static final String DE_USED = "该账号已经被绑定";
    private static final String NONBIND_STR = "您还没有绑定过，请先绑定。";
    private static final String BINDSUCC_STR = "绑定成功";
    private static final String FAIL_NAME_CODE_STR = "该姓名与编码信息有误";
    private static final String QUERY_STR = "请缩小关键词范围";
    private static final String ID_LOCKED = "您的ID已被绑定，请联系管理员";

    @Autowired
    private WeixinDao weixinDao;

    private String dealWithEvent(WxMpXmlMessage message) {
        if (SUBSCRIBE_STR.equals(message.getEvent())) {
            return TIP_STR;
        } else {
            return DEFAULT_STR;
        }
    }

    private String queryBizContext(String name) {
        StringBuilder sb = new StringBuilder();
        String companyName = null;
        Map<Long, String> contentMap = Maps.newLinkedHashMap();
        for (BizTypeEnums bizTypeEnums : BizTypeEnums.values()) {
            if (bizTypeEnums.getType() != 0 || bizTypeEnums == BizTypeEnums.DEFAULT) {
                continue;
            }
            List<BizBus> bizBusList = weixinDao.getBizBusList(name, bizTypeEnums.getCode());
            if (bizBusList.size() > 1) {
                return QUERY_STR;
            } else if (bizBusList.size() == 1) {
                if (StringUtils.isEmpty(companyName)) {
                    companyName = bizBusList.get(0).getName();
                } else if (!companyName.equals(bizBusList.get(0).getName())) {
                    return QUERY_STR;
                }
                contentMap.put(bizTypeEnums.getCode(), bizTypeEnums.getDesc() + ":" + bizBusList.get(0).getValue());
            } else if (bizBusList.isEmpty()) {
                contentMap.put(bizTypeEnums.getCode(), bizTypeEnums.getDesc() + ":" + bizTypeEnums.getDefaultValue());
            }
        }

        // 目前特殊的只有高特精和进出口金额
        List<Gtj> gtjList = weixinDao.getGtjList(name);
        if (gtjList.size() > 1) {
            return QUERY_STR;
        } else if (gtjList.size() == 1) {
            Gtj gtj = gtjList.get(0);
            if (StringUtils.isEmpty(companyName)) {
                companyName = gtj.getName();
            } else if (!companyName.equals(gtj.getName())) {
                return QUERY_STR;
            }
            contentMap.put(BizTypeEnums.GTJ.getCode(),
                    new StringBuilder("高特精[")
                            .append("pj2016:").append(gtj.getPj2016())
                            .append(",pj2017:").append(gtj.getPj2017()).append("]").toString());
        } else {
            contentMap.put(BizTypeEnums.GTJ.getCode(),new StringBuilder("高特精[")
                    .append("pj2016:").append(BizTypeEnums.GTJ.getDefaultValue())
                    .append(",pj2017:").append(BizTypeEnums.GTJ.getDefaultValue()).append("]").toString());
        }

        // 进出口金额
        List<Jck> jckList = weixinDao.getJckList(name);
        if (jckList.size() > 1) {
            return QUERY_STR;
        } else if (jckList.size() == 1) {
            Jck jck = jckList.get(0);
            if (StringUtils.isEmpty(companyName)) {
                companyName = jck.getName();
            } else if (!companyName.equals(jck.getName())) {
                return QUERY_STR;
            }
            contentMap.put(BizTypeEnums.JCK.getCode(),
                    new StringBuilder("近两年进出口[")
                            .append("2016年进口(万美元):").append(jck.getJk2016())
                            .append(",2016年出口(万美元):").append(jck.getCk2016())
                            .append(",2017年进口(万美元):").append(jck.getJk2017())
                            .append(",2017年出口(万美元):").append(jck.getCk2017()).append("]").toString());
        }

        sb.append(companyName).append("\n");
        for (Long i = 1L; i < BizTypeEnums.values().length; i++) {
            sb.append(contentMap.get(i)).append("\n");
        }
        return sb.toString();
    }

    private String dealWithTextBiz(WxMpXmlMessage message) {
        String fromUser = message.getFromUserName();
        String content = message.getContent();
        if (!existOpenId(fromUser) && content.endsWith(INFO_STR)) {
            return NONBIND_STR;
        } else {
            String[] arrStr = content.split(A_STR);
            String name = arrStr[0].trim();
            if (content.endsWith(BIND_STR)) {
                String code = arrStr[1].trim();
                boolean bind = existOpenId(fromUser);
                if (bind) {
                    return ID_LOCKED;
                }
                int flag = bindNameAndCode(name, code, fromUser);
                switch (flag) {
                    case 0:
                        return BINDSUCC_STR;
                    case -1:
                        return FAIL_NAME_CODE_STR;
                    case -2:
                        return DE_USED;
                    default:
                        return DEFAULT_STR;
                }
            } else if (content.endsWith(INFO_STR)) {
                name = eliminate(name);
                return queryBizContext(name);
            }
        }
        return DEFAULT_STR;
    }

    @Override
    public String testName(String name) {
        String targetName = eliminate(name);
        return queryBizContext(targetName);
    }

    private String dealWithText(WxMpXmlMessage message) {
        String content = message.getContent();
        if (HELP_STR_1.equals(content) || HELP_STR_2.equals(content)) {
            return TIP_STR;
        } else if (content.endsWith(BIND_STR) || content.endsWith(INFO_STR)) {
            return dealWithTextBiz(message);
        }
        return DEFAULT_STR;
    }

    @Override
    public String getMsg(WxMpXmlMessage message) {
        String msgType = message.getMsgType();
        if (EVENT_STR.equals(msgType)) {
            return dealWithEvent(message);
        } else if (TEXT_STR.equals(msgType)) {
            String detailMsg = dealWithDetail(message);
            if (detailMsg != null) {
                return detailMsg;
            }
            return dealWithText(message);
        }
        return DEFAULT_STR;
    }

    private String dealWithDetail(WxMpXmlMessage message) {
        String content = message.getContent();
        for (BizTypeEnums bizTypeEnums : BizTypeEnums.values()) {
            if (bizTypeEnums.getDesc().contains(content)) {
                return bizTypeEnums.getDetail();
            }
        }
        return null;
    }

    private int bindNameAndCode(String name, String code, String fromUser) {
        return weixinDao.bindNameAndCode(name, code, fromUser);
    }

    private boolean existOpenId(String fromUser) {
        return weixinDao.existOpenId(fromUser);
    }

    private String eliminate(String name) {
        name = name.replace("省", "")
                .replace("市", "")
                .replace("股份", "")
                .replace("责任", "")
                .replace("有限", "")
                .replace("集团", "");
        return name;
    }

}
