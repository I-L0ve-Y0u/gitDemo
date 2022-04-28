package com.xunfang.demo.controller;


import com.github.pagehelper.PageInfo;
import com.xunfang.demo.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;



    @RequestMapping("list")
    public String list(@RequestParam(required = false)String searchTitle,
                       @RequestParam(required = false ,defaultValue = "1")Integer pageNum,
                       Model model){
       PageInfo pageInfo = invitationService.getInvitationListByPB(searchTitle,pageNum);
       model.addAttribute("pageInfo",pageInfo);
       model.addAttribute("searchTitle",searchTitle);


       return "list";

    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable("id") Integer id,Model model) {
        boolean bool = invitationService.removeById(id);
        if (bool) {
            model.addAttribute("del", "success");
        } else {
            model.addAttribute("del", "fail");
        }
        return "forward:/invitation/list";
    }

}
