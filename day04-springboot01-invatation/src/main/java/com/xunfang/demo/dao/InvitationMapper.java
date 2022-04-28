package com.xunfang.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunfang.demo.entity.Invitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.stream.BaseStream;

public interface InvitationMapper extends BaseMapper<Invitation> {

    List<Invitation> selectInvitationBySome(@Param("searchTitle") String searchTitle);
}