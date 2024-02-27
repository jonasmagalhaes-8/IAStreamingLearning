package machinelearning.Model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    String nome;
    List<GeneroModel> generosFavoritos = new ArrayList<>();
    List<MidiaModel> historicoConteudo = new ArrayList<>();
    List<MidiaModel> sugestoesConteudo = new ArrayList<>();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<GeneroModel> getGenerosFavoritos() {
        return generosFavoritos;
    }

    public void setGenerosFavoritos(List<GeneroModel> generosFavoritos) {
        this.generosFavoritos = generosFavoritos;
    }

    public List<MidiaModel> getHistoricoConteudo() {
        return historicoConteudo;
    }

    public void setHistoricoConteudo(List<MidiaModel> historicoConteudo) {
        this.historicoConteudo = historicoConteudo;
    }

    public List<MidiaModel> getSugestoesConteudo() {
        return sugestoesConteudo;
    }

    public void setSugestoesConteudo(List<MidiaModel> sugestoesConteudo) {
        this.sugestoesConteudo = sugestoesConteudo;
    }    
}
