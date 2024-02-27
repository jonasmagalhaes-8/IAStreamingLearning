package machinelearning.Model;

public class MidiaModel {
    String titulo;
    GeneroModel genero;

    public MidiaModel() {
    }

    public MidiaModel(String titulo, GeneroModel genero) {
        this.titulo = titulo;
        this.genero = genero;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public GeneroModel getGenero() {
        return genero;
    }

    public void setGenero(GeneroModel genero) {
        this.genero = genero;
    }    
}
