package com.projetweb.projeturbex.repository;

import org.springframework.data.repository.CrudRepository;
import com.projetweb.projeturbex.model.Administrateurs;

public interface AdminRepository extends CrudRepository<Administrateurs, Integer> {
	
}
