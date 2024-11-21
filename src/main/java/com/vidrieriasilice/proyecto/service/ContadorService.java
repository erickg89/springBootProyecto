package com.vidrieriasilice.proyecto.service;


import com.vidrieriasilice.proyecto.model.Contador;
import com.vidrieriasilice.proyecto.repository.ContadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContadorService {

    @Autowired
    private ContadorRepository contadorRepository;

    public String generarCodigo(String conTabla) {
        Contador contador = contadorRepository.findByConTabla(conTabla);

        if (contador != null) {
            int numero = Integer.parseInt(contador.getConItem());
            int longitudTotal = Integer.parseInt(contador.getConLongitud());
            int longitudParteFija = Math.min(3, conTabla.length());

            // Calcular la longitud restante para el número
            int longitudNumero = longitudTotal - longitudParteFija;
            if (longitudNumero <= 0) {
                throw new IllegalArgumentException("La longitud total es menor que la parte fija.");
            }

            // Formatear el número con ceros a la izquierda
            String formato = "%0" + longitudNumero + "d";
            String codigoFormateado = conTabla.substring(0, longitudParteFija)
                    + String.format(formato, numero);

            return codigoFormateado;
        }

        throw new IllegalArgumentException("No se encontró un contador para la tabla: " + conTabla);
    }
}
