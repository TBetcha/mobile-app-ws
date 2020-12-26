package com.tbetcha.app.ws;

import com.tbetcha.app.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
 UserEntity findByEmail(String email);
}
