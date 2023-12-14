package com.ll.medium_mission.post.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record PostResponse(
        String content,
        String title,
        String author,
        LocalDateTime createDate,
        LocalDateTime modifiedDate){
}
