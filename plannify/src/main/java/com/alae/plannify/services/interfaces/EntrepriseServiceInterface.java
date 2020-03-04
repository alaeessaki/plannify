package com.alae.plannify.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.alae.plannify.model.Entreprise;

public interface EntrepriseServiceInterface {

	Entreprise add(Entreprise entreprise);

	Optional<Entreprise> get(int id);

	List<Entreprise> getAll();

	void delete(int id);

}