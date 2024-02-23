package com.origemite.authserver.data.db.repo.dsl;

import com.origemite.authserver.data.db.repo.dsl.vo.UserPolicyDto;

import java.util.List;

public interface TbUserDsl {

    List<UserPolicyDto> UserPolicySelect(String usrId);

}
