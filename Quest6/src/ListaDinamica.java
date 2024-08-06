import java.util.LinkedList;
import java.util.Random;

class No {
    int info;
    No prox;

    No(int info) {
        this.info = info;
        this.prox = null;
    }
}

class Lista {
    No cabeca;
    int tamanho;

    Lista() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    void inserir(int info) {
        No novoNo = new No(info);
        if (cabeca == null || cabeca.info >= info) {
            novoNo.prox = cabeca;
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.prox != null && atual.prox.info < info) {
                atual = atual.prox;
            }
            novoNo.prox = atual.prox;
            atual.prox = novoNo;
        }
        tamanho++;
    }

    LinkedList<Integer> toLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        No atual = cabeca;
        while (atual != null) {
            list.add(atual.info);
            atual = atual.prox;
        }
        return list;
    }
}

public class ListaDinamica {
    public static Lista inverter(Lista lista) {
        Lista novaLista = new Lista();
        No atual = lista.cabeca;
        while (atual != null) {
            No novoNo = new No(atual.info);
            novoNo.prox = novaLista.cabeca;
            novaLista.cabeca = novoNo;
            novaLista.tamanho++;
            atual = atual.prox;
        }
        return novaLista;
    }

    public static Lista retornarImpares(Lista lista1, Lista lista2) {
        Lista novaLista = new Lista();
        adicionarImpares(lista1, novaLista);
        adicionarImpares(lista2, novaLista);
        return novaLista;
    }

    private static void adicionarImpares(Lista lista, Lista novaLista) {
        No atual = lista.cabeca;
        while (atual != null) {
            if (atual.info % 2 != 0) {
                novaLista.inserir(atual.info);
            }
            atual = atual.prox;
        }
    }

    public static Lista concatenar(Lista lista1, Lista lista2) {
        Lista novaLista = new Lista();
        adicionarElementos(lista1, novaLista);
        adicionarElementos(lista2, novaLista);
        return novaLista;
    }

    private static void adicionarElementos(Lista lista, Lista novaLista) {
        No atual = lista.cabeca;
        while (atual != null) {
            novaLista.inserir(atual.info);
            atual = atual.prox;
        }
    }

    public static Lista interseccao(Lista lista1, Lista lista2) {
        Lista novaLista = new Lista();
        No atual1 = lista1.cabeca;
        while (atual1 != null) {
            No atual2 = lista2.cabeca;
            while (atual2 != null) {
                if (atual1.info == atual2.info) {
                    novaLista.inserir(atual1.info);
                    break;
                }
                atual2 = atual2.prox;
            }
            atual1 = atual1.prox;
        }
        return novaLista;
    }

    public static Lista intercalar(Lista lista1, Lista lista2) {
        Lista novaLista = new Lista();
        No atual1 = lista1.cabeca;
        No atual2 = lista2.cabeca;
        while (atual1 != null && atual2 != null) {
            if (atual1.info < atual2.info) {
                novaLista.inserir(atual1.info);
                atual1 = atual1.prox;
            } else {
                novaLista.inserir(atual2.info);
                atual2 = atual2.prox;
            }
        }
        while (atual1 != null) {
            novaLista.inserir(atual1.info);
            atual1 = atual1.prox;
        }
        while (atual2 != null) {
            novaLista.inserir(atual2.info);
            atual2 = atual2.prox;
        }
        return novaLista;
    }

    public static Lista intercalarOrdenadamente(Lista lista1, Lista lista2) {
        Lista novaLista = new Lista();
        No atual1 = lista1.cabeca;
        No atual2 = lista2.cabeca;
        while (atual1 != null && atual2 != null) {
            if (atual1.info <= atual2.info) {
                novaLista.inserir(atual1.info);
                atual1 = atual1.prox;
            } else {
                novaLista.inserir(atual2.info);
                atual2 = atual2.prox;
            }
        }
        while (atual1 != null) {
            novaLista.inserir(atual1.info);
            atual1 = atual1.prox;
        }
        while (atual2 != null) {
            novaLista.inserir(atual2.info);
            atual2 = atual2.prox;
        }
        return novaLista;
    }

    public static void main(String[] args) {
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            lista1.inserir(random.nextInt(201) - 100);
            lista2.inserir(random.nextInt(201) - 100);
        }

        Lista listaInvertida = inverter(lista1);
        System.out.println("Lista invertida: " + listaInvertida.toLinkedList());

        Lista listaImpares = retornarImpares(lista1, lista2);
        System.out.println("Lista de ímpares: " + listaImpares.toLinkedList());

        Lista listaConcatenada = concatenar(lista1, lista2);
        System.out.println("Lista concatenada: " + listaConcatenada.toLinkedList());

        Lista listaInterseccao = interseccao(lista1, lista2);
        System.out.println("Lista de interseccao: " + listaInterseccao.toLinkedList());

        Lista listaIntercalada = intercalar(lista1, lista2);
        System.out.println("Lista intercalada: " + listaIntercalada.toLinkedList());

        Lista listaIntercaladaOrdenadamente = intercalarOrdenadamente(lista1, lista2);
        System.out.println("Lista intercalada ordenadamente: " + listaIntercaladaOrdenadamente.toLinkedList());
    }
}