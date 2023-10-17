import java.util.ArrayList;

public class Biblioteca{
    private ArrayList<Livro> catalogo;

    public Biblioteca(){
        this.catalogo = new ArrayList<Livro>();
    }

    public boolean adicionar_livro(String titulo, String autor, String ISBN){
        Livro novoLivro = new Livro(titulo, autor, ISBN);

        this.catalogo.add(novoLivro);

        return true;
    }

    public boolean remover_livro(String ISBN){
        int tamanhoDoCatalogo = this.catalogo.size();
        int i;

        int indiceDoLivroSelecionado = -1;

        for (i = 0; i < tamanhoDoCatalogo; i++){

            Livro livroAtual = this.catalogo.get(i);

            String ISBNLivroAtual = livroAtual.getISBN();

            if (ISBNLivroAtual.equals(ISBN)){
                indiceDoLivroSelecionado = i;
                i = tamanhoDoCatalogo;
            }

        }

        if (indiceDoLivroSelecionado >= 0) {
            this.catalogo.remove(indiceDoLivroSelecionado);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Livro> buscarPorTitulo(String titulo) {
        ArrayList<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : catalogo) {
            if (livro.getTitulo().contains(titulo)) {
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }

    public boolean emprestarLivro(String ISBN) {
        for (Livro livro : catalogo) {
            if (livro.getISBN().equals(ISBN) && !livro.isEmprestado()) {
                livro.reservar();
                return true;
            }
        }
        return false;
    }

    public boolean devolverLivro(String ISBN) {
        for (Livro livro : catalogo) {
            if (livro.getISBN().equals(ISBN) && livro.isEmprestado()) {
                livro.devolver();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Livro> listarLivros() {
        return catalogo;
    }

    public ArrayList<Livro> listarLivrosEmprestados() {
        ArrayList<Livro> livrosEmprestados = new ArrayList<>();

        for (Livro livro : catalogo) {
            if (livro.isEmprestado()) {
                livrosEmprestados.add(livro);
            }
        }

        return livrosEmprestados;
    }
}