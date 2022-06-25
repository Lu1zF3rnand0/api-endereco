package br.edu.infnet.apiendereco.controller;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/endereco")
    public List<Endereco> obterLista(){
        return enderecoService.obterLista();
    }

    @PostMapping(value = "/endereco")
    public void incluir(@RequestBody Endereco endereco){
        enderecoService.incluir(endereco);
    }

    @DeleteMapping(value = "/endereco/{id}")
    public void excluir(@PathVariable Integer id){
        enderecoService.excluir(id);
    }

    @GetMapping(value = "/endereco/{cep}")
    public Endereco obterPorCep(@PathVariable String cep){
        return enderecoService.obterPorCep(cep);
    }

}
