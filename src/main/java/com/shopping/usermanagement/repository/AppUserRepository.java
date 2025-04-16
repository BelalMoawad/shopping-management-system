package com.shopping.usermanagement.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.usermanagement.entity.AppUser;

@Repository
public interface AppUserRepository extends BaseRepository<AppUser, Long> {
	@Query("SELECT u FROM AppUser u JOIN FETCH u.roles WHERE u.userName = :username")
	Optional<AppUser> findByUserName (@Param("username")String userName) ;
}
