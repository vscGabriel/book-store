package com.chatgv.user.domain.repository;

import com.chatgv.user.domain.entity.BlockedUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedUserRepository extends JpaRepository<BlockedUserEntity, Long> {
}
