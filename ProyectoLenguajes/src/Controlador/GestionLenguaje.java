package controlador;

import modelo.LenguajeProgramacion;

public class GestionLenguaje {
    private LenguajeProgramacion[] arregloLenguajes; 
    private int contadorLenguajes; 
    private static final int FACTOR_CRECIMIENTO = 2; 

   
    public GestionLenguaje() {
        arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
        contadorLenguajes = 0;
    }

    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == arregloLenguajes.length) {
            redimensionarArreglo(); 
        }
        arregloLenguajes[contadorLenguajes] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
        contadorLenguajes++;
        System.out.println("Lenguaje agregado exitosamente.");
    }

    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null; 
    }

    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < contadorLenguajes - 1; j++) {
                    arregloLenguajes[j] = arregloLenguajes[j + 1];
                }
                arregloLenguajes[contadorLenguajes - 1] = null; 
                contadorLenguajes--;
                return true;
            }
        }
        return false; 
    }

    public void imprimirLenguajes() {
        if (contadorLenguajes == 0) {
            System.out.println("No hay lenguajes registrados.");
        } else {
            for (int i = 0; i < contadorLenguajes; i++) {
                System.out.println(arregloLenguajes[i].toString());
            }
        }
    }

    private void redimensionarArreglo() {
        LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[arregloLenguajes.length * FACTOR_CRECIMIENTO];
        System.arraycopy(arregloLenguajes, 0, nuevoArreglo, 0, arregloLenguajes.length);
        arregloLenguajes = nuevoArreglo;
    }

    public LenguajeProgramacion[] getArregloLenguajes() {
        return arregloLenguajes;
    }
}
