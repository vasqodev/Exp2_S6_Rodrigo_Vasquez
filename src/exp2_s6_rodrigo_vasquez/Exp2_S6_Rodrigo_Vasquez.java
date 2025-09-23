/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s6_rodrigo_vasquez;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Timer; // Clase utilizada para simular el "tiempo limitado" de la reserva
import java.util.TimerTask;
import java.util.InputMismatchException; //Usado para manejo de errores de entrada

//La clase principal representa la solución al problema planteado (Input-Process-Output)
        
public class Exp2_S6_Rodrigo_Vasquez {

    // Paso 2: Declaración en inialización de variables estáticas
    
    static int capacidadTotal = 80; // Capacidad total de la sala
    static String nombreTeatro = "Teatro Moro"; // Nombre del teatro
    static int precioUnitario = 15000; // Precio base de las entradas
    
    // Asientos disponibles (contadores sencillos para asientos disponibles)
    static int asientosDisponibles = capacidadTotal;
    static int asientosReservados = 0;
    static int asientosVendidos = 0;

    /* Utilizamos un arreglo (Array) para rastrear el estado de los 80 asientos individuales. 
     * Los arreglos son estructuras de datos que almacenan múltiples elementos del mismo tipo.
     * 0: Libre, 1: Reservado, 2: Vendido 
     */
    static int[] estadoAsientos = new int[capacidadTotal];

    // Arreglo para almacenar los Timers de las reservas (para poder cancelarlos o comprarlos)
    static Timer[] timersReserva = new Timer[capacidadTotal];

    public static void main(String[] args) {
        // Inicialización del Scanner
        Scanner teclado = new Scanner(System.in);
        int opcion; // Variable local para la entrada del usuario (opción deseada)
        
    }
    
}
