class ArvoreBinariaBusca {

    No raiz;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    // Inserção
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {

        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        }

        else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }

        return atual;
    }

    // Busca
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {

        if (atual == null) {
            return false;
        }

        if (atual.valor == valor) {
            return true;
        }

        if (valor < atual.valor) {
            return buscarRecursivo(atual.esquerda, valor);
        }

        return buscarRecursivo(atual.direita, valor);
    }

    // Percurso Em Ordem
    public void emOrdem() {
        emOrdemRecursivo(raiz);
    }

    private void emOrdemRecursivo(No atual) {

        if (atual != null) {

            emOrdemRecursivo(atual.esquerda);

            System.out.print(atual.valor + " ");

            emOrdemRecursivo(atual.direita);
        }
    }
}