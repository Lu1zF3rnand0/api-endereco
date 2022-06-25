package br.edu.infnet.apiendereco.model.repository;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends CrudRepository<Endereco, Integer> {

    Endereco findByCep(String cep);

}
