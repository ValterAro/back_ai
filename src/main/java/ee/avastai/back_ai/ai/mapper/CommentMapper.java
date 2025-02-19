package ee.avastai.back_ai.ai.mapper;

import ee.avastai.back_ai.ai.dto.CommentDto;
import ee.avastai.back_ai.ai.dto.NewCommentDto;
import ee.avastai.back_ai.domain.comment.Comment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    Comment toEntity(CommentDto commentDto);

    CommentDto toDto(Comment comment);

    Comment newCommentDtoToComment(NewCommentDto newCommentDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Comment partialUpdate(CommentDto commentDto, @MappingTarget Comment comment);
}