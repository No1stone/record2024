package com.origemite.gateway.data.redis.repo;

import com.origemite.gateway.data.redis.entity.HdTokenAccess;
import org.springframework.data.repository.CrudRepository;

public interface HdTokenAccessRepo extends CrudRepository<HdTokenAccess, String> {
}
