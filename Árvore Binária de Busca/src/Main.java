public class Main {

    public static void main(String[] args) {

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Busca pelo valor 40:");
        System.out.println(arvore.buscar(40));

        System.out.println("\nPercurso em ordem:");
        arvore.emOrdem();
    }
}