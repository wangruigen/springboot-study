package com.study.wrg.repository;

import com.study.wrg.entity.GameRole;

import java.util.List;

public interface GameRoleRepositoryService {
    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    List<GameRole> getGameRoleList() throws Exception;

    /**
     * 根据id查询角色
     * @param id
     * @return
     * @throws Exception
     */
    GameRole getGameRole(Integer id) throws Exception;

    /**
     * 增加角色
     * @param gameRole
     * @return
     * @throws Exception
     */
    boolean addGameRole(GameRole gameRole) throws Exception;

    /**
     * 更新角色
     * @param gameRole
     * @return
     * @throws Exception
     */
    boolean updateGameRole(GameRole gameRole) throws Exception;

    /**
     * 根据id删除角色
     * @param
     * @return
     * @throws Exception
     */
    boolean deleteGameRole(Integer id) throws Exception;
}
