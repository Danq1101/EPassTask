package com.example.task.web.mapper;

import com.example.task.domain.Parties;
import com.example.task.web.dto.PartiesDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T00:29:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PartiesMapperImpl implements PartiesMapper {

    @Override
    public PartiesDto toDto(Parties parties) {
        if ( parties == null ) {
            return null;
        }

        PartiesDto partiesDto = new PartiesDto();

        try {
            if ( parties.getFromDate() != null ) {
                partiesDto.setFromDate( new SimpleDateFormat().parse( parties.getFromDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( parties.getToDate() != null ) {
                partiesDto.setToDate( new SimpleDateFormat().parse( parties.getToDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        partiesDto.setRecordCount( parties.getRecordCount() );
        partiesDto.setStartCount( parties.getStartCount() );

        return partiesDto;
    }

    @Override
    public Parties toEntity(PartiesDto dto) {
        if ( dto == null ) {
            return null;
        }

        Parties parties = new Parties();

        if ( dto.getFromDate() != null ) {
            parties.setFromDate( new SimpleDateFormat().format( dto.getFromDate() ) );
        }
        if ( dto.getToDate() != null ) {
            parties.setToDate( new SimpleDateFormat().format( dto.getToDate() ) );
        }
        parties.setStartCount( dto.getStartCount() );
        parties.setRecordCount( dto.getRecordCount() );

        return parties;
    }
}
