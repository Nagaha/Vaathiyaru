package com.Mini_Project1.Vaathiyaru.Controller;

import com.Mini_Project1.Vaathiyaru.EmailService;
import com.Mini_Project1.Vaathiyaru.Model.Email;
import com.Mini_Project1.Vaathiyaru.Model.Tutor;
import com.Mini_Project1.Vaathiyaru.Model.Tutor_Email;
import com.Mini_Project1.Vaathiyaru.Repository.EmailRepo;
import com.Mini_Project1.Vaathiyaru.Repository.SearchRepo;
import com.Mini_Project1.Vaathiyaru.Repository.TutorEmailRepo;
import com.Mini_Project1.Vaathiyaru.Repository.TutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@RestController
@RequestMapping(path = "Services")
public class Post_Service {

    @Autowired
    TutorRepo tutorRepo;
    @Autowired
    TutorEmailRepo tutorEmailRepo;
//    @Autowired
//    SearchRepo searchRepo;



    @Autowired
    EmailRepo emailRepo;
    @Autowired
    EmailService emailService;


    public Post_Service(TutorRepo tutorRepo,EmailRepo emailRepo,TutorEmailRepo tutorEmailRepo) {
        this.tutorRepo = tutorRepo;
        this.emailRepo=emailRepo;
//        this.searchRepo=searchRepo;
        this.tutorEmailRepo=tutorEmailRepo;
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
        Tutor x=new Tutor(120,"Full stack web dev harish","Self Learnt","Online",3,0.0);
        tutorRepo.delete(x);
    }
    @GetMapping("/sendMail")
    public void sendMail(){
        emailService.sendEmail("monishaselvaraj24@gmail.com","Your PHONE IS HACKED",showAllServices().toString());
    }
    @PostMapping("/EnableNotification")
    public void enableNotification(@RequestBody Email email){
        emailRepo.save(email);
        emailService.sendEmail(email.getEmail(),"Your Account is added Successfully","Hi there , \n Happy to connect" +
                "with you! The notifications will be sent whenever a new service is available :)");
    }

    @GetMapping("/requestDemo")
    public String requestDemo(@RequestParam int id,@RequestParam String senderEmail){
        List<Tutor_Email> tutorEmailList=tutorEmailRepo.findAll();
        for(Tutor_Email x:tutorEmailList){
            if(x.getId()==id){
                emailService.sendEmail(x.getEmail(),"Requesting for demo session",
                        "Kudos from Vaathiyaru \n \t A person wants to connect with you for a demo session" +
                                "\n \t Here is the email id:"+senderEmail);
                break;
            }
        }
        return "Request sent Successful";
    }

    @PutMapping("/giveRatings")
    public String giveRatings(@RequestParam int id,@RequestParam double ratings){
        List<Tutor> tutorEmailList=tutorRepo.findAll();
        for(Tutor x:tutorEmailList){
            if(x.getId()==id){
             double currRating=x.getRatings();
             double avg=currRating+ratings;
             avg=avg/2;
             BigDecimal bd = new BigDecimal(avg).setScale(1, RoundingMode.HALF_UP);
             double newAvg = bd.doubleValue();
             x.setRatings(newAvg);
            tutorRepo.save(x);
                System.out.println(newAvg);
                break;
            }

        }

        return "Thanks for your ratings";
    }

//    @PostMapping("/Search/{text}")
//    public List<Tutor> search(@PathVariable String text){
//        return searchRepo.findByText(text);
//
//    }


}
