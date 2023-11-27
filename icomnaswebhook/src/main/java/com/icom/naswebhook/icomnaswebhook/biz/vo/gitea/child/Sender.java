package com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sender {
    public int id;
    public String login;
    public String login_name;
    public String full_name;
    public String email;
    public String avatar_url;
    public String language;
    public boolean is_admin;
    public Date last_login;
    public Date created;
    public boolean restricted;
    public boolean active;
    public boolean prohibit_login;
    public String location;
    public String website;
    public String description;
    public String visibility;
    public int followers_count;
    public int following_count;
    public int starred_repos_count;
    public String username;
}
