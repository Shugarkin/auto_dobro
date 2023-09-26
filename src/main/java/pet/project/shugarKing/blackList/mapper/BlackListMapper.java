package pet.project.shugarKing.blackList.mapper;

import lombok.experimental.UtilityClass;
import pet.project.shugarKing.blackList.dto.BlackListDto;
import pet.project.shugarKing.blackList.model.BlackList;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class BlackListMapper {

    public BlackList toBlackList(BlackListDto blackListDto) {
        return BlackList.builder()
                .bookedId(blackListDto.getBookedId())
                .userId(blackListDto.getUserId())
                .build();
    }


    public static BlackListDto toBlackListDto(BlackList block) {
        return BlackListDto.builder()
                .bookedId(block.getBookedId())
                .userId(block.getUserId())
                .build();
    }

    public List<BlackListDto> toListBlackListDto(List<BlackList> list) {
        return list.stream().map(BlackListMapper::toBlackListDto).collect(Collectors.toList());
    }
}
