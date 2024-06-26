package com.show.demo.Services;

import com.show.demo.DTOs.RequestDto.MovieDto;
import com.show.demo.Enums.Genre;
import com.show.demo.Exceptions.EmptyInputException;
import com.show.demo.Models.Movie;
import com.show.demo.Repositories.MovieRepository;
import com.show.demo.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(MovieDto movieDto) {

        if(movieDto.getName().isEmpty()){
            throw new EmptyInputException( "500", "Empty movie is not allowed");
        }

        Movie movie = MovieTransformer.movieDtoToEntity(movieDto);
        movieRepository.save(movie);
        return movie;
    }
}
