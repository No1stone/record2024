package com.origemite.querytouble.data.db.entity.case2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "CASE2_AND1")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Case2And1 {

    @Id
    @Column(name = "AND1_ID", nullable = false, length = 50)
    private String and1Id;

    @Column(name = "ID", nullable = false, length = 50)
    private String id;

    @Column(name = "AND1_STATUS", nullable = false, length = 50)
    private String and1Status;

    @Builder
    public Case2And1(String and1Id, String id, String and1Status) {
        this.and1Id = and1Id;
        this.id = id;
        this.and1Status = and1Status;
    }

}
