package ua.sdo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.sdo.model.Build;
import ua.sdo.model.InviteBuild;
import ua.sdo.model.User;
import ua.sdo.service.BuildService;
import ua.sdo.service.InviteBuildService;
import ua.sdo.service.UserService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private BuildService buildService;
    @Autowired
    private InviteBuildService inviteBuildService;

    @ModelAttribute("invitebuild")
    public InviteBuild loadEmptyInviteBuild(){
        return new InviteBuild();
    }
    private User currentUser;

    @ModelAttribute("build")
    public Build loadEmptyBuild(){
        return new Build();
    }

    @RequestMapping(value = "/new")
    public String create(Model model)
    {
        return "create";
    }

    @RequestMapping(value = "/index")
    public String index(Model model){
        currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Build> listBuild = buildService.getAllBuilds();
        model.addAttribute("builds", listBuild);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model){
        return "main";
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model){
        return "/register";
    }

    @ModelAttribute("user")
    public User loadEmptyUser(){
        return new User();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result)
    {
        userService.createUser(user);
        return "/index";
    }

    @RequestMapping(value = "/addBuild", method = RequestMethod.POST)
    public String addContact(@Valid Build build, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "create";
        }
        build.setOwner(userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()));
        buildService.createBuild(build);
        return "redirect:/index";
    }

    @RequestMapping(value = "/info/{id}")
    public ModelAndView infoPage(@PathVariable("id") Integer id){
        Build build = buildService.findById(id);
        InviteBuild inviteBuild = new InviteBuild();
        inviteBuild.setUser(currentUser);
        inviteBuild.setDateInvite(LocalDate.now());
        inviteBuild.setTimeInvite(LocalTime.now());
        inviteBuild.setBuild(build);
        inviteBuildService.registerInvite(inviteBuild);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("build", build);
        modelAndView.setViewName("info");
        return modelAndView;
    }

    @RequestMapping(value = "/my")
    public String myBuilders(Model model){
        List<Build> builds = buildService.findByIdUser(userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
        model.addAttribute("mybuilds", builds);
        return "mybuilds";
    }

    @RequestMapping(value = "/my/{id}")
    public String infoPersonalBuild(@PathVariable("id") Integer id, Model model){
        Build build = buildService.findById(id);
        List<InviteBuild> invite = inviteBuildService.findInviteByIdBuild(id);
        model.addAttribute("build", build);
        model.addAttribute("invites", invite);
        return "viewbuild";
    }
}
