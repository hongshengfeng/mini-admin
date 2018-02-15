package cn.scene.service;

import cn.scene.model.Scene;

/**
 * 场景管理
 */
public interface SceneMService {

    //上架
    Boolean shelve(Integer sceneId);

    //设置
    Scene setting(Integer sceneId);

    //完成设置
    int issue(Scene scene);
}
