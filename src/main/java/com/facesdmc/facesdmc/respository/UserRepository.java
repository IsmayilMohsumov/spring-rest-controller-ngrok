package com.facesdmc.facesdmc.respository;

import com.facesdmc.facesdmc.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
