/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s6_rodrigo_vasquez;

import java.util.Scanner;
import java.util.Timer; // Clase utilizada para simular el "tiempo limitado" de la reserva
import java.util.TimerTask;
        
public class Exp2_S6_Rodrigo_Vasquez {

    // Paso 2: Declaración e inialización de variables estáticas
    
    static int capacidadTotal = 30; // Capacidad total de la sala
    static String nombreTeatro = "Teatro Moro"; // Nombre del teatro
    static int precioUnitario = 15000; // Precio fijo de las entradas
    
    // Asientos disponibles (true= vendido/ocupado, false= libre)
    static boolean A1 = false, A2 = false, A3 = false, A4 = false, A5 = false, A6 = false;
    static boolean B1 = false, B2 = false, B3 = false, B4 = false, B5 = false, B6 = false;
    static boolean C1 = false, C2 = false, C3 = false, C4 = false, C5 = false, C6 = false;
    static boolean D1 = false, D2 = false, D3 = false, D4 = false, D5 = false, D6 = false;
    static boolean E1 = false, E2 = false, E3 = false, E4 = false, E5 = false, E6 = false;
    
    // Variables para manejo de la reserva temporal
    static String reservaPendienteCodigo = null; // Almacena el código del asiento reservado temporalmente
    static Timer temporizadorReserva = null;
    static long reservaPendienteLimite = 0; // Límite de tiempo en milisegundos 
    
    // Variable para inicializar el saldo a pagar
    static int totalApagar = 0;

    // Tiempo de reserva en milisegundos (5 minutos)
    static long tiempoReservaMS = 5 * 60 * 1000;

    public static void main(String[] args) {
        
        // Inicialización del Scanner
        Scanner teclado = new Scanner(System.in);
        
    }
    
}
