package ua.sdo.service;


import ua.sdo.model.InviteBuild;
import ua.sdo.model.User;

import java.util.List;

public interface InviteBuildService {

    void registerInvite(InviteBuild inviteBuild);

    List<User> findInviteUsersByIdBuild(int id);
}
