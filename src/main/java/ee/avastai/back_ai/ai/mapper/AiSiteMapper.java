package ee.avastai.back_ai.ai.mapper;

import ee.avastai.back_ai.ai.dto.AiSiteDto;
import ee.avastai.back_ai.ai.dto.NewAiSiteDto;
import ee.avastai.back_ai.domain.Status;
import ee.avastai.back_ai.domain.site.AiSite;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AiSiteMapper {

    @Mapping(source = "type.name", target = "typeName")
    @Mapping(source = "user.username", target = "userUsername")
    AiSiteDto toDto(AiSite aiSite);

    List<AiSiteDto> toDtos(List<AiSite> aiSites);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "typeId", target = "type.id")
    @Mapping(constant = Status.ACTIVE, target = "status")
    AiSite toEntity(NewAiSiteDto newAiSiteDto);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AiSite partialUpdate(NewAiSiteDto newAiSiteDto, @MappingTarget AiSite aiSite);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AiSite partialUpdate(AiSiteDto aiSiteDto, @MappingTarget AiSite aiSite);
}