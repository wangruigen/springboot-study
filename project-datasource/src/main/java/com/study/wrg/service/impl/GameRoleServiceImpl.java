package com.study.wrg.service.impl;

import com.study.wrg.entity.GameRole;
import com.study.wrg.repository.GameRoleRepositoryService;
import com.study.wrg.service.GameRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional //开启事务
public class GameRoleServiceImpl implements GameRoleService {
    private final GameRoleRepositoryService gameRoleRepository;

    @Autowired
    public GameRoleServiceImpl(GameRoleRepositoryService gameRoleRepository) {
        this.gameRoleRepository = gameRoleRepository;
    }

    @Override
    public List<GameRole> getGameRoleList() throws Exception {
        return gameRoleRepository.getGameRoleList();
    }

    @Override
    public GameRole getGameRole(Integer id) throws Exception {
        return gameRoleRepository.getGameRole(id);
    }

    @Override
    public boolean addGameRole(GameRole gameRole) throws Exception {
        return gameRoleRepository.addGameRole(gameRole);
    }

    @Override
    public boolean updateGameRole(GameRole gameRole) throws Exception {
        return gameRoleRepository.updateGameRole(gameRole);
    }

    @Override
    public boolean deleteGameRole(Integer id) throws Exception {
        return gameRoleRepository.deleteGameRole(id);
    }
}
