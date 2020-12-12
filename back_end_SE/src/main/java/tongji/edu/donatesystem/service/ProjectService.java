package tongji.edu.donatesystem.service;

import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
public interface ProjectService extends IService<Project> {
    List<Project> findAll();
    void saveProject(Project project); //发起募捐
    void deleteProject(String id);
    Project findOneProject(String id);
    List<Project> findLike(String pname); //根据输入内容进行模糊查询
    void updateProject(Project project);
}
