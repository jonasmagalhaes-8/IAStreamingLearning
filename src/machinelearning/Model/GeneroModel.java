package machinelearning.Model;

public class GeneroModel {
    String nome;

    public GeneroModel() {
    }
    
    public GeneroModel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  

    @Override
    public String toString() {
        return nome;
    }    
}
