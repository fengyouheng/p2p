package cn.wolfcode.wechat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by cgs on 2018/2/3.
 */
@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class Client {
    private Long id;
    private String nickname;
    private String openId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date concernTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date cancelConcernTime;
    private int status;
}
