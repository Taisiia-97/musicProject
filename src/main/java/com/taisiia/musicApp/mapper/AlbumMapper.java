package com.taisiia.musicApp.mapper;

import com.taisiia.musicApp.domain.dao.Album;
import com.taisiia.musicApp.domain.dto.AlbumDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TrackMapper.class, EditionMapper.class})
public interface AlbumMapper {

    AlbumDto toDto(Album album);

    Album toDao(AlbumDto albumDto);


    List<AlbumDto> toListDto(List<Album> albums);
}
