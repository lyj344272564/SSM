package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVO {

    private Integer currentPage;
    private Integer pageSize;
    private String name;
    private Integer categoryId;
    private String url;

}
