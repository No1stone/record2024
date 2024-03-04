package com.origemite.querytouble.data.db.repo.case2;

import com.origemite.querytouble.data.db.entity.case2.Case2End;
import com.origemite.querytouble.data.db.repo.case2.dsl.Case2EndRepoDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Case2EndRepo extends JpaRepository<Case2End, String> , Case2EndRepoDsl {
}
