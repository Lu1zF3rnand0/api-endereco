package br.edu.infnet.apiendereco.loader;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EnderecoLoader implements ApplicationRunner {

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco endereco = new Endereco();

        try {
            endereco.setBairro("Bairro");
            endereco.setComplemento("Complemento");
            endereco.setCep("Cep");
            endereco.setLocalidade("Localidade");
            endereco.setLogradouro("Logradouro");
            endereco.setUf("Uf");
            enderecoService.incluir(endereco);

        } catch (Exception e){
            Endereco end = enderecoService.obterPorCep("Cep");

            end.setCep("Cep8");
            enderecoService.incluir(end);

            for (Endereco ende: enderecoService.obterLista()){
                System.out.println(ende.getCep());
            }

//            enderecoService.excluir(end.getId());
        }

    }
}
