package tongji.edu.donatesystem.controller;


import lombok.extern.slf4j.Slf4j;
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
import tongji.edu.donatesystem.entity.Info;
import tongji.edu.donatesystem.service.AccountService;
import tongji.edu.donatesystem.service.InfoService;

import java.io.File;
import java.io.IOException;
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
@RequestMapping("/info")
@CrossOrigin
@Slf4j
public class InfoController {
    @Autowired
    private InfoService infoService;
    @Value("F:\\IdeaProjects\\back_end_SE\\src\\main\\resources\\static\\photos")
    private String realPath; //头像保存地址
    @PostMapping("save")
    public Map<String,Object> save(Info info, MultipartFile photo) throws IOException {
        log.info("用户信息：[{}]",info.toString());
        log.info("头像信息：[{}]",photo);
        //ctrl+alt+T 快捷try catch
        try {
            String newFileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath,newFileName));
            // 保存用户信息
            info.setUserpath(newFileName);
            infoService.saveInfo(info);
//            map.put("state",true);
//            map.put("msg","员工信息保存成功！");
            return Result.succ("添加个人信息成功");
        } catch (Exception e) {
            e.printStackTrace();
//            map.put("state",false);
//            map.put("msg","员工信息保存失败！");
            return Result.fail("添加个人信息失败!");
        }
        // 设置头像地址

    }

    // 修改用户信息
    @PostMapping("update")
    public Map<String,Object> update(Info info, MultipartFile photo) throws IOException {
        log.info("用户信息：[{}]",info.toString());
        //ctrl+alt+T 快捷try catch
        try {
            if(photo!=null&&photo.getSize()!=0){
                log.info("头像信息：[{}]",photo);
                String newFileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath,newFileName));
                info.setUserpath(newFileName);
            } // 如果更改头像
            // 保存员工信息
            infoService.updateInfo(info);
            return Result.succ("用户信息修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("用户信息修改失败！");
        }
        // 设置头像地址

    }

}

