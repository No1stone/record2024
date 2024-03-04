package com.origemite.querytouble.data.db.repo.case2.dsl;

import com.origemite.querytouble.biz.controller.case2.vo.Case2SelectAll;
import com.origemite.querytouble.data.db.entity.case2.QCase2And1;
import com.origemite.querytouble.data.db.entity.case2.QCase2And2;
import com.origemite.querytouble.data.db.entity.case2.QCase2End;
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
public class Case2EndRepoDslImpl implements Case2EndRepoDsl{

    private final JPAQueryFactory queryFactory;
    private QCase2End qCase2End = QCase2End.case2End;
    private QCase2And1 qCase2And1 = QCase2And1.case2And1;
    private QCase2And2 qCase2And2 = QCase2And2.case2And2;

    @Override
    public List<Case2SelectAll> selectALL() {
        List<Case2SelectAll> result = new ArrayList<>();

        result =  queryFactory.select(
                Projections.fields(
                        Case2SelectAll.class,
                        qCase2End.id
                        , qCase2End.endPoint
                        , qCase2And1.and1Id
                        , qCase2And1.and1Status
                        , qCase2And2.and2Id
                        , qCase2And2.and2Status
                )
        ).from(qCase2End)
                .innerJoin(qCase2And1).on(qCase2End.id.eq(qCase2And1.id))
                .innerJoin(qCase2And2).on(qCase2End.id.eq(qCase2And2.id))
                .fetch();

        return result;
    }
}
