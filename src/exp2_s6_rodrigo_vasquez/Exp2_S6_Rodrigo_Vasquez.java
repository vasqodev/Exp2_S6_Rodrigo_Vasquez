/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s6_rodrigo_vasquez;

import java.util.Scanner; // Clase para manejar la entrada del usuario
import java.util.Timer; // Clase para programar la ejecución de tareas a futuro
import java.util.TimerTask; // Clase que define la tarea a ejecutar por el Timer

// La clase principal implementa la solución siguiendo la estructura Input-Process-Output
public class Exp2_S6_Rodrigo_Vasquez {

    // PASO 2: Declaración e Inicialización de Variables Estáticas 
    
    static String nombreTeatro = "Teatro Moro";
    static int capacidadTotal = 30; // Restricción de 30 entradas
    static int precioUnitario = 15000; // Restricción de precio fijo
    static long tiempoReservaMs = 5 * 60 * 1000; // 5 minutos de reserva

    // 0: Libre | 1: Reservado | 2: Vendido
    // Fila A
    static int asientoA1 = 0, asientoA2 = 0, asientoA3 = 0, asientoA4 = 0, asientoA5 = 0, asientoA6 = 0;
    // Fila B
    static int asientoB1 = 0, asientoB2 = 0, asientoB3 = 0, asientoB4 = 0, asientoB5 = 0, asientoB6 = 0;
    // Fila C
    static int asientoC1 = 0, asientoC2 = 0, asientoC3 = 0, asientoC4 = 0, asientoC5 = 0, asientoC6 = 0;
    // Fila D
    static int asientoD1 = 0, asientoD2 = 0, asientoD3 = 0, asientoD4 = 0, asientoD5 = 0, asientoD6 = 0;
    // Fila E
    static int asientoE1 = 0, asientoE2 = 0, asientoE3 = 0, asientoE4 = 0, asientoE5 = 0, asientoE6 = 0;

    // Variables para manejo de la reserva de entradas
    static String reservaPendienteCodigo = null; // Almacena el código del asiento reservado
    static Timer temporizadorReserva = null; // Timer para la ejecución de tareas programadas
    static long reservaPendienteLimite = 0; // Límite de tiempo en milisegundos
    static int totalIngresosRecaudados = 0; 

