package ua.sdo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sdo.model.InviteBuild;
import ua.sdo.repository.InviteBuildRepository;
import ua.sdo.service.InviteBuildService;

import java.util.List;

@Service
public class InviteBuildServiceImpl implements InviteBuildService {

    @Autowired
    private InviteBuildRepository inviteBuildRepository;

    @Override
    public void registerInvite(InviteBuild inviteBuild) {
        inviteBuildRepository.saveAndFlush(inviteBuild);
    }

    @Override
    public List<InviteBuild> findInviteByIdBuild(int id) {
        return inviteBuildRepository.findInviteByIdBuild(id);
    }
}
