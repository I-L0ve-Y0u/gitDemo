package com.xunfang.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunfang.demo.entity.ReplyDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyDetailMapper extends BaseMapper<ReplyDetail> {
    int deleteByPrimaryKey(Integer id);

    int insert(ReplyDetail record);

    int insertSelective(ReplyDetail record);

    ReplyDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReplyDetail record);

    int updateByPrimaryKey(ReplyDetail record);

    @Select("select * from reply_detail where invid = #{id} order by id desc ")
    List<ReplyDetail> selectReplyDetailById(@Param("id") Integer id);

    @Delete(" delete from reply_detail where invid = #{id} ")
    int deleteReplyDetailByInvid(Integer id);


}