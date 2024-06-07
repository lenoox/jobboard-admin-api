package com.lenoox.jobboard.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class AnalysisContainerDto<T> {
   private Long max;
   private T data;
}
