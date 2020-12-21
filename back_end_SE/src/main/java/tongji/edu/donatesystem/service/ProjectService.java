package tongji.edu.donatesystem.service;

import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.print.DocFlavor;
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
    void deleteProject(int id);
    Project findOneProject(int id);
    List<Project> findLike(String pname); //根据输入内容进行模糊查询
    void updateProject(Project project);
    void recall(int id); //筹款人申请撤回项目，并拿回款项
    void donateProject(int id,String amount); //捐款
}
