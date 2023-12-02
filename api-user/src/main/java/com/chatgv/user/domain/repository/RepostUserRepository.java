package com.chatgv.user.domain.repository;

import com.chatgv.user.domain.entity.ReportUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepostUserRepository extends JpaRepository<ReportUserEntity, Long> {
}
