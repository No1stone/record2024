package com.origemite.jooqexame.data.db.entity.case1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Table(name = "CASE1_VIEW")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Case1View {

    @Id
    @Column(name = "profile_id", nullable = false, length = 50)
    private String profileId;

    @Column(name = "profile_type", nullable = false, length = 50)
    private String profileType;

    @Column(name = "profile_name", nullable = false, length = 50)
    private String profileName;


    @Builder
    public Case1View(String profileType, String profileId, String profileName) {
        this.profileType = profileType;
        this.profileId = profileId;
        this.profileName = profileName;
    }
}
