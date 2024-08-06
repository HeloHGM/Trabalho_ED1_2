// Classe representando um nó na lista encadeada
class No {
    int info;
    No prox;
    
    public No(int info) {
        this.info = info;
        this.prox = null;
    }
}

// Classe representando a lista simplesmente encadeada ordenada
class Lista {
    private No cabeca;
    private int tamanho;

    public Lista() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    // verificar se a lista está vazia
    public boolean isEmpty() {
        return this.cabeca == null;
    }

    // inserir um elemento
    public void insert(int valor) {
        No novo = new No(valor);
        if (this.isEmpty() || this.cabeca.info >= valor) {
            novo.prox = this.cabeca;
            this.cabeca = novo;
        } else {
            No atual = this.cabeca;
            while (atual.prox != null && atual.prox.info < valor) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            atual.prox = novo;
        }
        this.tamanho++;
    }

    // remover um elemento
    public boolean remove(int valor) {
        if (this.isEmpty()) return false;
        if (this.cabeca.info == valor) {
            this.cabeca = this.cabeca.prox;
            this.tamanho--;
            return true;
        }
        No atual = this.cabeca;
        while (atual.prox != null && atual.prox.info != valor) {
            atual = atual.prox;
        }
        if (atual.prox == null) return false;
        atual.prox = atual.prox.prox;
        this.tamanho--;
        return true;
    }

    // retornar o tamanho
    public int size() {
        return this.tamanho;
    }

    // verificar se duas listas são iguais
    public boolean equals(Lista outra) {
        if (this.size() != outra.size()) return false;
        No atual1 = this.cabeca;
        No atual2 = outra.cabeca;
        while (atual1 != null) {
            if (atual1.info != atual2.info) return false;
            atual1 = atual1.prox;
            atual2 = atual2.prox;
        }
        return true;
    }

    // calcular a média dos elementos 
    public double avg() {
        if (this.isEmpty()) return 0.0;
        int soma = 0;
        No atual = this.cabeca;
        while (atual != null) {
            soma += atual.info;
            atual = atual.prox;
        }
        return (double) soma / this.size();
    }

    // Método para buscar um elemento
    public boolean search(int valor) {
        No atual = this.cabeca;
        while (atual != null) {
            if (atual.info == valor) return true;
            atual = atual.prox;
        }
        return false;
    }

    // Método para eliminar todas as ocorrências de um dado elemento
    public void eliminate(int valor) {
        while (this.cabeca != null && this.cabeca.info == valor) {
            this.cabeca = this.cabeca.prox;
            this.tamanho--;
        }
        No atual = this.cabeca;
        while (atual != null && atual.prox != null) {
            if (atual.prox.info == valor) {
                atual.prox = atual.prox.prox;
                this.tamanho--;
            } else {
                atual = atual.prox;
            }
        }
    }

    // Método para eliminar um elemento em uma dada posição
    public boolean eliminate_(int pos) {
        if (pos < 0 || pos >= this.size()) return false;
        if (pos == 0) {
            this.cabeca = this.cabeca.prox;
            this.tamanho--;
            return true;
        }
        No atual = this.cabeca;
        for (int i = 0; i < pos - 1; i++) {
            atual = atual.prox;
        }
        atual.prox = atual.prox.prox;
        this.tamanho--;
        return true;
    }

    // Método para inserir um valor à direita do n-ésimo elemento
    public boolean insertRight(int n, int valor) {
        if (n < 0 || n >= this.size()) return false;
        No atual = this.cabeca;
        for (int i = 0; i < n; i++) {
            atual = atual.prox;
        }
        No novo = new No(valor);
        novo.prox = atual.prox;
        atual.prox = novo;
        this.tamanho++;
        return true;
    }

    // Método para inserir um valor à esquerda do n-ésimo elemento
    public boolean insertLeft(int n, int valor) {
        if (n < 0 || n >= this.size()) return false;
        if (n == 0) {
            this.insert(valor);
            return true;
        }
        No atual = this.cabeca;
        for (int i = 0; i < n - 1; i++) {
            atual = atual.prox;
        }
        No novo = new No(valor);
        novo.prox = atual.prox;
        atual.prox = novo;
        this.tamanho++;
        return true;
    }

    // Método para imprimir os elementos da lista
    public void printList() {
        No atual = this.cabeca;
        while (atual != null) {
            System.out.print(atual.info + " ");
            atual = atual.prox;
        }
        System.out.println();
    }
}

// Testar a classe Lista
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        // Inicializar a lista com alguns elementos
        lista.insert(5);
        lista.insert(1);
        lista.insert(3);
        lista.insert(2);
        lista.insert(4);

        // Imprimir a lista
        System.out.println("Lista inicial:");
        lista.printList();

        // Verificar se a lista está vazia
        System.out.println("A lista está vazia? " + lista.isEmpty());

        // Inserir um novo elemento
        lista.insert(0);
        System.out.println("Lista após inserir 0:");
        lista.printList();

        // Remover um elemento
        lista.remove(3);
        System.out.println("Lista após remover 3:");
        lista.printList();

        // Obter o tamanho da lista
        System.out.println("Tamanho da lista: " + lista.size());

        // Calcular a média dos elementos
        System.out.println("Média dos elementos: " + lista.avg());

        // Buscar um elemento
        System.out.println("O 2 está na lista? " + lista.search(2));

        // Eliminar todas as ocorrências de um elemento
        lista.eliminate(2);
        System.out.println("Lista após eliminar 2:");
        lista.printList();

        // Eliminar um elemento em uma dada posição
        lista.eliminate_(2);
        System.out.println("Lista após eliminar o elemento na posição 2:");
        lista.printList();

        // Inserir à direita do n-ésimo elemento
        lista.insertRight(1, 6);
        System.out.println("Lista após inserir 6 à direita da posição 1:");
        lista.printList();

        // Inserir à esquerda do n-ésimo elemento
        lista.insertLeft(1, 7);
        System.out.println("Lista após inserir 7 à esquerda da posição 1:");
        lista.printList();
    }
}
