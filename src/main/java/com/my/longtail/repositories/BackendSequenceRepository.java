package com.my.longtail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.BackendSequence;

@Repository("backendSequenceRepository")
public interface BackendSequenceRepository extends JpaRepository<BackendSequence, Long>{
	BackendSequence findBySequenceName(String prefix);
}
