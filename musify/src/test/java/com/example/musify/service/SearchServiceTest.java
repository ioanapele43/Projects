package com.example.musify.service;

import com.example.musify.repo.AlbumRepositoryJPA;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.mappers.AlbumMapper;
import com.example.musify.service.mappers.ArtistMapper;
import com.example.musify.service.mappers.BandMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {
    @Mock
     ArtistRepositoryJPA artistRepositoryJPA;
    @Mock
    BandRepositoryJPA bandRepositoryJPA;
    @Mock
    AlbumRepositoryJPA albumRepositoryJPA;
    @Mock
    ArtistMapper artistMapper;
    @Mock
    BandMapper bandMapper;
    @Mock
    AlbumMapper albumMapper;
    @Mock
            ValidationsService validationsService;
    SearchService searchService;

    @BeforeEach
    public void init(){
        //searchService=new SearchService(artistRepositoryJPA,bandRepositoryJPA,albumRepositoryJPA, songRepositoryJPA, songMapper, artistMapper, bandMapper, albumMapper, validationsService);
    }
    /*@Test
    @DisplayName("Album-NULL")
    public void givenNotExistingAlbum_whenSearchAlbum_thenReturnNull(){
        when(searchService.searchByTitle(any())).thenReturn(null);
        assertEquals(searchService.searchByTitle("bt"),null);
    }
    @Test
    @DisplayName("Search for an existing band")
    public void givenExistingBand_whenSearchBand_thenReturnBand(){
        Band band=new Band();
        band.setBandname("aksa");
        List<Band> bandList=new ArrayList<Band>();
        bandList.add(band);
        when(searchService.searchByBandname(any())).thenReturn(bandList.stream().map(b->bandMapper.toViewDto(b)).collect(Collectors.toList()));
        assertEquals(searchService.searchByBandname("aksa"),bandList);

    }*/

}