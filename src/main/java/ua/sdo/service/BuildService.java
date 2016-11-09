package ua.sdo.service;

import ua.sdo.model.Build;

import java.util.List;

public interface BuildService {

    void createBuild(Build build);

    List<Build> findByIdUser(int id);

    List<Build> getAllBuilds();

    Build findById(int id);
}
