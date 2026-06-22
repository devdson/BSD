public class Main {

    // Classe do nó
    static class No {
        int valor;
        No esquerda;
        No direita;

        public No(int valor) {
            this.valor = valor;
        }
    }

    // Inserção
    public static No inserir(No raiz, int valor) {

        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserir(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserir(raiz.direita, valor);
        }

        return raiz;
    }

    // Busca
    public static boolean buscar(No raiz, int valor) {

        if (raiz == null) {
            return false;
        }

        if (raiz.valor == valor) {
            return true;
        }

        if (valor < raiz.valor) {
            return buscar(raiz.esquerda, valor);
        }

        return buscar(raiz.direita, valor);
    }

    public static No encontrarMenor(No raiz) {

        while (raiz.esquerda != null) {
            raiz = raiz.esquerda;
        }

        return raiz;
    }


    public static No remover(No raiz, int valor) {

        if (raiz == null) {
            return null;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = remover(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = remover(raiz.direita, valor);
        } else {

            if (raiz.esquerda == null) {
                return raiz.direita;
            }

            if (raiz.direita == null) {
                return raiz.esquerda;
            }

            No sucessor = encontrarMenor(raiz.direita);

            raiz.valor = sucessor.valor;

            raiz.direita = remover(raiz.direita, sucessor.valor);
        }

        return raiz;
    }


    public static void emOrdem(No raiz) {

        if (raiz != null) {
            emOrdem(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.direita);
        }
    }

    public static void preOrdem(No raiz) {

        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdem(raiz.esquerda);
            preOrdem(raiz.direita);
        }
    }

    public static void posOrdem(No raiz) {

        if (raiz != null) {
            posOrdem(raiz.esquerda);
            posOrdem(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }
    public static void main(String[] args) {

        No raiz = null;

        // Inserções
        raiz = inserir(raiz, 50);
        raiz = inserir(raiz, 30);
        raiz = inserir(raiz, 70);
        raiz = inserir(raiz, 20);
        raiz = inserir(raiz, 40);
        raiz = inserir(raiz, 60);
        raiz = inserir(raiz, 80);

        System.out.println("Arvore criada!");
        System.out.println();

        // Busca
        System.out.println("Buscando o valor 40:");
        System.out.println(buscar(raiz, 40));
        System.out.println();

        // Percursos
        System.out.print("Em Ordem: ");
        emOrdem(raiz);
        System.out.println();

        System.out.print("Pre-Ordem: ");
        preOrdem(raiz);
        System.out.println();

        System.out.print("Pos-Ordem: ");
        posOrdem(raiz);
        System.out.println("\n");

        // Remoção
        System.out.println("Removendo o valor 70...");
        raiz = remover(raiz, 70);

        System.out.println();

        System.out.print("Em Ordem apos remocao: ");
        emOrdem(raiz);
        System.out.println();
    }
}