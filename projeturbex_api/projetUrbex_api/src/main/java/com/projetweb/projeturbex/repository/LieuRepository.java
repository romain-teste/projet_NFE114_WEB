package com.projetweb.projeturbex.repository;

import org.springframework.data.repository.CrudRepository;
import com.projetweb.projeturbex.model.Lieux;

public interface LieuRepository extends CrudRepository<Lieux, Integer>{
	Iterable<Lieux> findByLieuPays(String lieuPays);

	Iterable<Lieux> findByLieuRegion(String lieuRegion);

	Iterable<Lieux> findByLieuPaysAndLieuRegion(String lieuPays, String lieuRegion2);

	Lieux findByidLieu(Integer idlieu);

	Iterable<Lieux> findBynomLieu(String nomLieu);

	Iterable<Lieux> findByLieuPaysAndLieuRegionAndLieuType(String lieuPays, String lieuRegion, String lieuType);

	Iterable<Lieux> findByLieuPaysAndLieuType(String lieuPays, String lieuType);

	Iterable<Lieux> findByLieuRegionAndLieuType(String lieuRegion, String lieuType);

	Iterable<Lieux> findByLieuType(String lieuType);


}
