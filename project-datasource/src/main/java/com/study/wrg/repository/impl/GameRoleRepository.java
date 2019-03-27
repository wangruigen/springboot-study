package com.study.wrg.repository.impl;

import com.study.wrg.entity.GameRole;
import com.study.wrg.repository.GameRoleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameRoleRepository implements GameRoleRepositoryService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameRoleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static GameRole mapRow(ResultSet rs, int rowNum) throws SQLException {
        GameRole gameRole = new GameRole();
        gameRole.setId(rs.getInt("id"));
        gameRole.setName(rs.getString("name"));
        gameRole.setProf(rs.getString("prof"));
        return gameRole;
    }

    @Override
    public List<GameRole> getGameRoleList() {
        List<GameRole> query = jdbcTemplate.query("select * from game_role", GameRoleRepository::mapRow);
        return query;
    }

    @Override
    public GameRole getGameRole(Integer id) {
        return jdbcTemplate.queryForObject("select t.id,t.name,t.prof from game_role t where t.id=?",
                new Integer[]{id},
                new BeanPropertyRowMapper<>(GameRole.class));
    }

    @Override
    public boolean addGameRole(GameRole gameRole) {
        int update = jdbcTemplate.update("insert into game_role(ID, NAME,PROF) values (?,?,?)",
                gameRole.getId(), gameRole.getName(), gameRole.getProf());
        return update>0;
    }

    @Override
    public boolean updateGameRole(GameRole gameRole) {
        int update = jdbcTemplate.update("update game_role t set t.NAME=?,t.PROF=? where t.ID=?",
                gameRole.getId(), gameRole.getName(), gameRole.getProf());
        return update>0;
    }

    @Override
    public boolean deleteGameRole(Integer id) {
        int update = jdbcTemplate.update("delete from game_role t where t.id=?", ps -> ps.setInt(1, id));
        return update>0;
    }
}
