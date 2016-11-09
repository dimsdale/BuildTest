package ua.sdo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sdo.model.Build;
import ua.sdo.repository.BuildRepository;
import ua.sdo.service.BuildService;

import java.util.List;

@Service
public class BuildServiceImpl implements BuildService {

    @Autowired
    private BuildRepository buildRepository;

    @Override
    public void createBuild(Build build) {
        buildRepository.saveAndFlush(build);
    }

    @Override
    public List<Build> findByIdUser(int id) {
        return buildRepository.findByIdUser(id);
    }

    @Override
    public List<Build> getAllBuilds() {
        return  buildRepository.findAll();
    }

    @Override
    public Build findById(int id) {
        return buildRepository.findById(id);
    }


}
