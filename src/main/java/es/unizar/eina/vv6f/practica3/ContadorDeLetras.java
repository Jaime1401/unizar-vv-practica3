package es.unizar.eina.vv6f.practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.Scanner;

/**
 * Clase para el análisis de la frecuencia de aparición de letras del alfabeto español en un
 * fichero de texto. Los objetos de esta clase se construyen utilizando como argumento un objeto de
 * la clase File que representa el fichero de texto que se quiere analizar. La primera invocación al
 * método frecuencias() analiza el contenido del fichero de texto y, si se ha podido procesar,
 * devuelve un vector de siempre 27 componentes de tipo entero. Las primeras 26 componentes
 * almacenan el número de apariciones de las 26 letras del alfabeto inglés. La última componente
 * almacena el número de apariciones de la letra Ñ.
 *
 * No se distingue entre mayúsculas y minúsculas. En español, la letra Ñ es una letra distinta a la
 * N. El resto de apariciones de letras voladas y caracteres con diacríticos (acentos agudos,
 * graves, diéresis, cedillas), se consideran como ocurrencias de la letra correspondiente sin
 * diacríticos.
 *
 */
public class ContadorDeLetras {
    private File fichero;
    private int[] frecuencias = null;

    /**
     * Construye un ContadorDeLetras para frecuencias la frecuencia en las que aparecen las letras
     * del fichero «fichero».
     * @param fichero
     *            fichero de texto cuyo contenido será analizado.
     */
    public ContadorDeLetras(File fichero) {
            this.fichero = fichero;
    }

    public String quitarAcento(String input){
        //normaliza el texto y convertir los caracteres a su forma base
        String output = Normalizer.normalize(input, Normalizer.Form.NFD);
        //expresión regular para eliminar todos los caracteres diacríticos (como las tildes, diéresis y acentos circunflejos)
        output = output.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        //eliminar todos los caracteres que no sean ASCII
        output = output.replaceAll("[^\\p{ASCII}]", "");
        return output;
    }
    /**
     * Si no ha sido analizado ya, analiza el contenido del fichero de texto asociado a este
     * objeto en el constructor. Devuelve un vector de 27 componentes con las frecuencias
     * absolutas de aparición de cada letra del alfabeto español en el fichero.
     *
     * @return vector de 27 componentes de tipo entero. Las primeras 26 componentes almacenan el
     *         número de apariciones de las 26 letras del alfabeto inglés: la componente indexada
     *         por 0 almacena el número de apariciones de la letra A, la componente indexada por 1,
     *         el de la letra B y así sucesivamente. La última componente, almacena el número de
     *         apariciones de la letra Ñ.
     * @throws FileNotFoundException
     *             si el fichero de texto que se especificó al construir este objeto no existe o no
     *             puede abrirse.
     */
    public int[] frecuencias() throws FileNotFoundException {
        if (frecuencias == null) {
            if (this.fichero.exists() && this.fichero.canRead()){
                frecuencias = new int[27];
                Scanner input = new Scanner(this.fichero);
                while (input.hasNextLine()) {
                    String line = quitarAcento(input.nextLine().toLowerCase());
                    for(int posicion = 0; posicion < line.length(); posicion++){
                        char letra = line.charAt(posicion);
                        if(letra == 'ñ' || letra == 'Ñ'){
                            frecuencias[26]++;
                        } else if ('a' <= letra && letra <= 'z') {
                            frecuencias[letra - 'a']++;
                        }
                    }
                }
                input.close();
            } else {
                throw new FileNotFoundException();
            }
        }
        return frecuencias;
    }
}
