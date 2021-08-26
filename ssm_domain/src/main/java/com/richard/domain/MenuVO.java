package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {

    private Integer currentPage = 1;

    private Integer pageSize = 10;

    private Integer id;

}
