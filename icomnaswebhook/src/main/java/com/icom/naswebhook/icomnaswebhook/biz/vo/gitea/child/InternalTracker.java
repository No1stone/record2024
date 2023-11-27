package com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternalTracker {
    public boolean enable_time_tracker;
    public boolean allow_only_contributors_to_track_time;
    public boolean enable_issue_dependencies;
}
