package com.melee.match;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.melee.api.exception.MatchResultNotFoundException;
import com.melee.api.match.MatchResultManager;


@Path("/matchresults")
public class MatchResultResource {
	
	@GET
	@Path("{resultId}")
	@Produces("application/json")
	public Response getMatchResult(@PathParam("resultId") Long resultId) {
		MatchResultManager mrm = new MatchResultManager();
		try {
			MatchResult matchResult = mrm.getMatchResult(resultId);
			MatchResultBean mrBean = new MatchResultBean(resultId, matchResult.getWinner().getFighterId(), matchResult.getLoser().getFighterId(), Long.valueOf(matchResult.getRounds()), Long.valueOf(matchResult.getElapsedSecs()));
			return Response.status(Status.OK).entity(mrBean).build();
		} catch (MatchResultNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
