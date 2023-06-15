package com.projetweb.projeturbex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.projetweb.projeturbex.model.Commentaires;

public interface ComRepository extends CrudRepository<Commentaires, Integer>{
	
	Iterable<Commentaires> findByidLieu(Integer idLieu);

    Commentaires findByIdCom(Integer idCom);

    default Commentaires changeVisibility(Integer idCom) {
        Commentaires commentaire = findByIdCom(idCom);
        if (commentaire.getVisibility() == true) {
            commentaire.setVisibility(false);
            return save(commentaire);
        } else if (commentaire.getVisibility() == false) {
        	commentaire.setVisibility(true);
            return save(commentaire);
        }
        return null; // Ou lancez une exception appropriée si le commentaire n'est pas trouvé
    }

}
