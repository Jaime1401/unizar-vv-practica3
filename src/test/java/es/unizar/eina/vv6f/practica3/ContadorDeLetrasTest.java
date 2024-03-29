package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ContadorDeLetrasTest {

    private static final int[] HAMLET_ARRAY = new int[]{9912, 1816, 2612, 5044, 14986, 2682, 2418, 8681, 8488, 111, 1268, 5828, 4253, 8306, 11193, 2013, 218, 7741, 8326, 11770, 4322, 1225, 3129, 175, 3196, 72, 0};
    private static final int[] REGENTA_ARRAY = new int[]{195175, 26862, 53217, 68273, 178917, 8620, 15404, 13913, 87589, 6505, 61, 84711, 37053, 88950, 129829, 34482, 17977, 90627, 102937, 54752, 58427, 15717, 19, 1240, 13826, 5632, 3534};
    private static final int[] QUIJOTE_ARRAY = new int[]{200495,24147,59436,87237,229189,7581,17225,19920,90075,10530,0,89141,44658,108441,162514,35465,32483,100954,125727,61749,79559,17855,2,377,25115,6491,4241};

    @Test
    void ficheroVacio() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/vacio.txt"));
        int[] arrayVacio = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(arrayVacio, contadorDeLetras.frecuencias());
    }

    @Test
    void shouldThrowNullPointerExceptionWhenFicheroIsNull() {
        assertThrows(
                NullPointerException.class
                ,() -> {
                    ContadorDeLetras contadorDeLetras = new ContadorDeLetras(null);
                    contadorDeLetras.frecuencias();
                });
    }
    @Test
    void shouldThrowFileNotFoundExceptionWhenFicheroNotExistOrCantRead() {
        assertThrows(
                FileNotFoundException.class
                ,() -> {
            ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/hola.txt"));
            contadorDeLetras.frecuencias();
        });
    }

    @Test
    void casoMayusculaYMinusculaSinAcento() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/MayMinSinAcento.txt"));
        int[] arrayAComprobar = new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0};
        assertArrayEquals(arrayAComprobar, contadorDeLetras.frecuencias());
    }

    @Test
    void casoñÑ() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/ñÑ.txt"));
        int[] arrayAComprobar = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
        assertArrayEquals(arrayAComprobar, contadorDeLetras.frecuencias());
    }

    @Test
    void casoMayusculaYMinusculaConAcento() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/MayMinConAcento.txt"));
        int[] arrayAComprobar = new int[]{8,0,0,0,8,0,0,0,8,0,0,0,0,0,8,0,0,0,0,0,8,0,0,0,0,0,0};
        assertArrayEquals(arrayAComprobar, contadorDeLetras.frecuencias());
    }

    @Test
    void casoCaracteresEspeciales() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/CaractEspeciales.txt"));
        int[] arrayAComprobar = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(arrayAComprobar, contadorDeLetras.frecuencias());
    }

    @Test
    void casoNumeros() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/Numeros.txt"));
        int[] arrayAComprobar = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(arrayAComprobar, contadorDeLetras.frecuencias());
    }

    @Test
    void casoHamlet() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/hamlet.txt"));
        assertArrayEquals(HAMLET_ARRAY, contadorDeLetras.frecuencias());
    }

    @Test
    void casoQuijote() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/quijote.txt"));
        assertArrayEquals(QUIJOTE_ARRAY, contadorDeLetras.frecuencias());
    }

    @Test
    void casoRegenta() throws FileNotFoundException{
        ContadorDeLetras contadorDeLetras = new ContadorDeLetras(new File("src/main/res/regenta.txt"));
        assertArrayEquals(REGENTA_ARRAY, contadorDeLetras.frecuencias());
    }
}