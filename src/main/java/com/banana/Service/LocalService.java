package com.banana.Service;

import com.banana.DAO.LocalDAO;
import com.banana.Model.Local;

import javax.inject.Inject;
import java.util.List;

public class LocalService {

    Local local;
    @Inject
    transient private LocalDAO localDAO;

    public void cadastrarLocal(String nome, String CNPJ, String endereco) {
        local = new Local();
        local = new Local(nome, CNPJ, endereco);
        System.out.println(local.getNome());
        System.out.println(local.getCNPJ());
        System.out.println(local.getEndereco());
        localDAO.criarLocal(local);
    }
    public List<Local> listarLocais() {
        return localDAO.listarLocais();
    }
    public void deletarLocal(Local local){
        localDAO.deletarLocal(local);
    }
    public void editarLocal(String IDLocal,String nome,String CNPJ,String endereco) {
        int ID = Integer.parseInt(IDLocal);
        Local local = localDAO.searchLocal(ID);
        local.setCNPJ(CNPJ);
        local.setEndereco(endereco);
        local.setNome(nome);
        localDAO.editarLocal(local);
    }

}
