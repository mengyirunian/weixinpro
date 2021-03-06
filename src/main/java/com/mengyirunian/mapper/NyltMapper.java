package com.mengyirunian.mapper;

import com.mengyirunian.entity.Nylt;
import com.mengyirunian.entity.NyltCriteria;
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

public interface NyltMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @SelectProvider(type=NyltSqlProvider.class, method="countByExample")
    int countByExample(NyltCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @DeleteProvider(type=NyltSqlProvider.class, method="deleteByExample")
    int deleteByExample(NyltCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Delete({
        "delete from t_nylt",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Insert({
        "insert into t_nylt (name, simple_name, ",
        "nylt)",
        "values (#{name,jdbcType=VARCHAR}, #{simpleName,jdbcType=VARCHAR}, ",
        "#{nylt,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Nylt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @InsertProvider(type=NyltSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Nylt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @SelectProvider(type=NyltSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nylt", property="nylt", jdbcType=JdbcType.INTEGER)
    })
    List<Nylt> selectByExampleWithRowbounds(NyltCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @SelectProvider(type=NyltSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nylt", property="nylt", jdbcType=JdbcType.INTEGER)
    })
    List<Nylt> selectByExample(NyltCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Select({
        "select",
        "id, name, simple_name, nylt",
        "from t_nylt",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nylt", property="nylt", jdbcType=JdbcType.INTEGER)
    })
    Nylt selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @UpdateProvider(type=NyltSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Nylt record, @Param("example") NyltCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @UpdateProvider(type=NyltSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Nylt record, @Param("example") NyltCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @UpdateProvider(type=NyltSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Nylt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_nylt
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Update({
        "update t_nylt",
        "set name = #{name,jdbcType=VARCHAR},",
          "simple_name = #{simpleName,jdbcType=VARCHAR},",
          "nylt = #{nylt,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Nylt record);
}