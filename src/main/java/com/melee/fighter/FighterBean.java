package com.melee.fighter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FighterBean {
	
	public FighterBean() { }
	
	public FighterBean(Long id, String name, Integer wins, Integer losses, Integer reflex, Integer recognition) {
		this.id = id;
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.reflex = reflex;
		this.recognition = recognition;
	}
	
	public boolean equals(Object aThat) {
		if (this == aThat) {
			return true;
		}
		FighterBean that = (FighterBean)aThat;
		if (!this.id.equals(that.id)) {
			return false;
		}
		if (!this.name.equals(that.name)) {
			return false;
		}
		return true;	
	}
	
	public Long id;
	public String name;
	public Integer wins;
	public Integer losses;
	public Integer reflex;
	public Integer recognition;

}
