package com.example.demo.entity;

import java.util.Date;

/**
 * @author sxp
 * @create 2019-02-02 17:31
 **/
public class PageView {
    private String pageUrl;
    private String userIp;
    private String userName;
    private Date time;

    public PageView(String pageUrl, String userIp, String userName, Date time) {
        this.pageUrl = pageUrl;
        this.userIp = userIp;
        this.userName = userName;
        this.time = time;
    }

    public PageView() {
    }

    @Override
    public String toString() {
        return "PageView{" +
                "pageUrl='" + pageUrl + '\'' +
                ", userIp='" + userIp + '\'' +
                ", userName='" + userName + '\'' +
                ", time=" + time +
                '}';
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
