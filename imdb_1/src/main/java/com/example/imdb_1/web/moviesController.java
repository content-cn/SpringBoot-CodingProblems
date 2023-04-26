package com.example.imdb_1.web;

import com.example.imdb_1.domain.Genre;
import com.example.imdb_1.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class moviesController {
    @Autowired
    MovieRepo movieRepo;
    @RequestMapping ("/movies")
        public ModelAndView getMovies(Genre genre){
       Map<String, List<String>> genreMap1 =movieRepo.getMoviesList(genre);
        List<String> stringList=genreMap1.get(genre.getGenre());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moviesList");
        modelAndView.addObject("movieslist", stringList);
        return modelAndView;
    }
}
