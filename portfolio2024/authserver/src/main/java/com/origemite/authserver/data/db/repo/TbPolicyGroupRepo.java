package com.origemite.authserver.data.db.repo;

import com.origemite.authserver.data.db.entity.TbPolicyGroup;
import com.origemite.authserver.data.db.entity.id.TbPolicyGroupId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TbPolicyGroupRepo extends JpaRepository<TbPolicyGroup, TbPolicyGroupId> {
    List<TbPolicyGroup> findByPlcId(String plcId);
    List<TbPolicyGroup> findBySvcId(String svcId);
    List<TbPolicyGroup> findByPlcIdAndSvcId(String plcId, String svcId);


}
