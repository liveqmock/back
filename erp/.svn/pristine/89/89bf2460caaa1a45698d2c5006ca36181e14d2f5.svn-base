package com.ihk.user.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.ITeamMapper;
import com.ihk.user.data.pojo.Team;
import com.ihk.user.data.services.ITeamServices;
@Service("TeamServices")
public class TeamServices implements ITeamServices {
	@Autowired private ITeamMapper teamMapper;
		
	@Override
	public List<Team> findTeam() {
		return teamMapper.findTeam();
	}

	@Override
	public Team findTeamById(int id) {
		return teamMapper.findTeamById( id);
	}
	
}








