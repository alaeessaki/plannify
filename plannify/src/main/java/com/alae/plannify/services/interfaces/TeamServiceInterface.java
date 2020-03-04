package com.alae.plannify.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.alae.plannify.model.Team;

public interface TeamServiceInterface {

	Team add(Team team);

	Optional<Team> get(int id);

	List<Team> getAll();

	void delete(int id);

}