package com.melee.fighter;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.melee.Fighter;
import com.melee.api.exception.FighterNotFoundException;
import com.melee.api.fighter.FighterManager;

@Path("/fighters")
public class FighterResource {

	@GET
	@Path("{fighterId}")
	@Produces("application/json")
	public Response getFighter(@PathParam("fighterId") Long fighterId) {
		
		FighterManager fm = new FighterManager();
		try {
			Fighter fighter = fm.getFighter(fighterId);
			FighterBean bean = new FighterBean(fighter.getFighterId(), fighter.getName(), fighter.getWins(), fighter.getLosses(), fighter.getReflex(), fighter.getRecognition());
			return Response.ok().entity(bean).build();
		} catch (FighterNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes("application/json")
	public Response postFighter(FighterBean fighterBean) {
		System.out.println("bean: " + fighterBean.toString());
		FighterManager fm = new FighterManager();
		Fighter fighter = new Fighter();
		fighter.setName(fighterBean.name);
		fighter.setWins(fighterBean.wins);
		fighter.setLosses(fighterBean.losses);
		fm.createFighter(fighter);
		URI location = URI.create(fighter.getFighterId().toString());
		return Response.created(location).build();
		
	}
}
