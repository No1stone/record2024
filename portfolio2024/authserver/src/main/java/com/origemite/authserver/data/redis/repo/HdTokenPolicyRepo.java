package com.origemite.authserver.data.redis.repo;

import com.origemite.authserver.data.redis.entity.HdTokenPolicy;
import org.springframework.data.repository.CrudRepository;

public interface HdTokenPolicyRepo extends CrudRepository<HdTokenPolicy, String> {
}
