package com.melee.match;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MatchResultBean {
	
	public Long resultId;
	public Long winnerId;
	public Long loserId;
	public Long rounds;
	public long elapsedSecs;
	
	public MatchResultBean() {}
	
	public MatchResultBean(Long resultId, Long winnerId, Long loserId, Long rounds, Long elapsedSecs) {
		this.resultId = resultId;
		this.winnerId = winnerId;
		this.loserId = loserId;
		this.rounds = rounds;
		this.elapsedSecs = elapsedSecs;
	}
	
	

}
