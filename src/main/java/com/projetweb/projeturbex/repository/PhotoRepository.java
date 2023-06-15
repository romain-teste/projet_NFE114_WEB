package com.projetweb.projeturbex.repository;

import org.springframework.data.repository.CrudRepository;
import com.projetweb.projeturbex.model.Photos;

public interface PhotoRepository extends CrudRepository<Photos, Integer>{

	Iterable<Photos> findByidLieux(Integer idLieux);

	Photos findByIdPhoto(Integer idPhoto);

}
