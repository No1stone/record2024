package com.origemite.authserver.data.db.repo.dsl;

import com.origemite.authserver.data.db.entity.QTbPolicy;
import com.origemite.authserver.data.db.entity.QTbPolicyGroup;
import com.origemite.authserver.data.db.entity.QTbUser;
import com.origemite.authserver.data.db.entity.QTbUserPolicy;
import com.origemite.authserver.data.db.repo.dsl.vo.UserPolicyDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class TbUserDslImpl implements TbUserDsl{

    private final JPAQueryFactory queryFactory;
    private QTbUser qTbUser = QTbUser.tbUser;
    private QTbUserPolicy qTbUserPolicy = QTbUserPolicy.tbUserPolicy;
    private QTbPolicy qTbPolicy = QTbPolicy.tbPolicy;
    private QTbPolicyGroup qTbPolicyGroup = QTbPolicyGroup.tbPolicyGroup;


    @Override
    public List<UserPolicyDto> UserPolicySelect(String usrId) {
        List<UserPolicyDto> result = new ArrayList<>();

        result =  queryFactory.select(
                Projections.fields(
                        UserPolicyDto.class,
                        qTbPolicyGroup.svcId
                        , qTbPolicyGroup.svcRole
                )
        ).from(qTbUserPolicy)
                .innerJoin(qTbPolicyGroup).on(qTbPolicyGroup.plcId.eq(qTbUserPolicy.plcId))
                .where(qTbUserPolicy.usrId.eq(usrId))
                .fetch();
        return result;
    }

}
