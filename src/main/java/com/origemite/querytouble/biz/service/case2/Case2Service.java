package com.origemite.querytouble.biz.service.case2;

import com.origemite.querytouble.biz.controller.case2.vo.Case2SelectAll;
import com.origemite.querytouble.data.db.entity.case2.Case2And1;
import com.origemite.querytouble.data.db.entity.case2.Case2And2;
import com.origemite.querytouble.data.db.entity.case2.Case2End;
import com.origemite.querytouble.data.db.repo.case2.Case2And1Repo;
import com.origemite.querytouble.data.db.repo.case2.Case2And2Repo;
import com.origemite.querytouble.data.db.repo.case2.Case2EndRepo;
import com.origemite.querytouble.data.jdbc.case2.Case2JdbcRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class Case2Service {

    private final Case2EndRepo case2EndRepo;
    private final Case2And1Repo case2And1Repo;
    private final Case2And2Repo case2And2Repo;
    private final Case2JdbcRepo case2JdbcRepo;
    private final EntityManager em;

    @Transactional
    public void DataSetting() {

        List<Case2End> end = new ArrayList<>();
        List<Case2And1> and1 = new ArrayList<>();
        List<Case2And2> and2 = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            String id = String.format("END%09d", i);
            String and1Id = String.format("and1%09d", i);
            String and2Id = String.format("and2%09d", i);

            end.add(Case2End.builder().id(id).endPoint("1").build());
            if (i % 10 == 0) {
                and1.add(Case2And1.builder().and1Id(and1Id).id(id).and1Status("up").build());
            } else {
                and1.add(Case2And1.builder().and1Id(and1Id).id(id).and1Status(String.valueOf(i)).build());
            }

            if (i % 100 == 0) {
                and2.add(Case2And2.builder().and2Id(and1Id).id(id).and2Status("up").build());
            } else {
                and2.add(Case2And2.builder().and2Id(and1Id).id(id).and2Status(String.valueOf(i)).build());
            }
        }
        case2EndRepo.saveAll(end);
        case2And1Repo.saveAll(and1);
        case2And2Repo.saveAll(and2);
    }

    public List<Case2SelectAll> dataCheck() {
        return case2EndRepo.selectALL();
    }

    public void createTable() {
        case2JdbcRepo.case1Table();
    }

    public void dropTable() {
        case2JdbcRepo.drop();
    }

    @Transactional
    public void dynamicBulkUpdate() {

        TypedQuery<Case2End> result = em.createQuery(
                "Select A from Case2End A " +
                        "inner join Case2And1 B on A.id = B.id " +
                        "inner join Case2And1 C on A.id = C.id " +
                        "where B.and1Status = :status1 " +
                        "and C.and1Status = :status2 " , Case2End.class
        );
        result.setParameter("status1", "up");
        result.setParameter("status2", "up");
        result.getResultStream().map(e -> e.endPointUpdate("UPDATE")).collect(Collectors.toList());
    }
}
