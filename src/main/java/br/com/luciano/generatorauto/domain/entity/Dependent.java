package br.com.luciano.generatorauto.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_DEPENDENT")
public class Dependent {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_DEPENDENT")
	@SequenceGenerator(name = "SQ_DEPENDENT", sequenceName = "SQ_DEPENDENT")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PARTNER")
	private Partner partner;
	
}
