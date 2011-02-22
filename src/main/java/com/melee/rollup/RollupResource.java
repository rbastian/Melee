package com.melee.rollup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/rollups")
public class RollupResource {
	
	@GET
	@Produces("application/json")
	public Response getRollup() {
		RollupStrategy rollupStrategy = new SimpleRollupStrategy();
		Rollup rollup  = rollupStrategy.getRollup();
		RollupBean rollupBean = new RollupBean(rollup.getReflex(), rollup.getRecognition());
		return Response.ok(rollupBean).build();
	}

}
