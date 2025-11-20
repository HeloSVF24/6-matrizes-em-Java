/*Primeiro projeto com 6 matrizes.
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho_matrizes;

/**
 *
 * @author Heloisa Silva 1 DS/AMS
 */

import java.util.Scanner;

public class Trabalho_Matrizes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("==== TRABALHOS MATRIZES ====");
            System.out.println("1) Matriz 4x4 - soma e média dos pares");
            System.out.println("2) Criar e exibir matrizes do enunciado");
            System.out.println("3) Matriz 5x5 - operações com ímpares/linhas/colunas");
            System.out.println("4) Matriz 3x5 - repetidos, pares e ímpares");
            System.out.println("5) Matriz 4x4 decimais - diagonais");
            System.out.println("6) Figuras usando matrizes");
            System.out.println("0) Sair");
            System.out.print("Opção: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 1: exercicio1(in); break;
                case 2: exercicio2(); break;
                case 3: exercicio3(in); break;
                case 4: exercicio4(in); break;
                case 5: exercicio5(in); break;
                case 6: exercicio6(); break;
                case 0: System.out.println("Fim."); break;
                default: System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 0);

        in.close();
    }

    // 1) Leia matriz 4x4 e mostre soma e média dos números pares digitados
    private static void exercicio1(Scanner in) {
        int[][] m = new int[4][4];
        int somaPares = 0;
        int qtdePares = 0;

        System.out.println("Digite os 16 valores da matriz 4x4 (inteiros):");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("m[%d][%d] = ", i, j);
                m[i][j] = in.nextInt();
                if (m[i][j] % 2 == 0) {
                    somaPares += m[i][j];
                    qtdePares++;
                }
            }
        }

        System.out.println("Soma dos números pares: " + somaPares);
        if (qtdePares > 0) {
            double media = (double) somaPares / qtdePares;
            System.out.println("Média dos números pares: " + media);
        } else {
            System.out.println("Não há números pares.");
        }
    }

    // 2) Criar e exibir as matrizes do enunciado (valores fixos)
    private static void exercicio2() {
        // a) matriz de letras 3x5 (exemplo aproximado do enunciado)
        char[][] a = {
            {'a','b','c','d','e'},
            {'f','g','h','i','j'},
            {'q','r','s','t','u'}
        };

        // b) matriz de inteiros 3x5 (exemplo com valores parecidos ao enunciado)
        int[][] b = {
            {19, 25, 100, 99,  1},
            {10,  7,  25,  7, 14},
            {35,  2,  47, 74, 24}
        };

        // c) matriz de decimais 3x4 (exemplo de valores)
        double[][] c = {
            {1.9,  2.5, 10.0,  1.0},
            {1.0,  7.8,  2.5,  2.5},
            {3.5,  2.2,  4.7,  9.9}
        };

        System.out.println("Matriz a) (char 3x5):");
        imprimeMatriz(a);

        System.out.println("Matriz b) (int 3x5):");
        imprimeMatriz(b);

        System.out.println("Matriz c) (double 3x4):");
        imprimeMatriz(c);
    }

    // 3) matriz 5x5 inteiros: soma dos ímpares, soma de cada coluna e de cada linha
    private static void exercicio3(Scanner in) {
        int[][] m = new int[5][5];

        System.out.println("Digite os 25 valores da matriz 5x5 (inteiros):");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("m[%d][%d] = ", i, j);
                m[i][j] = in.nextInt();
            }
        }

        int somaImpares = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (m[i][j] % 2 != 0) somaImpares += m[i][j];
            }
        }

        System.out.println("Soma dos números ímpares: " + somaImpares);

        // soma de cada coluna
        System.out.println("Soma de cada uma das 5 colunas:");
        for (int j = 0; j < 5; j++) {
            int somaCol = 0;
            for (int i = 0; i < 5; i++) {
                somaCol += m[i][j];
            }
            System.out.println("Coluna " + j + ": " + somaCol);
        }

        // soma de cada linha
        System.out.println("Soma de cada uma das 5 linhas:");
        for (int i = 0; i < 5; i++) {
            int somaLin = 0;
            for (int j = 0; j < 5; j++) {
                somaLin += m[i][j];
            }
            System.out.println("Linha " + i + ": " + somaLin);
        }
    }

    // 4) Matriz 3x5 inteiros: repetidos, qtde de pares e impares
    private static void exercicio4(Scanner in) {
        int[][] m = new int[3][5];
        System.out.println("Digite os 15 valores da matriz 3x5 (inteiros):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("m[%d][%d] = ", i, j);
                m[i][j] = in.nextInt();
            }
        }

        int pares = 0, impares = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (m[i][j] % 2 == 0) pares++;
                else impares++;
            }
        }

        boolean temRepetido = false;
        // verifica repetidos percorrendo tudo comparando
        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 5; j1++) {
                for (int i2 = 0; i2 < 3; i2++) {
                    for (int j2 = 0; j2 < 5; j2++) {
                        if (!(i1 == i2 && j1 == j2) && m[i1][j1] == m[i2][j2]) {
                            temRepetido = true;
                        }
                    }
                }
            }
        }

        if (temRepetido) {
            System.out.println("A matriz possui elementos repetidos.");
        } else {
            System.out.println("A matriz NÃO possui elementos repetidos.");
        }

        System.out.println("Quantidade de números pares: " + pares);
        System.out.println("Quantidade de números ímpares: " + impares);
    }

    // 5) Matriz 4x4 decimais: mostrar diagonal principal e secundária
    private static void exercicio5(Scanner in) {
        double[][] m = new double[4][4];

        System.out.println("Digite os 16 valores da matriz 4x4 (decimais):");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("m[%d][%d] = ", i, j);
                m[i][j] = in.nextDouble();
            }
        }

        System.out.println("Diagonal principal:");
        for (int i = 0; i < 4; i++) {
            System.out.println(m[i][i]);
        }

        System.out.println("Diagonal secundária:");
        for (int i = 0; i < 4; i++) {
            System.out.println(m[i][3 - i]);
        }
    }

    // 6) Figuras usando matrizes (vou representar com 0 e 1 e apenas imprimir)
    private static void exercicio6() {
        int[][] figuraA = {
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,1,1,1,1}
        };

        int[][] figuraB = {
            {1,0,0,0,1},
            {1,1,1,1,1},
            {1,0,0,0,1}
        };

        int[][] figuraC = {
            {0,0,1,0,0},
            {0,1,1,1,0},
            {1,1,1,1,1}
        };

        System.out.println("Figura a):");
        imprimeFigura(figuraA);

        System.out.println("Figura b):");
        imprimeFigura(figuraB);

        System.out.println("Figura c):");
        imprimeFigura(figuraC);
    }

    // ---------- Funções auxiliares de impressão ----------

    private static void imprimeMatriz(char[][] m) {
        for (char[] linha : m) {
            for (char v : linha) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    private static void imprimeMatriz(int[][] m) {
        for (int[] linha : m) {
            for (int v : linha) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }

    private static void imprimeMatriz(double[][] m) {
        for (double[] linha : m) {
            for (double v : linha) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }

    private static void imprimeFigura(int[][] f) {
        for (int[] linha : f) {
            for (int v : linha) {
                System.out.print(v == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}


