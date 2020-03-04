package com.alae.plannify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alae.plannify.dao.TeamDaoInterface;
import com.alae.plannify.model.Team;
import com.alae.plannify.services.interfaces.TeamServiceInterface;

@Service
public class TeamService implements TeamServiceInterface {
	
	@Autowired
	TeamDaoInterface teamDao;
	
	
	@Override
	public Team add(Team team) {
		return teamDao.save(team);
	}
	
	@Override
	public Optional<Team> get(int id){
		return teamDao.findById(id);
	}
	
	@Override
	public List<Team> getAll(){
		return teamDao.findAll();
	}
	
	@Override
	public void delete(int id) {
		teamDao.deleteById(id);
	}
}
