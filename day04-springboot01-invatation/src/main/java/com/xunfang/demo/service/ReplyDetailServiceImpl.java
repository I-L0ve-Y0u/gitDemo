package com.xunfang.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xunfang.demo.dao.ReplyDetailMapper;
import com.xunfang.demo.entity.ReplyDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyDetailServiceImpl extends ServiceImpl<ReplyDetailMapper,ReplyDetail> implements ReplyDetailService {
    @Autowired(required = false)
    ReplyDetailMapper replyDetailMapper;

    @Override

    public PageInfo getReplyDetailByPB(Integer id, Integer pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<ReplyDetail> list = replyDetailMapper.selectReplyDetailById(id);
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @Override
    public boolean insertReplyDerailBySome(ReplyDetail replyDetail) {



       return replyDetailMapper.insertSelective(replyDetail) > 0? true:false ;

    }

}
