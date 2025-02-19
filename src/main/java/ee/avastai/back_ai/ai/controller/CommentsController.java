package ee.avastai.back_ai.ai.controller;


import ee.avastai.back_ai.ai.dto.CommentDto;
import ee.avastai.back_ai.ai.dto.NewCommentDto;
import ee.avastai.back_ai.ai.service.CommentsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Resource
    private CommentsService commentsService;

    @PostMapping
    @Operation(summary = "Add a new comment", description = "Post a comment for the specific Ai tool")
    public CommentDto addCommentToSite(@RequestBody NewCommentDto newCommentDto) {
        return commentsService.addComment(newCommentDto);
    }

}
