package com.banana.Bean;

import com.banana.Model.Local;
import com.banana.Service.LocalService;
import com.sun.xml.bind.v2.model.core.ID;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.registry.infomodel.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
@Named("localBean")
@ViewScoped
public class LocalBean implements Serializable {
    private String nome;
    private String CNPJ;
    private String endereco;
    private String IDString;
    @Inject
    transient private LocalService localService;


    public void salvar() {
        if(!IDString.equals("") ){
            editar();
        }
        else if(IDString.equals("")) {
            cadastrarLocal();
        }

    }
    public void cadastrarLocal() {
        localService.cadastrarLocal(nome, CNPJ, endereco);
        IDString = "";
        nome = "";
        CNPJ = "";
        endereco = "";
    }
    public List<Local> listarLocais() {
        return localService.listarLocais();
    }
    public void deletarLocal(Local local){
        localService.deletarLocal(local);
    }
    public void editarLocal(Local local) {
        nome = local.getNome();
        CNPJ = local.getCNPJ();
        endereco = local.getEndereco();
        IDString = String.valueOf(local.getID());

    }
    public void editar(){
        localService.editarLocal(IDString, nome, CNPJ, endereco);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
