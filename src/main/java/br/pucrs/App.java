package br.pucrs;

import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.css.Counter;

public class App 
{

    public static Contador contador;
    private static int nOpAtual = 0;

    public static void main( String[] args )
    {
        contador = new Contador();

        ArrayList<Integer> nOp = new ArrayList<>();
        nOp.add(32);
        nOp.add(2048);
        nOp.add(1048576);
        for(int nOpe : nOp) {
            int[] vet = geraVetor(nOpe, nOpe);
            vet = merge_sort(vet);
        }
        contador.toCSV("merge_sort");

        contador.startAgain();
        int maxVal = maxVal1(vet, vet.length);
        contador.toCSV("maxVal1");
        System.out.println("Maior valor: " + maxVal);

        contador.startAgain();
        System.out.println("Maior valor: " + maxVal2(vet, 0, vet.length - 1));
        contador.toCSV("maxVal2");


        contador.startAgain();
        System.out.println("Multiplicação: " + Multiply(1844674407370955161L, 1844674407370955161L, 64));
        contador.toCSV("Multiply");
    }

    public static long Multiply(long x, long y, long n){
        if(n == 1){
            contador.increment(nOpAtual);
            return x * y;
        }  else{
            contador.increment(nOpAtual);
            long m = n / 2;
            long a = x / (long)Math.pow(2, m); 
            long b = x % (long)Math.pow(2, m);
            long c = y / (long)Math.pow(2, m);
            long d = y % (long)Math.pow(2, m);
            long e = Multiply(a, c, m);
            long f = Multiply(b, d, m);
            long g = Multiply(b, c, m);
            long h = Multiply(a, d, m);
            return (long)Math.pow(2, 2*m) * e + (long)Math.pow(2, m) * (g + h) + f;
        }

    }

    public static int maxVal2(int A[], int init, int end) {  
        if (end - init <= 1){
            contador.increment(nOpAtual);
            return Math.max(A[init], A[end]);  
        }
        else {
            contador.increment(nOpAtual);
              int m = (init + end)/2;
              int v1 = maxVal2(A,init,m);   
              int v2 = maxVal2(A,m+1,end);  
              return Math.max(v1,v2);
             }
    }

    public static int maxVal1(int A[], int n) {  
        contador.increment(nOpAtual);
        int max = A[0];
        for (int i = 1; i < n; i++) { 
            contador.increment(nOpAtual); 
            if( A[i] > max ) 
               max = A[i];
        }
        return max;
    }

    public static int[] merge_sort(int[] vet) {
        if(vet.length == 1) {
            contador.increment(nOpAtual);
            return vet;
        }

        contador.increment(nOpAtual);
        int mid = vet.length / 2;
        int[] left = new int[mid];
        int[] right = new int[vet.length - mid];

        for(int i = 0; i < mid; i++) {
            contador.increment(nOpAtual);
            left[i] = vet[i];
        }

        for(int i = mid; i < vet.length; i++) {
            contador.increment(nOpAtual);
            right[i - mid] = vet[i];
        }

        contador.increment(nOpAtual);
        left = merge_sort(left);
        contador.increment(nOpAtual);
        right = merge_sort(right);
        contador.increment(nOpAtual);
        vet = merge(left, right);


        return vet;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] vet = new int[left.length + right.length];
        contador.increment(nOpAtual);
        int i = 0, j = 0;
        while(i < left.length && j < right.length) {
            
            if(left[i] < right[j]) {
                contador.increment(nOpAtual);
                vet[i+j] = left[i];
                i++;
            } else {
                contador.increment(nOpAtual);
                vet[i+j] = right[j];
                j++;
            }
            op++;
        }

        while(i < left.length) {
            contador.increment(nOpAtual);
            vet[i+j] = left[i];
            i++;
        }

        while(j < right.length) {
            contador.increment(nOpAtual);
            vet[i+j] = right[j];
            j++;
        }
        
    return vet;

    }

    private static int[] geraVetor(int nroPares, int nroImpares){
        int [] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                (nroPares + nroImpares > 0)) {
                    contador.increment(nOpAtual);
            res = new int[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                contador.increment(nOpAtual);
                novoNum = rnd.nextInt(98)+1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    contador.increment(nOpAtual);
                    res[contPar+contImpar] = novoNum;
                    contPar++;
                }
                else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    contador.increment(nOpAtual);
                    res[contPar+contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }
}
