package ee.avastai.back_ai.ai.mapper;

import ee.avastai.back_ai.ai.dto.AiSiteDto;
import ee.avastai.back_ai.domain.site.AiSite;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AiSiteMapper {
    AiSite toEntity(AiSiteDto aiSiteDto);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "company",target = "company")
    @Mapping(source = "description",target = "description")
    @Mapping(source = "link",target = "link")
    @Mapping(source = "type.name",target = "typeName")
    @Mapping(source = "user.username",target = "userUsername")
    @Mapping(source = "createdAt",target = "createdAt")
    AiSiteDto toDto(AiSite aiSite);
    List<AiSiteDto> toDtos(List<AiSite> aiSites);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AiSite partialUpdate(AiSiteDto aiSiteDto, @MappingTarget AiSite aiSite);
}