package com.origemite.authserver.data.db.repo;

import com.origemite.authserver.data.db.entity.TbUser;
import com.origemite.authserver.data.db.repo.dsl.TbUserDsl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbUserRepo extends JpaRepository<TbUser, String> , TbUserDsl {

    Optional<TbUser> findByUsrEmail(String email);
    Boolean existsByUsrEmail(String email);

}
