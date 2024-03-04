package com.origemite.querytouble.data.db.repo.case1;

import com.origemite.querytouble.data.db.entity.case1.Case1View;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Case1ViewRepo extends JpaRepository<Case1View, String> {

    Page<Case1View> findBy(Pageable pr);

}
