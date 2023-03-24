package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testHamlet() throws IOException {
        String []p = {"hamlet.txt"};

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        // Crear un archivo temporal
        String nomArchive = "archiveAux.txt";
        OutputStream archivo = new FileOutputStream(nomArchive);

        Main.main(p);

        // Escribir lo que se muestra en la terminal en el archivo
        archivo.write(result.toByteArray());

        // Cerrar el archivo
        archivo.close();

        // Leer el archivo en un array de bytes
        byte[] bytes = Files.readAllBytes(Paths.get(nomArchive));

        byte[] contenidoArchivo1 = Files.readAllBytes(Paths.get("src/test/res/salida-hamlet.txt"));
        byte[] contenidoArchivo2 = Files.readAllBytes(Paths.get(nomArchive));

        assertArrayEquals(contenidoArchivo1, contenidoArchivo2);

    }
    @Test
    public void testQuijote() throws IOException {
        String []p = {"quijote.txt"};

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        // Crear un archivo temporal
        String nomArchive = "archiveAux.txt";
        OutputStream archivo = new FileOutputStream(nomArchive);

        Main.main(p);

        // Escribir lo que se muestra en la terminal en el archivo
        archivo.write(result.toByteArray());

        // Cerrar el archivo
        archivo.close();

        // Leer el archivo en un array de bytes
        byte[] bytes = Files.readAllBytes(Paths.get(nomArchive));

        byte[] contenidoArchivo1 = Files.readAllBytes(Paths.get("src/test/res/salida-quijote.txt"));
        byte[] contenidoArchivo2 = Files.readAllBytes(Paths.get(nomArchive));

        assertArrayEquals(contenidoArchivo1, contenidoArchivo2);

    }

    @Test
    public void testRegenta() throws IOException {
        String []p = {"regenta.txt"};

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        // Crear un archivo temporal
        String nomArchive = "archiveAux.txt";
        OutputStream archivo = new FileOutputStream(nomArchive);

        Main.main(p);

        // Escribir lo que se muestra en la terminal en el archivo
        archivo.write(result.toByteArray());

        // Cerrar el archivo
        archivo.close();

        // Leer el archivo en un array de bytes
        byte[] bytes = Files.readAllBytes(Paths.get(nomArchive));

        byte[] contenidoArchivo1 = Files.readAllBytes(Paths.get("src/test/res/salida-regenta.txt"));
        byte[] contenidoArchivo2 = Files.readAllBytes(Paths.get(nomArchive));

        assertArrayEquals(contenidoArchivo1, contenidoArchivo2);

    }

}