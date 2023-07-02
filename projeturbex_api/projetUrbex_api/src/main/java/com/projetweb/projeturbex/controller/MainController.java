package com.projetweb.projeturbex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetweb.projeturbex.model.Administrateurs;
import com.projetweb.projeturbex.repository.AdminRepository;
import com.projetweb.projeturbex.model.Commentaires;
import com.projetweb.projeturbex.repository.ComRepository;
import com.projetweb.projeturbex.repository.LieuRepository;
import com.projetweb.projeturbex.model.Pays;
import com.projetweb.projeturbex.repository.PaysRepository;
import com.projetweb.projeturbex.repository.PhotoRepository;
import com.projetweb.projeturbex.model.Photos;
import com.projetweb.projeturbex.model.Lieux;


@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	  @Autowired 
	  public AdminRepository adminRepository;
	  @Autowired 
	  public PaysRepository paysRepository;
	  @Autowired
	  public LieuRepository lieuRepository;
	  @Autowired
	  public ComRepository commRepository;
		@Autowired
		public PhotoRepository photoRepository;



	  
	  //ex PosteMan en POST: http://localhost:8080/demo/addadmin?name=FirstAdmin&mdp=1234
		@CrossOrigin
	  @PostMapping(path="/addadmin")
	  public @ResponseBody String addNewAdmin (@RequestParam String name, 
			  @RequestParam String mdp) {
		  Administrateurs n = new Administrateurs();
		  n.setnomAdmin(name);
		  n.setmdpAdmin(mdp);
		  adminRepository.save(n);
		  
		  return "Saved";
	  }
	  
	  @CrossOrigin
	  @GetMapping(path="/alladmin")
	  public @ResponseBody Iterable<Administrateurs> getAllAdministrateurs() {
	    
	    return adminRepository.findAll();
	  }
	  
	  //http://localhost:8080/demo/addlieu?nomLieu=hello%20word&localisation=1.23.45.78&description=zzzzzzz&lieuPays=france&lieuRegion=alsace&lieuType=ecole&idAdmin=1
	  @CrossOrigin
	  @PostMapping(path="/addlieu")
	  public @ResponseBody String addNewLieu (@RequestParam String nomLieu, 
			  @RequestParam String localisation, @RequestParam String description, 
			  @RequestParam String lieuPays, @RequestParam String lieuRegion, 
			  @RequestParam String lieuType, @RequestParam Integer idAdmin) {
		  Lieux l = new Lieux();
		  l.setnom(nomLieu);
		  l.setloc(localisation);
		  l.setdesc(description);
		  l.setLieuPays(lieuPays);
		  l.setLieuRegion(lieuRegion);
		  l.setLieuType(lieuType);
		  l.setidAdmin(idAdmin);
		  lieuRepository.save(l);
		  
		  return "Saved";
	  }
	  @GetMapping(path="/alllieu")
	  @CrossOrigin
	  public @ResponseBody Iterable<Lieux> getAllLieux() {
	    
	    return lieuRepository.findAll();
	  }
	  @GetMapping(path="/lieu/{idlieu}")
	  @CrossOrigin
	  public @ResponseBody Lieux getLieuxById(@PathVariable Integer idlieu) {
	    
	    return lieuRepository.findByidLieu(idlieu);
	  }
	  @GetMapping("/lieu/pays/{lieuPays}")
	  public @ResponseBody Iterable<Lieux> getLieuxByPays(@PathVariable String lieuPays) {
		  return lieuRepository.findByLieuPays(lieuPays);
		  
	  }
	  @GetMapping("/lieu/region/{lieuPays}/{lieuRegion}")
	  public @ResponseBody Iterable<Lieux> getLieuxByPaysAndRegion(@PathVariable String lieuPays, @PathVariable String lieuRegion) {
		  return lieuRepository.findByLieuPaysAndLieuRegion(lieuPays, lieuRegion);
		  
	  }
	  @CrossOrigin
	  @GetMapping("/lieuByName")
	  public @ResponseBody Iterable<Lieux> getLieuxByNom(@RequestParam String nameLieu) {
		  Iterable<Lieux> lieuByNam;
		  lieuByNam = lieuRepository.findBynomLieu(nameLieu);
		  return lieuByNam;
	  }
	  @CrossOrigin
	  @GetMapping("/lieuByFilter")
	  public @ResponseBody Iterable<Lieux> getLieuxByFilter(@RequestParam String lieuPays, @RequestParam String lieuRegion, @RequestParam String lieuType) {
		  Iterable<Lieux> lieuByFilter = null;
		  if (!lieuPays.isEmpty() && !lieuRegion.isEmpty() && !lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuPaysAndLieuRegionAndLieuType(lieuPays, lieuRegion, lieuType);
		  }
		  if (!lieuPays.isEmpty() && !lieuRegion.isEmpty() && lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuPaysAndLieuRegion(lieuPays, lieuRegion);
		  }
		  if (!lieuPays.isEmpty() && lieuRegion.isEmpty() && !lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuPaysAndLieuType(lieuPays, lieuType);
		  }
		  if (lieuPays.isEmpty() && !lieuRegion.isEmpty() && !lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuRegionAndLieuType(lieuRegion, lieuType);
		  }
		  if (!lieuPays.isEmpty() && lieuRegion.isEmpty() && lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuPays(lieuPays);
		  }
		  if (lieuPays.isEmpty() && lieuRegion.isEmpty() && !lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuType(lieuType);
		  }
		  if (lieuPays.isEmpty() && !lieuRegion.isEmpty() && lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuRegion(lieuRegion);
		  }
		  if (lieuPays.isEmpty() && lieuRegion.isEmpty() && lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findAll();
		  }
		  /*if (!lieuPays.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuPays(lieuPays);
		  }
		  if (!lieuRegion.isEmpty()) {
			  lieuByFilter = lieuRepository.findByLieuRegion(lieuRegion);
		  }
		  if (!lieuType.isEmpty()) {
			  lieuByFilter = lieuRepository.findBylieuType(lieuType);
		  }*/
		  return lieuByFilter;
		  
	  }
	  
	  @DeleteMapping("/lieu/suppr/{lieuid}")
	  @CrossOrigin
	  public void deleteLieuById(@PathVariable Integer lieuid){
		  lieuRepository.deleteById(lieuid);
	  }
	  //http://localhost:8080/demo/modiflieu/1?newNomLieu=hello%20word&newLocalisation=1.23.45.78&newDescription=zzzzzzz&newLieuPays=france&newLieuRegion=alsace&newLieuType=fort
	  @CrossOrigin
	  @PutMapping(path="/modiflieu/{idlieu}")
	  public @ResponseBody ResponseEntity<String> modifLieu (
			  @PathVariable Integer idlieu,
			  @RequestParam String newNomLieu, 
			  @RequestParam String newLocalisation, 
			  @RequestParam String newDescription, 
			  @RequestParam String newLieuPays, 
			  @RequestParam String newLieuRegion, 
			  @RequestParam String newLieuType) {
		  
		  Lieux l = lieuRepository.findByidLieu(idlieu);
		  if (l != null) {
			  l.setnom(newNomLieu);
			  l.setloc(newLocalisation);
			  l.setdesc(newDescription);
			  l.setLieuPays(newLieuPays);
			  l.setLieuRegion(newLieuRegion);
			  l.setLieuType(newLieuType);
			  lieuRepository.save(l);
			  return ResponseEntity.ok("Path updated");
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	  }
	
	  
	  @PostMapping(path="/addpays")
	  public @ResponseBody String addNewPays (@RequestParam String name) {
		  Pays n = new Pays();
		  n.setpays(name);
		  paysRepository.save(n);
		  
		  return "Saved";
	  }	  
	  @GetMapping(path="/allpays")
	  public @ResponseBody Iterable<Pays> getallPays(){
		  return paysRepository.findAll();
	  }
	  
	  
	//Créer un nouveau commentaire ex requet http://localhost:8080/demo/addcomm?idlieu=1&text=aaaaaaaaaaaaaaaaa
	@CrossOrigin
    @PostMapping ("/addcomm")
    public @ResponseBody String createCommentaire(@RequestParam Integer idlieu, @RequestParam String text) {
    	Commentaires c = new Commentaires();
    	c.setidLieu(idlieu);
    	c.settexteCom(text);
    	c.setVisibility(true);
    	commRepository.save(c);
    	
        return "Saved";
    }

    // Lire tous les commentaires ayant le même idLieu ex requet: http://localhost:8080/demo/lieu?idlieu=1
    @CrossOrigin
    @SuppressWarnings("unchecked")
	@GetMapping("/comm/lieu")
    public @ResponseBody Iterable<Commentaires> getCommentairesByLieu(@RequestParam Integer idlieu) {
        //Commentaires commentaires = commRepository.findByIdCom(idlieu);
        //return (Iterable<Commentaires>) ResponseEntity.ok(commentaires);
    	return commRepository.findByidLieu(idlieu);
    }

    // changer la visibliliter ex requet : http://localhost:8080/demo/changevisibility?id=1
    @GetMapping("/comm/changevisibility")
    public @ResponseBody String getCommentaireById(@RequestParam Integer id) {
    	commRepository.changeVisibility(id);
        return "visibility change";
        
        
    }
    @CrossOrigin
    @DeleteMapping("/comm/delete/{idCom}")
    public @ResponseBody String deleteCom(@PathVariable Integer idCom){
    	commRepository.deleteById(idCom);
    	String reponce = "Commentaire supprimé, id:" + idCom;
    	return reponce;
    }
    //Modifier un commentaire par son ID
    @PostMapping("/comm/modifcom")
    public @ResponseBody String modifCommentaire(@RequestParam Integer id, @RequestParam Integer idlieu, @RequestParam String text) {
    	commRepository.deleteById(id);
    	Commentaires c = new Commentaires();
    	c.setidLieu(idlieu);
    	c.settexteCom(text);
    	c.setVisibility(true);
    	commRepository.save(c);
    	
    	return "com modif";
    }
    
    // Créer une nouvelle photo ex pequet:http://localhost:8080/demo/addphoto?idlieux=1&path=eeeeeeeeee
    @CrossOrigin
    @PostMapping("/photo/addphoto")
    public ResponseEntity<String> createPhoto(
            @RequestParam Integer idlieux,
            @RequestParam String path
    ) {
        Photos photo = new Photos();
        photo.setidLieux(idlieux);
        photo.setpath(path);
        photoRepository.save(photo);

        return ResponseEntity.status(HttpStatus.CREATED).body("Saved");
    }
    
    // Lire toutes les photos ayant le même idLieux ex requet: http://localhost:8080/demo/photolieux?idlieux=1
    @CrossOrigin
    @GetMapping("/photo/photolieux")
    public ResponseEntity<Iterable<Photos>> getPhotosByLieux(
            @RequestParam Integer idlieux
    ) {
        Iterable<Photos> photos = photoRepository.findByidLieux(idlieux);
        return ResponseEntity.ok(photos);
    }
    
    // Supprimer une photo par son idPhoto http://localhost:8080/demo/photo/2
    @CrossOrigin
    @DeleteMapping("/photo/{idPhoto}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Integer idPhoto) {
    	photoRepository.deleteById(idPhoto);
        return ResponseEntity.noContent().build();
    }
    // Modifier le chemin d'une  ex request : http://localhost:8080/demo/photo/1/path?newpath=new
    @PutMapping("/photo/{idPhoto}/path")
    public ResponseEntity<String> updatePhotoPath(
            @PathVariable Integer idPhoto,
            @RequestParam String newpath
    ) {
        Photos photo = photoRepository.findByIdPhoto(idPhoto);
        if (photo != null) {
            photo.setpath(newpath);
            photoRepository.save(photo);
            return ResponseEntity.ok("Path updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
