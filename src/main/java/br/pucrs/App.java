package br.pucrs;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{

    public static int op = 0;
    public static void main( String[] args )
    {
        // int[] vet = geraVetor(16, 16);
        // vet = merge_sort(vet);

        // System.out.println(vet.length);
        // System.out.println(op);

        // System.out.println("Maior valor: " + maxVal1(vet, vet.length));
        

        // System.out.println("Maior valor: " + maxVal2(vet, 0, vet.length - 1));

        System.out.println("Multiplicação: " + Multiply(1844674407370955161L, 1844674407370955161L, 64));
        System.out.println("No operacoes: " + op);
    }

    public static long Multiply(long x, long y, long n){
        if(n == 1){
            op++;
            return x * y;
        }  else{
            op++;
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
        if (end - init <= 1)
            return Math.max(A[init], A[end]);  
        else {
              int m = (init + end)/2;
              int v1 = maxVal2(A,init,m);   
              int v2 = maxVal2(A,m+1,end);  
              return Math.max(v1,v2);
             }
    }

    public static int maxVal1(int A[], int n) {  
        int max = A[0];
        for (int i = 1; i < n; i++) {  
            if( A[i] > max ) 
               max = A[i];
        }
        return max;
    }

    public static int[] merge_sort(int[] vet) {
        if(vet.length == 1) {
            return vet;
        }


        int mid = vet.length / 2;
        int[] left = new int[mid];
        int[] right = new int[vet.length - mid];

        for(int i = 0; i < mid; i++) {
            left[i] = vet[i];
        }

        for(int i = mid; i < vet.length; i++) {
            right[i - mid] = vet[i];
        }


        left = merge_sort(left);
        right = merge_sort(right);
        vet = merge(left, right);


        return vet;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] vet = new int[left.length + right.length];
        int i = 0, j = 0;
        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                vet[i+j] = left[i];
                i++;
            } else {
                vet[i+j] = right[j];
                j++;
            }
            op++;
        }

        while(i < left.length) {
            vet[i+j] = left[i];
            i++;
        }

        while(j < right.length) {
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

            res = new int[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98)+1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar+contImpar] = novoNum;
                    contPar++;
                }
                else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar+contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }
}
