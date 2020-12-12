package tongji.edu.donatesystem.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
@TableName(value = "account")
public class Account implements Serializable {

    private static final long serialVersionUID=1L;

    private String userId;

    private String username;

    private String password;

    private String type;



}
