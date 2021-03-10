package com.revature.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	@Column(name="tag_line")
	private String tagLine;
	
	@Column(name="comp_date")
	private Date date;
	private String attachment;
	private Integer priority;
	private String draft;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="story_genre_id")
	private StoryGenre sg;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="story_type_id")
	private StoryType st;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="story_status_id")
	private StoryStatus ss;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="author_id", nullable = true)
	private Person pAuthor;
	@ManyToOne
	@JoinColumn(name="review1_id", nullable = true)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Person pReview1;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="review2_id", nullable = true)
	private Person pReview2;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="review3_id", nullable = true)
	private Person pReview3;
	

	public Story() {
		id = 0;
		title= "";
		description = "";
		tagLine = "";
		date = new Date();
		attachment="";
		priority=2;
		draft="";
        sg = new StoryGenre();
        st = new StoryType();
        ss = new StoryStatus();
        pAuthor = new Person();
		pReview1 = new Person();
		pReview2 = new Person();
		pReview3 = new Person();	
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTagLine() {
		return tagLine;
	}


	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getAttachment() {
		return attachment;
	}


	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public String getDraft() {
		return draft;
	}


	public void setDraft(String draft) {
		this.draft = draft;
	}


	public StoryGenre getSg() {
		return sg;
	}


	public void setSg(StoryGenre sg) {
		this.sg = sg;
	}


	public StoryType getSt() {
		return st;
	}


	public void setSt(StoryType st) {
		this.st = st;
	}


	public StoryStatus getSs() {
		return ss;
	}


	public void setSs(StoryStatus ss) {
		this.ss = ss;
	}


	public Person getpAuthor() {
		return pAuthor;
	}


	public void setpAuthor(Person pAuthor) {
		this.pAuthor = pAuthor;
	}


	public Person getpReview1() {
		return pReview1;
	}


	public void setpReview1(Person pReview1) {
		this.pReview1 = pReview1;
	}


	public Person getpReview2() {
		return pReview2;
	}


	public void setpReview2(Person pReview2) {
		this.pReview2 = pReview2;
	}


	public Person getpReview3() {
		return pReview3;
	}


	public void setpReview3(Person pReview3) {
		this.pReview3 = pReview3;
	}


	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", description=" + description + ", tagLine=" + tagLine
				+ ", date=" + date + ", attachment=" + attachment + ", priority=" + priority + ", draft=" + draft
				+ ", sg=" + sg + ", st=" + st + ", ss=" + ss + ", pAuthor=" + pAuthor + ", pReview1=" + pReview1
				+ ", pReview2=" + pReview2 + ", pReview3=" + pReview3 + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((draft == null) ? 0 : draft.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pAuthor == null) ? 0 : pAuthor.hashCode());
		result = prime * result + ((pReview1 == null) ? 0 : pReview1.hashCode());
		result = prime * result + ((pReview2 == null) ? 0 : pReview2.hashCode());
		result = prime * result + ((pReview3 == null) ? 0 : pReview3.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((sg == null) ? 0 : sg.hashCode());
		result = prime * result + ((ss == null) ? 0 : ss.hashCode());
		result = prime * result + ((st == null) ? 0 : st.hashCode());
		result = prime * result + ((tagLine == null) ? 0 : tagLine.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Story other = (Story) obj;
		if (attachment == null) {
			if (other.attachment != null)
				return false;
		} else if (!attachment.equals(other.attachment))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (draft == null) {
			if (other.draft != null)
				return false;
		} else if (!draft.equals(other.draft))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pAuthor == null) {
			if (other.pAuthor != null)
				return false;
		} else if (!pAuthor.equals(other.pAuthor))
			return false;
		if (pReview1 == null) {
			if (other.pReview1 != null)
				return false;
		} else if (!pReview1.equals(other.pReview1))
			return false;
		if (pReview2 == null) {
			if (other.pReview2 != null)
				return false;
		} else if (!pReview2.equals(other.pReview2))
			return false;
		if (pReview3 == null) {
			if (other.pReview3 != null)
				return false;
		} else if (!pReview3.equals(other.pReview3))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (sg == null) {
			if (other.sg != null)
				return false;
		} else if (!sg.equals(other.sg))
			return false;
		if (ss == null) {
			if (other.ss != null)
				return false;
		} else if (!ss.equals(other.ss))
			return false;
		if (st == null) {
			if (other.st != null)
				return false;
		} else if (!st.equals(other.st))
			return false;
		if (tagLine == null) {
			if (other.tagLine != null)
				return false;
		} else if (!tagLine.equals(other.tagLine))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	


}
