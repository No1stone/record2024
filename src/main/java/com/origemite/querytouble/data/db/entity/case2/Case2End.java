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

@Table(name = "CASE2_END")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Case2End {

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    private String id;

    @Column(name = "END_POINT", nullable = false, length = 50)
    private String endPoint;

    @Builder
    public Case2End(String id, String endPoint) {
        this.id = id;
        this.endPoint = endPoint;
    }


}
