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

@Table(name = "CASE1_GROUP")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Case1Group {

    @Id
    @Column(name = "GRP_ID", nullable = false, length = 50)
    private String grpId;

    @Column(name = "GRP_NAME", nullable = false, length = 50)
    private String grpName;

    @Column(name = "CREATE_AT", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT", nullable = true)
    private LocalDateTime updateAt;

    @Builder
    public Case1Group(String grpId, String grpName, LocalDateTime createAt, LocalDateTime updateAt) {
        this.grpId = grpId;
        this.grpName = grpName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
