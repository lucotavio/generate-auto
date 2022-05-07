package br.com.luciano.generatorauto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.luciano.generatorauto.domain.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long>{

}
