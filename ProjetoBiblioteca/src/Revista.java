public class Revista implements Imprimivel {

    private String titulo;
    private String empresa;
    private int edicao;
    private boolean emprestado;
    private int nroCopias;

    public Revista(String titulo, String empresa, int edicao) {
        this.titulo = titulo;
        this.empresa = empresa;
        this.edicao = edicao;
        this.emprestado = false;
        this.nroCopias = 1;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.empresa;
    }

    public int getISBN() {
        return this.edicao;
    }

    public boolean isEmprestado() {
        return this.emprestado;
    }

    public int getnroCopias() {
        return this.nroCopias;
    }

    private void setEmprestado(boolean isEmprestado) {
        this.emprestado = isEmprestado;
    }

    public boolean reservar() {
        boolean livroEstaEmprestado = this.isEmprestado();

        if (livroEstaEmprestado) {
            return false;
        } else {
            this.setEmprestado(true);
            return true;
        }

    }

    public boolean devolver() {
        boolean livroEstaEmprestado = this.isEmprestado();

        if (livroEstaEmprestado) {
            this.setEmprestado(false);
            return true;
        } else {
            return false;
        }
    }

    public String imprimir() {
        if (emprestado = false) {
            nroCopias++;
            return "Revista{" +
                    "titulo='" + titulo + '\'' +
                    ", empresa='" + empresa + '\'' +
                    ", edicao=" + edicao +
                    ", emprestado=" + emprestado +
                    ", nroCopias=" + nroCopias +
                    ", livroEmprestado=" + emprestado;
        }return "Erro";
    }
}