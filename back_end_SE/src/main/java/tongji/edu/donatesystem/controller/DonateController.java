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
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Info;
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
@RequestMapping("/donate")
@CrossOrigin
@Slf4j
public class DonateController {


}

