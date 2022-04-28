package com.xunfang.demo.controller;

import com.github.pagehelper.PageInfo;
import com.xunfang.demo.entity.ReplyDetail;
import com.xunfang.demo.service.ReplyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("replyDetail")
public class ReplyDetailController {

    @Autowired
    ReplyDetailService replyDetailService;

    @RequestMapping("/getReplyDetail/{id}")
    public String getReplyDetail(@PathVariable("id") Integer id,
                                 @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                 Model model) {
        PageInfo pageInfo = replyDetailService.getReplyDetailByPB(id, pageNum);
        model.addAttribute("pageInfo", pageInfo);
        //必须要把id回显到replyDetail.jsp页面上，为点击分页做准备
        model.addAttribute("id", id);
        return "reply";
    }

    @RequestMapping("replyPostUI/{id}")
    public String replyPostUI(@PathVariable("id") Integer id,
                                    Model model){
        model.addAttribute("id" , id);
       return "replyPost";
    }

    @RequestMapping("replyPost")
    public String addReplyDetail(ReplyDetail replyDetail,Model model){
        replyDetail.setCreatedate(new Date());
        boolean b = replyDetailService.save(replyDetail);
        //boolean b = replyDetailService.insertReplyDerailBySome(replyDetail);
        if (b){
            model.addAttribute("add","success");
        }else {
            model.addAttribute("add","fail");
        }
       return "forward:/replyDetail/getReplyDetail/"+replyDetail.getInvid();

    }

}
