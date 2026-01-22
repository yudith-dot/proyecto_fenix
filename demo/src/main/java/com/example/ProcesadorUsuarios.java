package com.example;
import java.util.ArrayList;
import java.util.List;
// Cambio para activar el servidor CI - 22/01/2026

/**
 * Esta clase procesa listas de usuarios.
 * Se encarga de clasificar a los usuarios en administradores o invitados.
 */
public class ProcesadorUsuarios {
    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;
    
 /**
     * Acumula el nombre del administrador en una cadena.
     * @param nombre Nombre del usuario administrador.
     */
    private void procesarAdmin(String nombre) {
        admins += nombre + ",";
    }
    /**
     * Acumula el nombre del invitado en una cadena.
     * @param nombre Nombre del usuario invitado.
     */
    private void procesarInvitado(String nombre) {
        invitados += nombre + ",";
    }

    /**
     * Procesa una lista de usuarios en formato "nombre:rol".
     *
     * @param usuarios lista de usuarios en formato String.
     * @return resumen de administradores e invitados.
     */
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    procesarAdmin(nombre);
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    procesarInvitado(nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }
}