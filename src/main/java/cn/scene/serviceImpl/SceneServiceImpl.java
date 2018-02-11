package cn.scene.serviceImpl;

import cn.scene.dao.SceneMapper;
import cn.scene.model.Scene;
import cn.scene.service.SceneService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 场景实现类
 */
@Service("secneService")
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneMapper sceneMapper;

    /**
     * 精选模板
     * @param index
     * index==1,换一批显示,根据精选场景的被使用热度进行筛选
     */
    @Override
    public List<Scene> sceneInfo(Integer index) {
        int page = 1; //默认是第一页
        if(index==1){
            int count = sceneMapper.selectCount(); //查询总数
            Double number = Math.random();
            if (number >= 0.5) {
                page = (int) (Math.random() + 2) * (count - 6);
            } else {
                page = (int) (Math.random() + 1) * (count - 6);
            }
        }
        PageHelper.startPage(page,6);
        return sceneMapper.selectDelicate();
    }

    //最新推荐
    @Override
    public List<Scene> selectNews() {
        return sceneMapper.selectNews();
    }

    /**
     * 最新热门模板
     * @param index
     * index==1,换一批显示,根据上架场景的热度进行筛选
     */
    @Override
    public List<Scene> hotInfo(Integer index) {
        int page = 0;
        if(index==1){
            int count = sceneMapper.selectCount(); //查询总数
            Double number = Math.random();
            if (number >= 0.5) {
                page = (int) (Math.random() + 1) * (count - 6);
            } else {
                page = (int) (Math.random()) * (count - 6);
            }
        }
        PageHelper.startPage(page,9);
        return sceneMapper.selectByHot();
    }

    @Override
    public List<Scene> hotPage(Integer page) {
        PageHelper.startPage(page,9);
        List<Scene> list = sceneMapper.selectByTimes();
        return list;
    }

    @Override
    public List<Scene> hotSell(Integer page) {
        PageHelper.startPage(page,12);
        List<Scene> list = sceneMapper.selectByHitCount();
        return list;
    }


}