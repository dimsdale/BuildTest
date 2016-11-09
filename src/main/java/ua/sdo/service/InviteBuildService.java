package ua.sdo.service;


import ua.sdo.model.InviteBuild;

import java.util.List;

public interface InviteBuildService {

    void registerInvite(InviteBuild inviteBuild);

    List<InviteBuild> findInviteByIdBuild(int id);
}
