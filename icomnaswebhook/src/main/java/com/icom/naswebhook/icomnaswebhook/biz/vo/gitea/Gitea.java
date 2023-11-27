package com.icom.naswebhook.icomnaswebhook.biz.vo.gitea;

import com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Gitea {
    public String ref;
    public String before;
    public String after;
    public String compare_url;
    public ArrayList<Commit> commits;
    public int total_commits;
    public HeadCommit head_commit;
    public Repository repository;
    public Pusher pusher;
    public Sender sender;

    @Builder
    public Gitea(String ref, String before, String after, String compare_url, ArrayList<Commit> commits, int total_commits, HeadCommit head_commit, Repository repository, Pusher pusher, Sender sender) {
        this.ref = ref;
        this.before = before;
        this.after = after;
        this.compare_url = compare_url;
        this.commits = commits;
        this.total_commits = total_commits;
        this.head_commit = head_commit;
        this.repository = repository;
        this.pusher = pusher;
        this.sender = sender;
    }
}
