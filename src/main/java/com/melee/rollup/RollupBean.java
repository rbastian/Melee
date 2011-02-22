package com.melee.rollup;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RollupBean {

	public Long reflex;
	public Long recognition;
	
	public RollupBean() { }
	
	public RollupBean(Long reflex, Long recognition) {
		this.reflex = reflex;
		this.recognition = recognition;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RollupBean: [");
		sb.append("reflex = ").append(this.reflex).append(", ");
		sb.append("recognition = ").append(this.recognition);
		sb.append("]");
		return sb.toString();
	}
}
