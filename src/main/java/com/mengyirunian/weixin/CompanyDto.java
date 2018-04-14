package com.mengyirunian.weixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Jiaxiayuan on 2018/4/14
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDto {

    private String name;
    private String simpleName;

    private Integer jstb;
    private String zdt;
    private Integer skd;
    private Integer zhd;
    private Integer gxjs;
    private Integer nylt;
    private String jrsx;
    private String ssqk;
    private Integer xsb;
    private Integer jk2016;
    private Integer jk2017;
    private Integer ck2016;
    private Integer ck2017;

}
