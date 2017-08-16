package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import mobile.api.iNails.domain.Artist;

@Service
public interface ArtistDao {
   public List<Artist> findAllArtists();
   public Artist findArtist(int artistID);
   public int createArtist(Artist artist);
   public int updateArtist(Artist artist);
   public int deleteArtist(int artistID);
}
