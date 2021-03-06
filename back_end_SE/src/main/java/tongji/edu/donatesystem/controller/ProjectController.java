package tongji.edu.donatesystem.controller;


import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tongji.edu.common.lang.Result;
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Project;
import tongji.edu.donatesystem.service.AccountService;
import tongji.edu.donatesystem.service.InfoService;
import tongji.edu.donatesystem.service.ProjectService;
import tongji.edu.donatesystem.service.ReportService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ReportService reportService;
    @Value("F:\\IdeaProjects\\back_end_SE\\src\\main\\resources\\static\\photos")
    private String realPath; //头像保存地址
    @PostMapping("save")
    public Map<String,Object> save(Project project, MultipartFile photo){
        try {
            String newFileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath,newFileName));
            // 保存用户信息
            project.setPPath(newFileName);
            projectService.save(project);
            reportService.addStartCommit(project.getPId(),project.getPUser());
            //发布提交审核
            return Result.succ("发布募捐项目成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    @PostMapping("findLike") // 模糊查询
    public List<Project> findLike(String pname){
        return projectService.findLike(pname);
    }
    @PostMapping("delete")
    public Map<String , Object> delete(int id){
        try {
            projectService.deleteProject(id);
            return Result.succ("撤回项目成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("撤回项目失败,"+e.getMessage());
        }
    }
    @PostMapping("recall")
    public Map<String , Object> recall(int id){
        try {
            projectService.recall(id);
            return Result.succ("提交结束项目审核成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("提交结束项目审核失败,"+e.getMessage());
        }
    }
    @PostMapping("findAll")
    public Map<String , Object> findAll(){
        return Result.succ("查询项目列表成功！",projectService.findAll());
    }
    @PostMapping("findHelp")
    public Map<String , Object> findHelp(String id){
        return Result.succ("查询项目辅助证明成功！",reportService.findHelp(id));
    }

}

