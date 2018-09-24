package com.mengyirunian.entity;

import java.io.Serializable;

public class BizBus implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_biz_bus.id
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_biz_bus.name
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_biz_bus.simple_name
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    private String simpleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_biz_bus.biz_type
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    private Long bizType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_biz_bus.value
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_biz_bus.id
     *
     * @return the value of t_biz_bus.id
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_biz_bus.id
     *
     * @param id the value for t_biz_bus.id
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_biz_bus.name
     *
     * @return the value of t_biz_bus.name
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_biz_bus.name
     *
     * @param name the value for t_biz_bus.name
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_biz_bus.simple_name
     *
     * @return the value of t_biz_bus.simple_name
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public String getSimpleName() {
        return simpleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_biz_bus.simple_name
     *
     * @param simpleName the value for t_biz_bus.simple_name
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName == null ? null : simpleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_biz_bus.biz_type
     *
     * @return the value of t_biz_bus.biz_type
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public Long getBizType() {
        return bizType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_biz_bus.biz_type
     *
     * @param bizType the value for t_biz_bus.biz_type
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public void setBizType(Long bizType) {
        this.bizType = bizType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_biz_bus.value
     *
     * @return the value of t_biz_bus.value
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_biz_bus.value
     *
     * @param value the value for t_biz_bus.value
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", simpleName=").append(simpleName);
        sb.append(", bizType=").append(bizType);
        sb.append(", value=").append(value);
        sb.append("]");
        return sb.toString();
    }
}