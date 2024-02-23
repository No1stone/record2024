package com.origemite.gateway.data.redis.repo;

import com.origemite.gateway.data.redis.entity.HdTokenPolicy;
import org.springframework.data.repository.CrudRepository;

public interface HdTokenPolicyRepo extends CrudRepository<HdTokenPolicy, String> {
}
