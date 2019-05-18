package org.easymis.vkwit.teacher.domain.repository;

import java.util.Optional;

import org.easymis.vkwit.teacher.domain.entity.EasyMisMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EasyMisMember, String>, JpaSpecificationExecutor<EasyMisMember> {

    @Query("select distinct u from EasyMisMember u where u.id= :id")
    Optional<EasyMisMember> findById(@Param("id") String id);

}