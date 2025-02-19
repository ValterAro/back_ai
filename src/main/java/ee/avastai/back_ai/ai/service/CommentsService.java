package ee.avastai.back_ai.ai.service;

import ee.avastai.back_ai.ai.dto.CommentDto;
import ee.avastai.back_ai.ai.dto.NewCommentDto;
import ee.avastai.back_ai.ai.mapper.CommentMapper;
import ee.avastai.back_ai.ai.repository.AiSiteRepository;
import ee.avastai.back_ai.ai.repository.UserRepository;
import ee.avastai.back_ai.domain.comment.Comment;
import ee.avastai.back_ai.domain.comment.CommentService;
import ee.avastai.back_ai.domain.site.AiSite;
import ee.avastai.back_ai.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CommentsService {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private AiSiteRepository aiSiteRepository;

    @Autowired
    private UserRepository userRepository;

    public CommentDto addComment(NewCommentDto newCommentDto) {

        Comment comment = commentMapper.newCommentDtoToComment(newCommentDto);
        comment.setCreatedAt(Instant.now());

        User user = userRepository.findById(newCommentDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + newCommentDto.getUserId()));
        comment.setUser(user);

        AiSite aiSite = aiSiteRepository.findById(newCommentDto.getAiSiteId())
                .orElseThrow(() -> new RuntimeException("AiSite not found with id: " + newCommentDto.getAiSiteId()));
        comment.setAiSite(aiSite);

        Comment savedComment = commentService.save(comment);
        return commentMapper.toDto(savedComment);
    }
}
