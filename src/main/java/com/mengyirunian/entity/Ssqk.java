package com.mengyirunian.entity;

import java.io.Serializable;

public class Ssqk implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ssqk.id
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ssqk.name
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ssqk.simple_name
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    private String simpleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ssqk.type
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_ssqk
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ssqk.id
     *
     * @return the value of t_ssqk.id
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ssqk.id
     *
     * @param id the value for t_ssqk.id
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ssqk.name
     *
     * @return the value of t_ssqk.name
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ssqk.name
     *
     * @param name the value for t_ssqk.name
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ssqk.simple_name
     *
     * @return the value of t_ssqk.simple_name
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public String getSimpleName() {
        return simpleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ssqk.simple_name
     *
     * @param simpleName the value for t_ssqk.simple_name
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName == null ? null : simpleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ssqk.type
     *
     * @return the value of t_ssqk.type
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ssqk.type
     *
     * @param type the value for t_ssqk.type
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ssqk
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
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
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}