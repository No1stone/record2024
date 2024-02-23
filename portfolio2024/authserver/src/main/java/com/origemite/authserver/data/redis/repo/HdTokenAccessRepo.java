package com.origemite.authserver.data.redis.repo;

import com.origemite.authserver.data.redis.entity.HdTokenAccess;
import org.springframework.data.repository.CrudRepository;

public interface HdTokenAccessRepo extends CrudRepository<HdTokenAccess, String> {
}
