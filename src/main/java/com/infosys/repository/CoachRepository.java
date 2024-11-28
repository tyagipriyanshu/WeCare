package com.infosys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entity.CoachEntity;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, String> {
	
	Optional<CoachEntity> findByCoachId(String coachId);

}
