package Dicionário;

import Dicionário.*;

public class Hash implements Dict {
    private Item[] array;
    private int capacidade;
    private int tamanho;

    private Hash(int capacidade) {
        if (!this.isPrimo(capacidade)) {
            this.capacidade = capacidade;
        } else {
            this.capacidade = proximoPrimo(capacidade);
        }
        this.array = new Item[this.capacidade];
        this.tamanho = 0;
    }

    private void insertItem(int k, Object o) {
        Item itemNovo = new Item(k, o);

        int index = this.dispercao(k);

        // Hashing duplo
        while(!(array[index] == null || array[index].value().equals("Available"))){
            index = index + this.segundaDispersao(k);
        }

        this.array[index] = itemNovo;
        tamanho++;
    }

    private int dispercao(int k) {
        int hash = this.codeHash(k);
        int compressao = this.mapaCompressao(hash);
        return compressao;
    }
    
    private int segundaDispersao(int k){
        int hash = this.codeHash2(k);
        int compressao = this.mapaCompressao2(hash);
        return compressao;
    }

    private int codeHash(int k) {
        return k;
    }

    private int mapaCompressao(int hash) {
        return hash % this.capacidade;
    }
    private int codeHash2(int k) {
        return k;
    }

    private int mapaCompressao2(int hash) {
        return hash % this.proximoPrimo(this.capacidade/2);
    }

    private boolean isPrimo(int num) {
        if (num <= 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(num); i+=2) {
            if (num % i == 0) {
                return false;
            }

            return true;
        }
    }

    private int proximoPrimo(int num) {
        int candidato = num + 1;
        while (!isPrimo(candidato)) {
            candidato++;
        }

        return candidato;
    }
}