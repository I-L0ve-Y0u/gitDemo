package com.xunfang.demo;

import com.github.pagehelper.PageInfo;
import com.xunfang.demo.service.InvitationService;
import com.xunfang.demo.service.ReplyDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Day04Springboot01InvatationApplicationTests {

    @Autowired
    InvitationService invitationService;
    @Autowired
    ReplyDetailService replyDetailService;

    @Test
    void contextLoads() {
        PageInfo listByPB = invitationService.getInvitationListByPB(null, 1);
        List list = listByPB.getList();
        list.forEach(System.out::println);
    }

    @Test
    public void test01(){
        PageInfo replyDetailByPB = replyDetailService.getReplyDetailByPB(1, 2);
        List list = replyDetailByPB.getList();
        list.forEach(System.out::println);

    }

}
