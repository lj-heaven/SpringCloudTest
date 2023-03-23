package com.test.mapper;

import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Liao
 */
@Mapper
public interface UserMapper {

    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(int uid);
}
