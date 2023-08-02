package com.hnrqne.sysevent.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_participant")
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String email;
	
	@ManyToMany
	@JoinTable(name = "tb_participant_activity",
			  joinColumns = @JoinColumn(name = "participant_id"),
			  inverseJoinColumns = @JoinColumn(name = "activity_id"))
	private Set<Activity> activities = new HashSet<>();
	
	public Participant() {
	}

	public Participant(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Participant other = (Participant) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
