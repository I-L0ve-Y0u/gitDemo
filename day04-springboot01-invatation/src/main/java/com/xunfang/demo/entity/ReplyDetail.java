package com.xunfang.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

//@ToString
@TableName("reply_detail")
public class ReplyDetail {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer invid;

    private String content;

    private String author;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvid() {
        return invid;
    }

    public void setInvid(Integer invid) {
        this.invid = invid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "ReplyDetail{" +
                "id=" + id +
                ", invid=" + invid +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}