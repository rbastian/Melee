package com.melee;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.melee.fighter.FighterBean;
import com.melee.match.MatchResultBean;
import com.melee.rollup.RollupBean;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;


@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
     private JAXBContext context;
     private Class[] types = {FighterBean.class, MatchResultBean.class, RollupBean.class};
 
     public JAXBContextResolver() throws Exception {
         this.context = 
 	  new JSONJAXBContext(JSONConfiguration.natural().humanReadableFormatting(true).build(), types);
     }
 
     public JAXBContext getContext(Class<?> objectType) {
         for (Class type : types) {
             if (type == objectType) {
                 return context;
             }
         }
         return null;
     }
 }
