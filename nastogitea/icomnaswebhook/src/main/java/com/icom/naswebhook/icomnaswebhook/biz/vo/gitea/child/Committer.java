package com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Committer {
    public String name;
    public String email;
    public String username;
}
