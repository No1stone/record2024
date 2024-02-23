package com.origemite.authserver.data.db.repo;

import com.origemite.authserver.data.db.entity.TbUserPolicy;
import com.origemite.authserver.data.db.entity.id.TbUserPolicyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbUserPolicyRepo extends JpaRepository<TbUserPolicy, TbUserPolicyId> {

    List<TbUserPolicy> findByUsrId(String usrId);

}
