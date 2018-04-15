package com.mengyirunian.dao;

import com.google.common.collect.Lists;
import com.mengyirunian.entity.*;
import com.mengyirunian.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Jiaxiayuan on 2018/4/14
 */
@Repository
@Slf4j
public class WeixinDao {
    
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JstbMapper jstbMapper;
    @Autowired
    private ZdtMapper zdtMapper;
    @Autowired
    private SkdMapper skdMapper;
    @Autowired
    private ZhdMapper zhdMapper;
    @Autowired
    private GxjsMapper gxjsMapper;
    @Autowired
    private NyltMapper nyltMapper;
    @Autowired
    private JrsxMapper jrsxMapper;
    @Autowired
    private SsqkMapper ssqkMapper;
    @Autowired
    private XsbMapper xsbMapper;
    @Autowired
    private JckMapper jckMapper;
    
    public boolean existOpenId(String fromUser) {
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andOpenidEqualTo(fromUser);
        return !CollectionUtils.isEmpty(userMapper.selectByExample(userCriteria));
    }

    public int bindNameAndCode(String name, String code, String fromUser) {
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andNameEqualTo(name).andCodeEqualTo(code);
        List<User> userList = userMapper.selectByExample(userCriteria);
        if (CollectionUtils.isEmpty(userList)) {
            return -1;
        }
        User user = userList.get(0);
        if (!StringUtils.isEmpty(user.getOpenid())) {
            return -2;
        }
        user.setOpenid(fromUser);
        userMapper.updateByPrimaryKey(user);
        return 0;
    }

    public List<Jstb> getJstbList(String name) {
        JstbCriteria jstbCriteria = new JstbCriteria();
        jstbCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Jstb> jstbList = jstbMapper.selectByExample(jstbCriteria);
        return CollectionUtils.isEmpty(jstbList) ? Lists.newArrayList() : jstbList;
    }

    public List<Zdt> getZdtList(String name) {
        ZdtCriteria zdtCriteria = new ZdtCriteria();
        zdtCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Zdt> zdtList = zdtMapper.selectByExample(zdtCriteria);
        return CollectionUtils.isEmpty(zdtList) ? Lists.newArrayList() : zdtList;
    }

    public List<Skd> getSkdList(String name) {
        SkdCriteria skdCriteria = new SkdCriteria();
        skdCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Skd> skdList = skdMapper.selectByExample(skdCriteria);
        return CollectionUtils.isEmpty(skdList) ? Lists.newArrayList() : skdList;
    }


    public List<Zhd> getZhdList(String name) {
        ZhdCriteria zhdCriteria = new ZhdCriteria();
        zhdCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Zhd> zhdList = zhdMapper.selectByExample(zhdCriteria);
        return CollectionUtils.isEmpty(zhdList) ? Lists.newArrayList() : zhdList;
    }

    public List<Gxjs> getGxjsList(String name) {
        GxjsCriteria gxjsCriteria = new GxjsCriteria();
        gxjsCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Gxjs> gxjsList = gxjsMapper.selectByExample(gxjsCriteria);
        return CollectionUtils.isEmpty(gxjsList) ? Lists.newArrayList() : gxjsList;
    }

    public List<Nylt> getNyltList(String name) {
        NyltCriteria nyltCriteria = new NyltCriteria();
        nyltCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Nylt> nyltList = nyltMapper.selectByExample(nyltCriteria);
        return CollectionUtils.isEmpty(nyltList) ? Lists.newArrayList() : nyltList;
    }

    public List<Jrsx> getJrsxList(String name) {
        JrsxCriteria jrsxCriteria = new JrsxCriteria();
        jrsxCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Jrsx> jrsxList = jrsxMapper.selectByExample(jrsxCriteria);
        return CollectionUtils.isEmpty(jrsxList) ? Lists.newArrayList() : jrsxList;
    }

    public List<Ssqk> getSsqkList(String name) {
        SsqkCriteria ssqkCriteria = new SsqkCriteria();
        ssqkCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Ssqk> ssqkList = ssqkMapper.selectByExample(ssqkCriteria);
        return CollectionUtils.isEmpty(ssqkList) ? Lists.newArrayList() : ssqkList;
    }


    public List<Xsb> getXsbList(String name) {
        XsbCriteria xsbCriteria = new XsbCriteria();
        xsbCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Xsb> xsbList = xsbMapper.selectByExample(xsbCriteria);
        return CollectionUtils.isEmpty(xsbList) ? Lists.newArrayList() : xsbList;
    }

    public List<Jck> getJckList(String name) {
        JckCriteria jckCriteria = new JckCriteria();
        jckCriteria.createCriteria().andSimpleNameLike("%" + name + "%");
        List<Jck> jckList = jckMapper.selectByExample(jckCriteria);
        return CollectionUtils.isEmpty(jckList) ? Lists.newArrayList() : jckList;
    }

}
