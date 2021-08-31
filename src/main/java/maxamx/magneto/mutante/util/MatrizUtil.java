package maxamx.magneto.mutante.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrizUtil {

    public static long localizaSequenciaNaHorizontal(final String[] dna, List<String> sequencia) {
        return Arrays.stream(dna)
                .filter(d->  localizaSequenciaMutante(d,sequencia) )
                .count();
    }

    public static boolean localizaSequenciaMutante(final String sequenciaColetada,List<String> sequencia) {
        return sequencia.stream().anyMatch(sequenciaColetada::contains);
    }

    public static long localizaSequenciaNaVertical(final String[] dna,List<String> sequencia) {
        String[] result = transformarColunaEmLinhas(dna);
        return Arrays.stream(result)
                .filter(d->localizaSequenciaMutante(d,sequencia))
                .count();
    }

    public static long localizaSequenciaNaDiagonalPrincipal(final String[] dna,List<String> sequencia) {
        boolean resultado = localizaSequenciaMutante(transformarDiagonalPrincipalEmLinha(dna),sequencia);
        return resultado ? 1 : 0;
    }

    public static long localizaSequenciaNaDiagonalSecundaria(final String[] dna,List<String> sequencia) {
        boolean resultado = localizaSequenciaMutante(transformarDiagonalSecundariaEmLinha(dna),sequencia);
        return resultado ? 1 : 0;
    }



    public static String[] transformarColunaEmLinhas(final String[] dna) {

        List<String> resultado = new ArrayList<>(dna[0].length());
        for (int coluna = 0; dna[0].length() > coluna; coluna++) {
            StringBuilder sb = new StringBuilder();
            for (String linha : dna) {
                sb.append(linha.charAt(coluna));
            }
            resultado.add(sb.toString());
        }
        return resultado.toArray(new String[dna.length]);
    }

    public static String transformarDiagonalPrincipalEmLinha(final String[] dna) {
        StringBuilder sb = new StringBuilder();
        for (int linha = 0; dna.length > linha; linha++) {
            sb.append(dna[linha].charAt(linha));
        }
        return sb.toString();
    }

    public static String transformarDiagonalSecundariaEmLinha(final String[] dna) {
        StringBuilder sb = new StringBuilder();
        for (int linha = 0; dna.length > linha; linha++) {
            sb.append(dna[linha].charAt(dna.length - 1 - linha));
        }
        return sb.toString();
    }

}
