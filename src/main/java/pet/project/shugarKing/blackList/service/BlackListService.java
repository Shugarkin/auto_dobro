package pet.project.shugarKing.blackList.service;

import pet.project.shugarKing.blackList.model.BlackList;

import java.util.List;

public interface BlackListService {
    BlackList createBlock(BlackList blackList);

    boolean check(long userId, long bookedId);

    String deleteBlock(long userId, long bookedId);

    List<BlackList> getList(long userId);
}
