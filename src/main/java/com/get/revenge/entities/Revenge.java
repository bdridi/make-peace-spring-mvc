package com.get.revenge.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="STS_REV_ALL")
public class Revenge {
	
	

	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	@Size(min=3)
	private String seeker;
	@NotEmpty 
	@Size(min=3)
	private String target;
	@NotEmpty
	@Size(min=20,max=249)
	private String story;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Advice> advices;
	
	
	public Revenge() {
		
	}
	
	/**
	 * @param seeker
	 * @param target
	 * @param story
	 */
	public Revenge(String seeker, String target, String story, List<Advice> advices) {
		super();
		this.seeker = seeker;
		this.target = target;
		this.story = story;
		this.advices = advices;
	}


	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSeeker() {
		return seeker;
	}
	public void setSeeker(String seeker) {
		this.seeker = seeker;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	
	public List<Advice> getAdvices() {
		return advices;
	}

	public void setAdvices(List<Advice> advices) {
		this.advices = advices;
	}

}
