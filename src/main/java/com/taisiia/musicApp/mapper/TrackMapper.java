package com.taisiia.musicApp.mapper;


import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.domain.dto.TrackDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrackMapper {

    Track toDao(TrackDto trackDto);

    TrackDto toDto(Track track);

    List<TrackDto> toListDto(List<Track> tracks);
}
