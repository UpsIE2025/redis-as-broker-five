package com.five.group.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String detail;

    private List<ErrorDetail> errors;

    private Integer status;
}
