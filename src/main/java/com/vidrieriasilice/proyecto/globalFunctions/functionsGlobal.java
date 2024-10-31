package com.vidrieriasilice.proyecto.globalFunctions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class functionsGlobal {

    public static LocalDateTime convertirALocal(LocalDateTime fechaUTC) {
        // 1. Convertir LocalDateTime a ZonedDateTime en UTC
        ZonedDateTime fechaUTCZone = fechaUTC.atZone(ZoneId.of("UTC"));

        // 2. Convertir a ZonedDateTime en la zona horaria local de Lima
        ZonedDateTime fechaLocalZone = fechaUTCZone.withZoneSameInstant(ZoneId.of("America/Lima"));

        // 3. Retornar LocalDateTime en horario local
        return fechaLocalZone.toLocalDateTime();
    }

}
