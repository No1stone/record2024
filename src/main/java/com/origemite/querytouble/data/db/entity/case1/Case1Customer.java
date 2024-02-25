package com.origemite.querytouble.data.db.entity.case1;

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

@Table(name = "CASE1_CUSTMER")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Case1Customer {

    @Id
    @Column(name = "CTM_ID", nullable = false, length = 50)
    private String ctmId;

    @Column(name = "CTM_NAME", nullable = false, length = 50)
    private String ctmName;

    @Column(name = "CREATE_AT", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT", nullable = true)
    private LocalDateTime updateAt;

    @Builder
    public Case1Customer(String ctmId, String ctmName, LocalDateTime createAt, LocalDateTime updateAt) {
        this.ctmId = ctmId;
        this.ctmName = ctmName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
