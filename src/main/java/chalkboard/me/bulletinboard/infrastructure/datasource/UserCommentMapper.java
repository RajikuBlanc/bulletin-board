package chalkboard.me.bulletinboard.infrastructure.datasource;

import chalkboard.me.bulletinboard.application.dto.UserCommentDto;
import chalkboard.me.bulletinboard.application.dto.UserCommentRead;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserCommentMapper {
    @Insert("sql/insertUserComment.sql")
    void insert(@Param("dto") UserCommentDto dto);

    @Select("sql/selectUserComment.sql")
    List<UserCommentRead> select();

    @Select("sql/selectMyComment.sql")
    List<UserCommentRead> selectById(@Param("userId") String userId);
}