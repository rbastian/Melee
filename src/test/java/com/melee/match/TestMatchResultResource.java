package com.melee.match;

import junit.framework.Assert;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;


public class TestMatchResultResource extends JerseyTest {

	public TestMatchResultResource() {
		super("com.melee");
	}
	
	@Test
	public void testGetMatchResult() throws Exception {
		WebResource resource = this.resource();
		Assert.assertNotNull(resource);
		MatchResultBean mrBean = resource.path("/matchresults/1").get(MatchResultBean.class);
		Assert.assertNotNull(mrBean);
	}
}
