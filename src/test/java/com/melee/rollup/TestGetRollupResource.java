package com.melee.rollup;

import junit.framework.Assert;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class TestGetRollupResource extends JerseyTest {
	
	public TestGetRollupResource() {
		super("com.melee");
	}
	
	@Test
	public void testGetRollupResource() {
		WebResource resource = this.resource();
		Assert.assertNotNull("WebResource must not be null!", resource);
		RollupBean rollupBean = resource.path("rollups").get(RollupBean.class);
		Assert.assertNotNull(rollupBean);
	}

}
