package com.Mini_Project1.Vaathiyaru.Controller;

import com.Mini_Project1.Vaathiyaru.EmailService;
import com.Mini_Project1.Vaathiyaru.Model.Email;
import com.Mini_Project1.Vaathiyaru.Model.Tutor;
import com.Mini_Project1.Vaathiyaru.Repository.EmailRepo;
import com.Mini_Project1.Vaathiyaru.Repository.TutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "Services")
public class Post_Service {

    @Autowired
    TutorRepo tutorRepo;

    @Autowired
    EmailRepo emailRepo;
    @Autowired
    EmailService emailService;


    public Post_Service(TutorRepo tutorRepo, EmailService emailService,EmailRepo emailRepo) {
        this.tutorRepo = tutorRepo;
        this.emailRepo=emailRepo;
    }

    @GetMapping("/showByLocation")
    public List<Tutor> showServicesByLocation(@RequestParam String loc){
       List<Tutor> ans=tutorRepo.findByLocation(loc);
        return ans;
    }

    @GetMapping ("/showByExp")
    public List<Tutor> showServicesByExp(@RequestParam int years){
        List<Tutor> ans=tutorRepo.findByExp(years);
        return ans;
    }

    @GetMapping ("/showByRole")
    public List<Tutor> showServicesByHeading(@RequestParam String role){
        List<Tutor> ans=tutorRepo.findByHeading(role);
        return ans;
    }
    @GetMapping ("/showAvailable")
    public List<Tutor> showAllServices(){
        List<Tutor> ans=tutorRepo.findAll();
        return ans;
    }


    @PostMapping("/AddNew")
    public void saveService(@RequestBody Tutor tutor){
        tutorRepo.save(tutor);
        List<Email> list=emailRepo.findAll();
        for(Email email:list){
            emailService.sendEmail(email.getEmail(),"This is it test mail",tutor.toString());
        }




    }
    @GetMapping("/Delete")
    public void delService(){
        Tutor x=new Tutor(120,"Full stack web dev harish","Self Learnt","Online",3);
        tutorRepo.delete(x);
    }
    @GetMapping("/sendMail")
    public void sendMail(){
        emailService.sendEmail("monishaselvarai24@gmail.com","Your PHONE IS HACKED",showAllServices().toString());
    }



}
