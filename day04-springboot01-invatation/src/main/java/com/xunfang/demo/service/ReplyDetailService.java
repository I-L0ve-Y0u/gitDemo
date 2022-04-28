package com.xunfang.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xunfang.demo.entity.ReplyDetail;

public interface ReplyDetailService extends IService<ReplyDetail> {


    PageInfo getReplyDetailByPB(Integer id, Integer pageNum);


    boolean insertReplyDerailBySome(ReplyDetail replyDetail);
}
