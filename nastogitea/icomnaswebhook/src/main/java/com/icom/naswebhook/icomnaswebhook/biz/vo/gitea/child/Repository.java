package com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Repository {
    public int id;
    public Owner owner;
    public String name;
    public String full_name;
    public String description;
    public boolean empty;
    @JsonProperty("private")
    public boolean myprivate;
    public boolean fork;
    public boolean template;
    public boolean mirror;
    public int size;
    public String language;
    public String languages_url;
    public String html_url;
    public String link;
    public String ssh_url;
    public String clone_url;
    public String original_url;
    public String website;
    public int stars_count;
    public int forks_count;
    public int watchers_count;
    public int open_issues_count;
    public int open_pr_counter;
    public int release_counter;
    public String default_branch;
    public boolean archived;
    public Date created_at;
    public Date updated_at;
    public Permissions permissions;
    public boolean has_issues;
    public InternalTracker internal_tracker;
    public boolean has_wiki;
    public boolean has_pull_requests;
    public boolean has_projects;
    public boolean ignore_whitespace_conflicts;
    public boolean allow_merge_commits;
    public boolean allow_rebase;
    public boolean allow_rebase_explicit;
    public boolean allow_squash_merge;
    public boolean allow_rebase_update;
    public boolean default_delete_branch_after_merge;
    public String default_merge_style;
    public boolean default_allow_maintainer_edit;
    public String avatar_url;
    public boolean internal;
    public String mirror_interval;
    public Date mirror_updated;
}
