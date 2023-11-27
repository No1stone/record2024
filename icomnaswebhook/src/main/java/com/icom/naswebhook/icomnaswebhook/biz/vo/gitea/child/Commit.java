package com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commit {
    public String id;
    public String message;
    public String url;
    public Author author;
    public Committer committer;
    public Date timestamp;
    public ArrayList<Object> added;
    public ArrayList<Object> removed;
    public ArrayList<String> modified;
}
