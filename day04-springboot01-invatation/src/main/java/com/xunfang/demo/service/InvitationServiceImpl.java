package com.xunfang.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xunfang.demo.dao.InvitationMapper;
import com.xunfang.demo.dao.ReplyDetailMapper;
import com.xunfang.demo.entity.Invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Transactional
public class InvitationServiceImpl extends ServiceImpl<InvitationMapper,Invitation> implements InvitationService {

    @Autowired(required = false)
    private InvitationMapper invitationMapper;
    @Autowired(required = false)
    private ReplyDetailMapper replyDetailMapper;


    @Override
    public PageInfo getInvitationListByPB(String searchTitle, Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Invitation> list = invitationMapper.selectInvitationBySome(searchTitle);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public boolean removeById(Integer id) {
        try {
            replyDetailMapper.deleteReplyDetailByInvid(id);
            invitationMapper.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;

        }

    }
}
