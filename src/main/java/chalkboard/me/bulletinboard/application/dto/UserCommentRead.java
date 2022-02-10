package chalkboard.me.bulletinboard.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentRead {
    private final int id;
    private final String name;
    private final String email;
    private final String comment;
    private final LocalDateTime createdAt;
}
