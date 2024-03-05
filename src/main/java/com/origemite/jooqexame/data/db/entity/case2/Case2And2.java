package com.origemite.jooqexame.data.db.entity.case2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "CASE2_AND2")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Case2And2 {

    @Id
    @Column(name = "AND2_ID", nullable = false, length = 50)
    private String and2Id;

    @Column(name = "ID", nullable = false, length = 50)
    private String id;

    @Column(name = "AND2_STATUS", nullable = false, length = 50)
    private String and2Status;

    @Builder
    public Case2And2(String and2Id, String id, String and2Status) {
        this.and2Id = and2Id;
        this.id = id;
        this.and2Status = and2Status;
    }

}