    public static void main(String[] args) {
        
        // Inicialización del Scanner
        Scanner teclado = new Scanner(System.in);
        String opcionUsuario; // Variable local para la entrada del usuario

        // PASO 4: Uso de estructura de control eficiente: Ciclo do-while para el Menú Interactivo
        do {
            // MUESTRA DE ESTADO DE ASIENTOS (PASO 1a)
            System.out.println("\n=== ..:: " + nombreTeatro + " ::.. ===");
            System.out.println("Capacidad Total: " + capacidadTotal);
            System.out.println("Leyenda: [ ] Libre | [R] Reservado | [X] Vendido");
            System.out.print("  ");
            
            // Ciclo for para encabezado de columnas (1 a 6)
            for (int i = 1; i <= 6; i++) {
                System.out.print(" " + i + " ");
            }
            System.out.println();

            // Lógica para mostrar el estado de los 30 asientos individuales:
            System.out.println("A | " + obtenerEstadoString(asientoA1, "A1") + " " + obtenerEstadoString(asientoA2, "A2") + " "
                             + obtenerEstadoString(asientoA3, "A3") + " " + obtenerEstadoString(asientoA4, "A4") + " "
                             + obtenerEstadoString(asientoA5, "A5") + " " + obtenerEstadoString(asientoA6, "A6") + " ($" + precioUnitario + ")");

            System.out.println("B | " + obtenerEstadoString(asientoB1, "B1") + " " + obtenerEstadoString(asientoB2, "B2") + " "
                             + obtenerEstadoString(asientoB3, "B3") + " " + obtenerEstadoString(asientoB4, "B4") + " "
                             + obtenerEstadoString(asientoB5, "B5") + " " + obtenerEstadoString(asientoB6, "B6") + " ($" + precioUnitario + ")");
            
            System.out.println("C | " + obtenerEstadoString(asientoC1, "C1") + " " + obtenerEstadoString(asientoC2, "C2") + " "
                             + obtenerEstadoString(asientoC3, "C3") + " " + obtenerEstadoString(asientoC4, "C4") + " "
                             + obtenerEstadoString(asientoC5, "C5") + " " + obtenerEstadoString(asientoC6, "C6") + " ($" + precioUnitario + ")");
            
            System.out.println("D | " + obtenerEstadoString(asientoD1, "D1") + " " + obtenerEstadoString(asientoD2, "D2") + " "
                             + obtenerEstadoString(asientoD3, "D3") + " " + obtenerEstadoString(asientoD4, "D4") + " "
                             + obtenerEstadoString(asientoD5, "D5") + " " + obtenerEstadoString(asientoD6, "D6") + " ($" + precioUnitario + ")");
            
            System.out.println("E | " + obtenerEstadoString(asientoE1, "E1") + " " + obtenerEstadoString(asientoE2, "E2") + " "
                             + obtenerEstadoString(asientoE3, "E3") + " " + obtenerEstadoString(asientoE4, "E4") + " "
                             + obtenerEstadoString(asientoE5, "E5") + " " + obtenerEstadoString(asientoE6, "E6") + " ($" + precioUnitario + ")");
            
            System.out.println("----------------------------------------------------------------");

            // PASO 1: Menú Interactivo de venta
            System.out.println("1. Reservar asiento (tiempo: 5 minutos)");
            System.out.println("2. Modificar/Convertir reserva en compra"); // Incluye modificar (cambio de asiento o compra)
            System.out.println("3. Imprimir boleta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcionUsuario = teclado.nextLine().trim();

            // PASO 4: Uso de estructura de control: Switch para decisiones múltiples
            switch (opcionUsuario) {
                case "1":
                    // RESERVAR ASIENTO (PASO 1a)

                    if (reservaPendienteCodigo != null) {
                        System.out.println("Ya existe una reserva pendiente (" + reservaPendienteCodigo + "). Debe gestionarla antes de crear una nueva.");
                        continue;
                    }

                    System.out.print("Ingrese código de asiento a reservar (ej: B2, C5, E6): ");
                    String codigoAsiento = teclado.nextLine().trim().toUpperCase();

                    if (codigoAsiento.length() < 2) {
                        System.out.println("Código inválido.");
                        break;
                    }

                    char fila = codigoAsiento.charAt(0);
                    String numeroTxt = codigoAsiento.substring(1);
                    int numeroAsiento;

                    // Uso de try-catch para manejar entradas inválidas
                    try {
                        numeroAsiento = Integer.parseInt(numeroTxt);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El número de asiento es inválido.");
                        break;
                    }

                    // Validación de rango (A-E, 1-6)
                    if (fila < 'A' || fila > 'E' || numeroAsiento < 1 || numeroAsiento > 6) {
                        System.out.println("Asiento fuera de rango (Filas A-E, Columnas 1-6).");
                        break;
                    }

                    // Obtener el estado actual del asiento (0, 1, 2)
                    int estadoActual = obtenerEstado(fila, numeroAsiento);

                    // PASO 3: Validación para evitar reservar/comprar un asiento ya ocupado
                    if (estadoActual != 0) {
                        System.out.println("[!] El asiento " + codigoAsiento + " ya está " + (estadoActual == 1 ? "reservado" : "vendido") + ". Elija otro.");
                        break;
                    }

                    // Marcar como reservado (Estado 1)
                    establecerEstado(fila, numeroAsiento, 1);
                    reservaPendienteCodigo = codigoAsiento;
                    reservaPendienteLimite = System.currentTimeMillis() + tiempoReservaMs; 

                    // Reiniciar temporizador si ya existe
                    try {
                        if (temporizadorReserva != null) {
                            temporizadorReserva.cancel();
                            temporizadorReserva = null;
                        }
                    } catch (Exception e) {
                        System.out.println("Aviso: Reiniciando temporizador.");
                    }

                    // Configuración del Timer, para la reserva con tiempo limitado
                    temporizadorReserva = new Timer(true);
                    
                    char finalFila = fila;
                    int finalNumeroAsiento = numeroAsiento;
                    
                    temporizadorReserva.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            // Si el asiento sigue en estado 1 (Reservado), lo liberamos
                            if (obtenerEstado(finalFila, finalNumeroAsiento) == 1) {
                                establecerEstado(finalFila, finalNumeroAsiento, 0); // Estado 0: Libre
                                reservaPendienteCodigo = null;
                                System.out.println("\n[SISTEMA AUTOMÁTICO] La reserva del asiento " + codigoAsiento + " ha expirado (5 min) y ha sido liberada.");
                            }
                            temporizadorReserva.cancel();
                        }
                    }, tiempoReservaMs);

                    // PASO 3: Punto de depuración 1 - Transición a Reserva
                    System.out.println("[PUNTO DE DEPURACIÓN 1 - Transición a Reserva] Asiento " + codigoAsiento + " reservado. Temporizador iniciado por 5 minutos.");
                    System.out.println("Precio: $" + precioUnitario + ". Debe Confirmar (Opción 2) antes de que expire.");
                    break;
                
                case "2":
                    // MODIFICAR/CONVERTIR RESERVA EN COMPRA (PASO 1a)

                    if (reservaPendienteCodigo == null) {
                        System.out.println("No hay reservas pendientes para modificar o confirmar.");
                        break;
                    }

                    // 1. Verificar si expiró
                    if (System.currentTimeMillis() > reservaPendienteLimite) {
                        System.out.println("La reserva ya expiró, debe volver a reservar.");
                        reservaPendienteCodigo = null;
                        reservaPendienteLimite = 0;
                        try{if(temporizadorReserva != null){ temporizadorReserva.cancel();}}catch(Exception e){}
                        temporizadorReserva = null;
                        break;
                    }

                    // Simulación de modificación de reserva
                    System.out.println("Reserva pendiente para " + reservaPendienteCodigo + " ($" + precioUnitario + ")");
                    System.out.print("¿Desea Confirmar la compra (C) o Cancelar/Cambiar el asiento (X)? [C/X]: ");
                    String accion = teclado.nextLine().trim().toUpperCase();

                    if (accion.equals("C")) {
                        // Confirmar compra: Convertir estado 1 a estado 2
                        char filaReserva = reservaPendienteCodigo.charAt(0);
                        int numReserva = Integer.parseInt(reservaPendienteCodigo.substring(1));
                        
                        // 2. Marcar el asiento como VENDIDO (estado 2)
                        establecerEstado(filaReserva, numReserva, 2);

                        // 3. Actualizar contadores
                        totalIngresosRecaudados += precioUnitario;

                        // 4. Limpiar reserva y cancelar timer
                        try{if(temporizadorReserva != null){ temporizadorReserva.cancel();}}catch(Exception e){}
                        temporizadorReserva = null;
                        
                        reservaPendienteCodigo = null;
                        reservaPendienteLimite = 0;

                        // PASO 3: Punto de depuración 2 - Transición de Reserva a Compra
                        System.out.println("[PUNTO DE DEPURACIÓN 2 - Transición a Compra] Compra Exitosa para el asiento: " + filaReserva + numReserva);

                    } else if (accion.equals("X")) {
                        // Cancelación o cambio (modificación)
                        
                        // 1. Liberar el asiento reservado (estado 0)
                        char filaLiberar = reservaPendienteCodigo.charAt(0);
                        int numLiberar = Integer.parseInt(reservaPendienteCodigo.substring(1));
                        establecerEstado(filaLiberar, numLiberar, 0);

                        // 2. Cancelar Timer y limpiar reserva
                        try{if(temporizadorReserva != null){ temporizadorReserva.cancel();}}catch(Exception e){}
                        temporizadorReserva = null;
                        reservaPendienteCodigo = null;
                        reservaPendienteLimite = 0;

                        System.out.println("Reserva Cancelada. El asiento ha sido liberado.");
                        // Aquí por simplicidad se devuelve al menú principal

                    } else {
                        System.out.println("Acción no reconocida. Volviendo al menú.");
                    }
                    break;

                case "3":
                    // IMPRIMIR BOLETA (PASO 1b)

                    System.out.println("\n==== BOLETA ELECTRÓNICA "+nombreTeatro+" =====");
                    
                    // PASO 3: Punto de depuración 3 - Verificación de captura de información
                    int asientosComprados = 0;
                    int subTotalBoleta = 0;
                    System.out.println("[PUNTO DE DEPURACIÓN 3 - Verificación de Ingresos] Total recaudado (Sistema): $" + totalIngresosRecaudados);
                    System.out.println("----------------------------------------");
                    
                    // Lógica para recorrer los 30 asientos e imprimir solo los vendidos (estado 2)
                    String[] filas = {"A", "B", "C", "D", "E"};
                    for (String f : filas) {
                        for (int n = 1; n <= 6; n++) {
                            int estado = obtenerEstado(f.charAt(0), n);
                            if (estado == 2) {
                                System.out.println("Asiento: " + f + n + " - $" + precioUnitario);
                                subTotalBoleta += precioUnitario;
                                asientosComprados++;
                            }
                        }
                    }

                    // PASO 3: Punto de depuración 4 - Verificación de cálculo de entradas
                    System.out.println("[PUNTO DE DEPURACIÓN 4 - Total de Entradas] Entradas vendidas contabilizadas: " + asientosComprados);

                    System.out.println("----------------------------------------");
                    System.out.println("Cantidad de Entradas: " + asientosComprados); // Información relevante
                    System.out.println("Costo Total Boleta: $" + subTotalBoleta); // Información relevante
                    
                    // PASO 3: Punto de depuración 5 - Se verifica presentación de la información
                    if (subTotalBoleta == totalIngresosRecaudados) {
                        System.out.println("[PUNTO DE DEPURACIÓN 5 - Consistencia] Los totales coinciden.");
                    } else {
                        System.out.println("[PUNTO DE DEPURACIÓN 5 - Consistencia] ¡Alerta! Los totales no coinciden.");
                    }

                    System.out.println("========================================");
                    System.out.println("");
                    break;
                
                case "4":
                    System.out.println("Saliendo del sistema de " + nombreTeatro + "...");
                    // Cancelar timer si está activo al salir
                    try{if(temporizadorReserva != null){ temporizadorReserva.cancel();}}catch(Exception e){}
                    teclado.close();
                    return;
                
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (true);
    }
    
