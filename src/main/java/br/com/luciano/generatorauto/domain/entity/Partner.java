package br.com.luciano.generatorauto.domain.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PARTNER")
public class Partner {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_PARTNER")
	@SequenceGenerator(name = "SQ_PARTNER", sequenceName = "SQ_PARTNER")
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "partner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Dependent> dependents;
	
	public Partner() {
		this(null);
	}
	
	public Partner(String name) {
		this.name = name;
		this.dependents = new HashSet<>();
	}
	
	public Set<Dependent> getListDependents() {
		return Collections.unmodifiableSet(dependents);
	}
	
	public void addDependent(Dependent dependent) {
		this.dependents.add(dependent);
		dependent.setPartner(this);
	}	
}
