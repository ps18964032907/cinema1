package com.pmsj.cinema.business.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pmsj.cinema.common.entity.Movie;
import com.pmsj.cinema.common.entity.MovieTpye;
import com.pmsj.cinema.common.mapper.MovieMapper;
import com.pmsj.cinema.common.mapper.MovieTpyeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author sjh
 * @creat 2020/7/4 11:11
 */
@Service
public class MovieAllService {
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    MovieTpyeMapper movieTpyeMapper;

    public PageInfo<Movie> selectAllMovie(Integer offset, Integer limit, Integer movieStatus, Integer typeId, String movieArea, String movieReleaseTime, Integer paixu) {
        int PageNum = 1;
        if (offset != 0) {
            PageNum = (offset / limit) + 1;
        }
        if (offset != -1 && limit != -1) {
            PageHelper.startPage(PageNum, limit);
        }
        List<Movie> selectAllMovie = movieMapper.selectAllMovie(movieStatus, typeId, movieArea, movieReleaseTime, paixu);
        PageInfo<Movie> AllMovie = new PageInfo<>(selectAllMovie);
        return AllMovie;
    }


    public List<MovieTpye> selectAllMovieType() {
        return movieTpyeMapper.selectAll();
    }

    public List<MovieTpye> selectNoMovieType(Integer movieId) {
        return movieTpyeMapper.selectNoMovieType(movieId);
    }

    public List<MovieTpye> selectCheckedTpyes(Integer movieId) {
        return movieTpyeMapper.selectCheckedTpyes(movieId);
    }

    public List<Movie> getMovieByKeyWord(String keyWord) {
        return movieMapper.getMovieByKeyWord(keyWord);

    }
}
