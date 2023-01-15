package com.taisiia.musicApp.mapper;


import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.domain.dto.TrackDto;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TrackMapper {

    Track toDao(TrackDto trackDto);

    TrackDto toDto(Track track);

    Set<TrackDto> toSetDto(Set<Track> tracks);


    List<TrackDto> toListDto(List<Track> tracks);




}
