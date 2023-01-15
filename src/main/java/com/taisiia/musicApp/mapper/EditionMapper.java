package com.taisiia.musicApp.mapper;

import com.taisiia.musicApp.domain.dao.Edition;
import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.domain.dto.EditionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {TrackMapper.class})
public interface EditionMapper {

    Edition toDao(EditionDto editionDto);


    @Mapping(source = "tracks", target = "totalDuration", qualifiedByName = "countDuration")
    EditionDto toDto(Edition edition);

    @Mapping(source = "tracks", target = "totalDuration", qualifiedByName = "countDuration")
    List<EditionDto> toListDto(List<Edition> editions);

    @Named("countDuration")
    static Double countTotalDuration(Set<Track> tracks) {
        return tracks.stream().map(track -> track.getDuration()).reduce(0.0, Double::sum);
    }

}