    // LÓGICA DE MANEJO DE ESTADO
    // Retorna la representación en String del estado del asiento (PASO 1a)
    static String obtenerEstadoString(int estado, String codigo) {
        if (estado == 2) {
            return "[X]";
        } else if (estado == 1 || codigo.equals(reservaPendienteCodigo)) {
            return "[R]";
        } else {
            return "[ ]";
        }
    }

    // Con esto se obtiene el estado entero (0, 1, 2) de un asiento específico.
    static int obtenerEstado(char fila, int nro) {
        if (fila == 'A') {
            if (nro == 1) return asientoA1; else if (nro == 2) return asientoA2; else if (nro == 3) return asientoA3;
            else if (nro == 4) return asientoA4; else if (nro == 5) return asientoA5; else return asientoA6;
        } else if (fila == 'B') {
            if (nro == 1) return asientoB1; else if (nro == 2) return asientoB2; else if (nro == 3) return asientoB3;
            else if (nro == 4) return asientoB4; else if (nro == 5) return asientoB5; else return asientoB6;
        } else if (fila == 'C') {
            if (nro == 1) return asientoC1; else if (nro == 2) return asientoC2; else if (nro == 3) return asientoC3;
            else if (nro == 4) return asientoC4; else if (nro == 5) return asientoC5; else return asientoC6;
        } else if (fila == 'D') {
            if (nro == 1) return asientoD1; else if (nro == 2) return asientoD2; else if (nro == 3) return asientoD3;
            else if (nro == 4) return asientoD4; else if (nro == 5) return asientoD5; else return asientoD6;
        } else if (fila == 'E') {
            if (nro == 1) return asientoE1; else if (nro == 2) return asientoE2; else if (nro == 3) return asientoE3;
            else if (nro == 4) return asientoE4; else if (nro == 5) return asientoE5; else return asientoE6;
        }
        return -1; // Error o fuera de rango
    }

