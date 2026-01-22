package com.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */
public class ProcesadorUsuarios {
    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;

    // Método con 'code smells': largo, números mágicos, malos nombres.
    public String procesarLista(List<String> dataList) {
        String admins = "";
        String invitados = "";

        for (String u : dataList) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String n = parts[0];
                int r = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (r == ROL_ADMIN) {
                    admins += n + ",";
                }
                // Número Mágico: 2 es Invitado
                else if (r == ROL_INVITADO) {
                    invitados += n + ",";
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }
}