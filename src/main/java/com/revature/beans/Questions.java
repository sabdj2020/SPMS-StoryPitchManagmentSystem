package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questions")

public class Questions {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String question;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="story_id")
	private Story story;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="committee_id")
	private Person committee;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="author_id")
	private Person author;
	
	
	public Questions() {
		id = 1;
		question= "";
		Story story = new Story();
		Person committee = new Person();
		Person author = new Person();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Story getStory() {
		return story;
	}


	public void setStory(Story story) {
		this.story = story;
	}


	public Person getCommittee() {
		return committee;
	}


	public void setCommittee(Person committee) {
		this.committee = committee;
	}


	public Person getAuthor() {
		return author;
	}


	public void setAuthor(Person author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Questions [id=" + id + ", question=" + question + ", story=" + story + ", committee=" + committee
				+ ", author=" + author + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((committee == null) ? 0 : committee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((story == null) ? 0 : story.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questions other = (Questions) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (committee == null) {
			if (other.committee != null)
				return false;
		} else if (!committee.equals(other.committee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		return true;
	}
	
	


	

}
