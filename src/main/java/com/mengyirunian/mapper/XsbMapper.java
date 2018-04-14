package com.mengyirunian.mapper;

import com.mengyirunian.entity.Xsb;
import com.mengyirunian.entity.XsbCriteria;
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

public interface XsbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @SelectProvider(type=XsbSqlProvider.class, method="countByExample")
    int countByExample(XsbCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @DeleteProvider(type=XsbSqlProvider.class, method="deleteByExample")
    int deleteByExample(XsbCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Delete({
        "delete from t_xsb",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Insert({
        "insert into t_xsb (name, simple_name, ",
        "xsb)",
        "values (#{name,jdbcType=VARCHAR}, #{simpleName,jdbcType=VARCHAR}, ",
        "#{xsb,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Xsb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @InsertProvider(type=XsbSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Xsb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @SelectProvider(type=XsbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="xsb", property="xsb", jdbcType=JdbcType.INTEGER)
    })
    List<Xsb> selectByExampleWithRowbounds(XsbCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @SelectProvider(type=XsbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="xsb", property="xsb", jdbcType=JdbcType.INTEGER)
    })
    List<Xsb> selectByExample(XsbCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Select({
        "select",
        "id, name, simple_name, xsb",
        "from t_xsb",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="simple_name", property="simpleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="xsb", property="xsb", jdbcType=JdbcType.INTEGER)
    })
    Xsb selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @UpdateProvider(type=XsbSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Xsb record, @Param("example") XsbCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @UpdateProvider(type=XsbSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Xsb record, @Param("example") XsbCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @UpdateProvider(type=XsbSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Xsb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_xsb
     *
     * @mbggenerated Sat Apr 14 13:11:05 CST 2018
     */
    @Update({
        "update t_xsb",
        "set name = #{name,jdbcType=VARCHAR},",
          "simple_name = #{simpleName,jdbcType=VARCHAR},",
          "xsb = #{xsb,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Xsb record);
}