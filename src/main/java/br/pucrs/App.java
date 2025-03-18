package br.pucrs;

/**
 * Vamos começar com um algorítmo já estudado e conhecido (em AEDI). O Merge
 * Sort é um algorítmo de ordenação baseado nos seguintes passos:
 * 
 * recursivamente ordene a metade esquerda do vetor
 * recursivamente ordene a metade direita do vetor
 * mescle (faça o merge) das duas metades para ter o vetor ordenado.
 * Assim:
 * 
 * implemente o algortimo abaixo;
 * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048
 * e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo
 * executa, e o tempo gasto;
 * MERGE-SORT(L: List with n elements) : Ordered list with n elements
 * IF (list L has one element)
 * RETURN L.
 * Divide the list into two halves A and B.
 * A ← MERGE-SORT(A).
 * B ← MERGE-SORT(B).
 * L ← MERGE(A, B).
 * RETURN L.
 *
 */
public class App {
    // merge sort
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        mergeSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        int[] arr2 = { 32, 2048, 1048576 };
        for (int i : arr2) {
            System.out.println("Array size: " + i);
            int[] arr3 = new int[i];
            for (int j = 0; j < i; j++) {
                arr3[j] = (int) (Math.random() * 100);
            }
            long startTime = System.nanoTime();
            mergeSort(arr3);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Time: " + duration);
        }
    }
}
