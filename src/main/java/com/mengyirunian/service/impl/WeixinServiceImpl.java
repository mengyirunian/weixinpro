package com.mengyirunian.service.impl;

import com.google.common.collect.Sets;
import com.mengyirunian.dao.WeixinDao;
import com.mengyirunian.entity.*;
import com.mengyirunian.service.interfaces.WeixinService;
import com.mengyirunian.weixin.CompanyDto;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    private static final String BIND_STR = "@bind";
    private static final String INFO_STR = "@info";
    private static final String A_STR = "@";
    private static final String TIP_STR = "1.在操作之前请先绑定。绑定格式发送：姓名@编码@bind。\n" +
            "2.查询信息请发送：姓名@info。\n" +
            "3.重新发送请发送：帮助或者help。";
    private static final String DEFAULT_STR = "请输入正确的内容";
    private static final String DE_USED = "该账号已经被绑定";
    private static final String NONBIND_STR = "您还没有绑定过，请先绑定。";
    private static final String BINDSUCC_STR = "绑定成功";
    private static final String FAIL_NAME_CODE_STR = "该姓名与编码信息有误";
    private static final String QUERY_STR = "请缩小关键词范围";

    @Autowired
    private WeixinDao weixinDao;

    @Override
    public String getMsg(WxMpXmlMessage message) {
        String fromUser = message.getFromUserName();
        String content = message.getContent();
        String msgType = message.getMsgType();
        StringBuilder sb = new StringBuilder();
        if (EVENT_STR.equals(msgType)) {
            if (SUBSCRIBE_STR.equals(message.getEvent())) {
                return TIP_STR;
            } else {
                return DEFAULT_STR;
            }
        } else if (TEXT_STR.equals(msgType)) {
            if (HELP_STR_1.equals(content) || HELP_STR_2.equals(content)) {
                return TIP_STR;
            } else if (content.endsWith(BIND_STR) || content.endsWith(INFO_STR)) {
                if (!existOpenId(fromUser) && content.endsWith(INFO_STR)) {
                    return NONBIND_STR;
                } else {
                    String[] arrStr = content.split(A_STR);
                    String name = arrStr[0].trim();
                    if (content.endsWith(BIND_STR)) {
                        String code = arrStr[1].trim();
                        boolean bind = existOpenId(fromUser);
                        if (bind) {
                            return "您的ID已被绑定，请联系管理员";
                        }
                        int flag = bindNameAndCode(name, code, fromUser);
                        return flag == 0 ? BINDSUCC_STR : (flag == -1 ? FAIL_NAME_CODE_STR : DE_USED);
                    } else if (content.endsWith(INFO_STR)) {
                        name = eliminate(name);
                        Set<String> nameSet = Sets.newHashSet();
                        List<Jstb> jstbList = weixinDao.getJstbList(name);
                        if (jstbList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Zdt> zdtList = weixinDao.getZdtList(name);
                        if (zdtList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Skd> skdList = weixinDao.getSkdList(name);
                        if (skdList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Zhd> zhdList = weixinDao.getZhdList(name);
                        if (zhdList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Gxjs> gxjsList = weixinDao.getGxjsList(name);
                        if (gxjsList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Kjlx> kjlxList = weixinDao.getKjlxList(name);
                        if (kjlxList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Nylt> nyltList = weixinDao.getNyltList(name);
                        if (nyltList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Jrsx> jrsxList = weixinDao.getJrsxList(name);
                        if (jrsxList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Ssqk> ssqkList = weixinDao.getSsqkList(name);
                        if (ssqkList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Xsb> xsbList = weixinDao.getXsbList(name);
                        if (xsbList.size() > 1) {
                            return QUERY_STR;
                        }
                        List<Jck> jckList = weixinDao.getJckList(name);
                        if (jckList.size() > 1) {
                            return QUERY_STR;
                        }

                        CompanyDto companyDto = new CompanyDto();
                        companyDto.setSimpleName(name);
                        //结算通宝
                        if (jstbList.size() == 1) {
                            companyDto.setName(jstbList.get(0).getName());
                            companyDto.setJstb(jstbList.get(0).getAmount());
                            nameSet.add(jstbList.get(0).getName());
                        } else {
                            companyDto.setJstb(0);
                        }

                        //知贷通
                        if (zdtList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(zdtList.get(0).getName());
                            }
                            nameSet.add(zdtList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setZdt(zdtList.get(0).getAmount());
                        } else {
                            companyDto.setZdt("0");
                        }

                        //苏科贷
                        if (skdList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(skdList.get(0).getName());
                            }
                            nameSet.add(skdList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setSkd(skdList.get(0).getSkd());
                        } else {
                            companyDto.setSkd(1);
                        }

                        //转化贷
                        if (zhdList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(zhdList.get(0).getName());
                            }
                            nameSet.add(zhdList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setZhd(zhdList.get(0).getZhd());
                        } else {
                            companyDto.setZhd(1);
                        }

                        //高新技术
                        if (gxjsList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(gxjsList.get(0).getName());
                            }
                            nameSet.add(gxjsList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setGxjs(gxjsList.get(0).getGxjs());
                        } else {
                            companyDto.setGxjs(1);
                        }

                        //科技类型
                        if (kjlxList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(kjlxList.get(0).getName());
                            }
                            nameSet.add(kjlxList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setKjlx(kjlxList.get(0).getKjlx());
                        } else {
                            companyDto.setKjlx("无");
                        }

                        //农业龙头
                        if (nyltList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(nyltList.get(0).getName());
                            }
                            nameSet.add(nyltList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setNylt(nyltList.get(0).getNylt());
                        } else {
                            companyDto.setNylt(1);
                        }

                        // 金融授信
                        if (jrsxList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(jrsxList.get(0).getName());
                            }
                            nameSet.add(jrsxList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setJrsx(jrsxList.get(0).getJrsx());
                        } else {
                            companyDto.setJrsx("0");
                        }

                        // 上市情况
                        if (ssqkList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(ssqkList.get(0).getName());
                            }
                            nameSet.add(ssqkList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setSsqk(ssqkList.get(0).getType());
                        } else {
                            companyDto.setSsqk("否");
                        }

                        // 新三板
                        if (xsbList.size() == 1) {
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(xsbList.get(0).getName());
                            }
                            nameSet.add(xsbList.get(0).getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setXsb(xsbList.get(0).getXsb());
                        } else {
                            companyDto.setXsb(1);
                        }

                        // 进出口
                        if (jckList.size() == 1) {
                            Jck jck = jckList.get(0);
                            if (StringUtils.isEmpty(companyDto.getName())) {
                                companyDto.setName(jck.getName());
                            }
                            nameSet.add(jck.getName());
                            if (nameSet.size() > 1) {
                                return QUERY_STR;
                            }
                            companyDto.setJk2016(jck.getJk2016());
                            companyDto.setJk2017(jck.getJk2017());
                            companyDto.setCk2016(jck.getCk2016());
                            companyDto.setCk2017(jck.getCk2017());
                        } else {
                            companyDto.setCk2016(0);
                            companyDto.setCk2017(0);
                            companyDto.setJk2016(0);
                            companyDto.setJk2017(0);
                        }

                        if (StringUtils.isEmpty(companyDto.getName())) {
                            return "暂无该公司情况";
                        }

                        sb.append(companyDto.getName()).append("\n")
                                .append("结算通宝:").append(companyDto.getJstb()).append("万元\n")
                                .append("知贷通:").append(companyDto.getZdt()).append("万元\n")
                                .append("苏科贷:").append(companyDto.getSkd() == 0 ? "是\n" : "否\n")
                                .append("转化贷:").append(companyDto.getZhd() == 0 ? "是\n" : "否\n")
                                .append("高新技术:").append(companyDto.getGxjs() == 0 ? "是\n" : "否\n")
                                .append("科技类型:").append(companyDto.getKjlx()).append("\n")
                                .append("农业龙头:").append(companyDto.getNylt() == 0 ? "是\n" : "否\n")
                                .append("金融机构:").append(companyDto.getJrsx()).append("万元\n")
                                .append("上市情况:").append(companyDto.getSsqk()).append("\n")
                                .append("新三板:").append(companyDto.getXsb() == 0 ? "是\n" : "否\n")
                                .append("近两年进出口额:").append("进口 ")
                                .append(companyDto.getJk2016() + "," + companyDto.getJk2017()).append(";出口:")
                                .append(companyDto.getCk2016() + "," + companyDto.getCk2017()).append(" 万美元");
                        return sb.toString();
                    }
                }
            }
        }
        return DEFAULT_STR;
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
