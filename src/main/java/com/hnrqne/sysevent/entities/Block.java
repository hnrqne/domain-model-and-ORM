package com.hnrqne.sysevent.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_block")
public class Block {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant startTime;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant endTime;
	
	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity;
	
	public Block() {
	}

	public Block(Integer id, Instant startTime, Instant endTime, Activity activity) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getStartTime() {
		return startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Instant getEndTime() {
		return endTime;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Block [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", activity=" + activity + "]";
	}
}
