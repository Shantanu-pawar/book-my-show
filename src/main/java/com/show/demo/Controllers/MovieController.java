package com.show.demo.Controllers;

import com.show.demo.DTOs.RequestDto.MovieDto;
import com.show.demo.Models.Movie;
import com.show.demo.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDto movieDto) {
        Movie movieSaved = movieService.addMovie(movieDto);
        return new ResponseEntity<Movie>(movieSaved, HttpStatus.OK);
    }
}
