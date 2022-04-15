package com.anocha.learn.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class DateMapper {

    public OffsetDateTime asOffsetDate(Timestamp ts) {
        return Optional.ofNullable(ts).map(tmst -> {
            LocalDateTime lcDt = tmst.toLocalDateTime();
            return OffsetDateTime.of(lcDt.getYear(), lcDt.getMonthValue(), lcDt.getDayOfMonth(), lcDt.getHour(), lcDt.getMinute(), lcDt.getSecond(), lcDt.getNano(), ZoneOffset.UTC);
        }).orElse(null);
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
        return Optional.ofNullable(offsetDateTime).map(ofsDt ->
                Timestamp.valueOf(ofsDt.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime())
        ).orElse(null);
    }

}
