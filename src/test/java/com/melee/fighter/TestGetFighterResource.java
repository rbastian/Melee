package com.melee.fighter;

import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;


public class TestGetFighterResource extends JerseyTest {
	
	public TestGetFighterResource() {
		super("com.melee");
	}
	
	@Test
	public void testGetFighterId() {
		WebResource resource = this.resource();
		Assert.assertNotNull(resource);
		FighterBean fighter = resource.path("fighters/2").get(FighterBean.class);
		Assert.assertNotNull(fighter);
	}
	
	@Test
	public void testPostFighter() throws Exception {
		WebResource resource = this.resource();
		Assert.assertNotNull("resource cannot be null!", resource);
		FighterBean fighterBean = new FighterBean(null, "Rob", 0, 0, 15, 10);
		ClientResponse response = resource.path("fighters").entity(fighterBean, MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);;
		response.getLocation().toString();
		FighterBean readFighterBean = resource.uri(response.getLocation()).get(FighterBean.class);
		Assert.assertNotNull("readFighterBean cannot be null!", readFighterBean);
		Assert.assertNotNull("id cannot be null!", readFighterBean.id);
		
	}
}
