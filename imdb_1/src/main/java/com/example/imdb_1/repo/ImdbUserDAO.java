package com.example.imdb_1.repo;

import com.example.imdb_1.domain.ImdbUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
@Scope("singleton")
public class ImdbUserDAO implements DAO<ImdbUser>{
    private List<ImdbUser> ImdbUserList = new ArrayList<>();
    @Override
    public Optional get(Integer id) {
        if(!ImdbUserList.isEmpty())
            return Optional.of(ImdbUserList.get(id));
        return Optional.empty();
    }
    @Override
    public int save(ImdbUser imdbUser) {
        int imdbUserId=ImdbUserList.size();
        imdbUser.setUserId(imdbUserId);
        ImdbUserList.add(imdbUser);
        System.out.println("saved details");
        return imdbUserId;

    }

}
