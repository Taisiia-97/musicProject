package com.taisiia.musicApp.mapper;

import com.taisiia.musicApp.domain.dao.Edition;
import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.domain.dto.EditionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {TrackMapper.class})
public interface EditionMapper {

    Edition toDao(EditionDto editionDto);

    @Mapping(source = "tracks", target = "totalDuration", qualifiedByName = "countTotalDuration")
    EditionDto toDto(Edition edition);

    @Mapping(source = "tracks", target = "totalDuration", qualifiedByName = "countTotalDuration")
    List<EditionDto> toListDto(List<Edition> editions);

    @Named("countTotalDuration")
    static LocalTime countTotalDuration(Set<Track> tracks) {
        return tracks.stream().map(Track::getDuration)
                .reduce(LocalTime.of(00,00,00), (currentSum, element) ->
                        currentSum.plusHours(element.getHour()).plusMinutes(element.getMinute()).plusSeconds(element.getSecond())
                    );


    }

}
