package com.origemite.querytouble.biz.service.case1;

import com.origemite.querytouble.biz.controller.case1.vo.ReqCase1;
import com.origemite.querytouble.data.db.entity.case1.Case1Customer;
import com.origemite.querytouble.data.db.entity.case1.Case1Group;
import com.origemite.querytouble.data.db.entity.case1.Case1User;
import com.origemite.querytouble.data.db.entity.case1.Case1View;
import com.origemite.querytouble.data.db.repo.case1.Case1CustomerRepo;
import com.origemite.querytouble.data.db.repo.case1.Case1GroupRepo;
import com.origemite.querytouble.data.db.repo.case1.Case1UserRepo;
import com.origemite.querytouble.data.db.repo.case1.Case1ViewRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class Case1Service {

    private final Case1CustomerRepo case1CustomerRepo;
    private final Case1GroupRepo case1GroupRepo;
    private final Case1UserRepo case1UserRepo;
    private final Case1ViewRepo case1ViewRepo;

    @Transactional
    public void CreateData() {
        List<Case1Customer> cust = new ArrayList<>();
        List<Case1Group> grp = new ArrayList<>();
        List<Case1User> usr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            LocalDateTime ldt = LocalDateTime.now();
            cust.add(new Case1Customer(UUID.randomUUID().toString(), "CUST" + i, ldt, ldt));
            grp.add(new Case1Group(UUID.randomUUID().toString(), "GRP" + i, ldt, ldt));
            usr.add(new Case1User(UUID.randomUUID().toString(), "USR" + i, ldt, ldt));
        }
        case1CustomerRepo.saveAll(cust);
        case1GroupRepo.saveAll(grp);
        case1UserRepo.saveAll(usr);

    }

    public List<Case1View> select(ReqCase1 dto) {
        return case1ViewRepo.findBy(PageRequest.of(dto.getPage(), dto.getSize())).stream().toList();
    }
}
