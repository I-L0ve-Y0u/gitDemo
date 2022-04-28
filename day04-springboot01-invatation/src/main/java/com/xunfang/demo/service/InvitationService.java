package com.xunfang.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xunfang.demo.entity.Invitation;

public interface InvitationService extends IService<Invitation> {


    PageInfo getInvitationListByPB(String searchTitle, Integer pageNum);

    boolean removeById(Integer id);
}
