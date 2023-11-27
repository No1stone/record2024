package com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permissions {
    public boolean admin;
    public boolean push;
    public boolean pull;
}
