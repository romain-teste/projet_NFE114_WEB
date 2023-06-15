package com.projetweb.projeturbex.repository;

import org.springframework.data.repository.CrudRepository;
import com.projetweb.projeturbex.model.Lieux;

public interface LieuRepository extends CrudRepository<Lieux, Integer>{
	Iterable<Lieux> findByLieuPays(String lieuPays);

	Iterable<Lieux> findByLieuRegion(String lieuRegion);

	Iterable<Lieux> findByLieuPaysAndLieuRegion(String lieuPays, String lieuRegion2);

	Lieux findByidLieu(Integer idlieu);


}
