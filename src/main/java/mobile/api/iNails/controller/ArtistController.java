package mobile.api.iNails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobile.api.iNails.dao.ArtistDao;
import mobile.api.iNails.domain.Artist;

@RestController
@RequestMapping("/rest/api/")
public class ArtistController {
	@Autowired
	private ArtistDao artistDao;
	
	@RequestMapping(value="artists", method = RequestMethod.GET)
	public ResponseEntity<List<Artist>> findAllArtists(){
		List<Artist> artists = artistDao.findAllArtists();
		return (artists.isEmpty())? new ResponseEntity<List<Artist>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
	}

}
