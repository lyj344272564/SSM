package com.richard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionAdVO {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
}
