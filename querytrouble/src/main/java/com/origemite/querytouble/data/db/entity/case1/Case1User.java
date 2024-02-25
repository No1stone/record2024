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

@Table(name = "CASE1_USER")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Case1User {

    @Id
    @Column(name = "USER_ID", nullable = false, length = 50)
    private String usrId;

    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String usrName;

    @Column(name = "CREATE_AT", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT", nullable = true)
    private LocalDateTime updateAt;

    @Builder
    public Case1User(String usrId, String usrName, LocalDateTime createAt, LocalDateTime updateAt) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
