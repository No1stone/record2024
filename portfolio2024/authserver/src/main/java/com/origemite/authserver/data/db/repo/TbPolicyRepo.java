package com.origemite.authserver.data.db.repo;

import com.origemite.authserver.data.db.entity.TbPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbPolicyRepo  extends JpaRepository<TbPolicy, String> {
}
