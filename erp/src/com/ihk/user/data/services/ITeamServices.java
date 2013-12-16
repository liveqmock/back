package com.ihk.user.data.services;

import java.util.List;

import com.ihk.user.data.pojo.Team;


/**
 * Team的Services接口(业务接口)
 * @author peter.kuang
 *
 */
public interface ITeamServices {

	public List<Team> findTeam()throws Exception;
	public Team findTeamById(int id)throws Exception;
}








