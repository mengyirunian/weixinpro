package com.mengyirunian.mapper;

import com.mengyirunian.entity.Kjlx;
import com.mengyirunian.entity.KjlxCriteria;
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

public interface KjlxMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @SelectProvider(type=KjlxSqlProvider.class, method="countByExample")
    int countByExample(KjlxCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @DeleteProvider(type=KjlxSqlProvider.class, method="deleteByExample")
    int deleteByExample(KjlxCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @Delete({
        "delete from t_kjlx",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @Insert({
        "insert into t_kjlx (name, simple_name, ",
        "kjlx)",
        "values (#{name,jdbcType=VARCHAR}, #{simpleName,jdbcType=VARCHAR}, ",
        "#{kjlx,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Kjlx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @InsertProvider(type=KjlxSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Kjlx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @SelectProvider(type=KjlxSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="kjlx", property="kjlx", jdbcType=JdbcType.VARCHAR)
    })
    List<Kjlx> selectByExampleWithRowbounds(KjlxCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @SelectProvider(type=KjlxSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="kjlx", property="kjlx", jdbcType=JdbcType.VARCHAR)
    })
    List<Kjlx> selectByExample(KjlxCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @Select({
        "select",
        "id, name, simple_name, kjlx",
        "from t_kjlx",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="kjlx", property="kjlx", jdbcType=JdbcType.VARCHAR)
    })
    Kjlx selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @UpdateProvider(type=KjlxSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Kjlx record, @Param("example") KjlxCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @UpdateProvider(type=KjlxSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Kjlx record, @Param("example") KjlxCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @UpdateProvider(type=KjlxSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Kjlx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_kjlx
     *
     * @mbggenerated Sat Apr 21 01:29:45 CST 2018
     */
    @Update({
        "update t_kjlx",
        "set name = #{name,jdbcType=VARCHAR},",
          "simple_name = #{simpleName,jdbcType=VARCHAR},",
          "kjlx = #{kjlx,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Kjlx record);
}