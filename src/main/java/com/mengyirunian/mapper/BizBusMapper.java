package com.mengyirunian.mapper;

import com.mengyirunian.entity.BizBus;
import com.mengyirunian.entity.BizBusCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface BizBusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @SelectProvider(type=BizBusSqlProvider.class, method="countByExample")
    int countByExample(BizBusCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @DeleteProvider(type=BizBusSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizBusCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @Delete({
        "delete from t_biz_bus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @Insert({
        "insert into t_biz_bus (name, simple_name, ",
        "biz_type, value)",
        "values (#{name,jdbcType=VARCHAR}, #{simpleName,jdbcType=VARCHAR}, ",
        "#{bizType,jdbcType=BIGINT}, #{value,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(BizBus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @InsertProvider(type=BizBusSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(BizBus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @SelectProvider(type=BizBusSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="biz_type", property="bizType", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    List<BizBus> selectByExampleWithRowbounds(BizBusCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @SelectProvider(type=BizBusSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="biz_type", property="bizType", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    List<BizBus> selectByExample(BizBusCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @Select({
        "select",
        "id, name, simple_name, biz_type, value",
        "from t_biz_bus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="biz_type", property="bizType", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    BizBus selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @UpdateProvider(type=BizBusSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizBus record, @Param("example") BizBusCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @UpdateProvider(type=BizBusSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizBus record, @Param("example") BizBusCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @UpdateProvider(type=BizBusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizBus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_biz_bus
     *
     * @mbggenerated Mon Sep 17 21:53:50 CST 2018
     */
    @Update({
        "update t_biz_bus",
        "set name = #{name,jdbcType=VARCHAR},",
          "simple_name = #{simpleName,jdbcType=VARCHAR},",
          "biz_type = #{bizType,jdbcType=BIGINT},",
          "value = #{value,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BizBus record);
}