    // Se establece el estado entero (0, 1, 2) de un asiento específico.  
    static void establecerEstado(char fila, int nro, int nuevoEstado) {
        if (fila == 'A') {
            if (nro == 1) asientoA1 = nuevoEstado; else if (nro == 2) asientoA2 = nuevoEstado; else if (nro == 3) asientoA3 = nuevoEstado;
            else if (nro == 4) asientoA4 = nuevoEstado; else if (nro == 5) asientoA5 = nuevoEstado; else asientoA6 = nuevoEstado;
        } else if (fila == 'B') {
            if (nro == 1) asientoB1 = nuevoEstado; else if (nro == 2) asientoB2 = nuevoEstado; else if (nro == 3) asientoB3 = nuevoEstado;
            else if (nro == 4) asientoB4 = nuevoEstado; else if (nro == 5) asientoB5 = nuevoEstado; else asientoB6 = nuevoEstado;
        } else if (fila == 'C') {
            if (nro == 1) asientoC1 = nuevoEstado; else if (nro == 2) asientoC2 = nuevoEstado; else if (nro == 3) asientoC3 = nuevoEstado;
            else if (nro == 4) asientoC4 = nuevoEstado; else if (nro == 5) asientoC5 = nuevoEstado; else asientoC6 = nuevoEstado;
        } else if (fila == 'D') {
            if (nro == 1) asientoD1 = nuevoEstado; else if (nro == 2) asientoD2 = nuevoEstado; else if (nro == 3) asientoD3 = nuevoEstado;
            else if (nro == 4) asientoD4 = nuevoEstado; else if (nro == 5) asientoD5 = nuevoEstado; else asientoD6 = nuevoEstado;
        } else if (fila == 'E') {
            if (nro == 1) asientoE1 = nuevoEstado; else if (nro == 2) asientoE2 = nuevoEstado; else if (nro == 3) asientoE3 = nuevoEstado;
            else if (nro == 4) asientoE4 = nuevoEstado; else if (nro == 5) asientoE5 = nuevoEstado; else asientoE6 = nuevoEstado;
        }
    }
}